/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package controller;

import dao.impl.QuestionDAO;
import entity.Question;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phuon
 */
public class TakeQuizServlet extends BaseRequireLoginServlet {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Question> bank = (List<Question>) request.getSession().getAttribute("bank");
            if (bank == null) { // start new test: select number of request
                QuestionDAO questionDAO = new QuestionDAO();
                int totalQuest = questionDAO.getTotalQuestions();
                request.setAttribute("totalQuest", totalQuest);
                request.getRequestDispatcher("take-quiz.jsp").forward(request, response);
            } else { // doing the test
                request.getRequestDispatcher("take-quiz-do.jsp").include(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Page not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Question> bank = (List<Question>) request.getSession().getAttribute("bank");
            if (bank == null) { // start new test: get question lists
                int numOfQuests = Integer.parseInt(request.getParameter("num-of-quest"));
                QuestionDAO questionDAO = new QuestionDAO();
                bank = questionDAO.getRandomQuestions(numOfQuests);
                Calendar currentTime = Calendar.getInstance();
                currentTime.add(Calendar.MINUTE, numOfQuests);

                request.getSession().setAttribute("bank", bank);
                request.getSession().setAttribute("expiredTime", currentTime.getTimeInMillis());
                request.getSession().setAttribute("currentIndex", 0);
                request.getSession().setAttribute("score", 0.0);
            } else { // doing the test (after hit button next)
                int currentIndex = (int) request.getSession().getAttribute("currentIndex");
                String[] answers = request.getParameterValues("answer");

                if (answers != null) { // user not skip this question
                    String userChoices = "";
                    // solution = string of all checkbox values
                    for (String a : answers) {
                        userChoices += a;
                    }
                    double marks = getMark(userChoices, bank.get(currentIndex).getSolution());
                    double score = (double) request.getSession().getAttribute("score");
                    request.getSession().setAttribute("score", score + marks);
                }

                long currentTime = Calendar.getInstance().getTimeInMillis();
                long expiredTime = (long) request.getSession().getAttribute("expiredTime");
                if (bank.size() == currentIndex + 1
                        || currentTime >= expiredTime) { // last question or timeout ~> show result
                    request.getRequestDispatcher("take-quiz-result").forward(request, response);
                    return;
                } else { // move to next question
                    currentIndex++;
                    request.getSession().setAttribute("currentIndex", currentIndex);
                }
            }
            request.getRequestDispatcher("take-quiz-do.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("error", "Page not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private double getMark(String userChoices, String solution) {
        int count = 0;

        for (int i = 0; i < userChoices.length(); i++) {
            // option also in solution string ~> count++
            if (solution.contains(userChoices.charAt(i) + "")) {
                count++;
            } else { // have at least 1 wrong option ~> 0 mark
                count = -1;
                break;
            }
        }
        // mark = number correct option / total * 1
        return count != -1 ? (double) count / solution.length() : 0;
    }
}
