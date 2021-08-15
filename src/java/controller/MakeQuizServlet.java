/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package controller;

import dao.impl.QuestionDAO;
import entity.Account;
import entity.Question;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class get information from Database through DAO Layer.<br>
 * The class supplies methods use for display Make question page<br>
 * and perform create new question process.<br>
 * This class extends BaseRequireLoginServlet<br>
 *
 * @author phuon
 */
public class MakeQuizServlet extends BaseRequireLoginServlet {

    /**
     * Display make request page
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("make-quiz.jsp").forward(request, response);
    }

    /**
     * Perform make new question action.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String question = request.getParameter("question").trim();
            String option1 = request.getParameter("option1").trim();
            String option2 = request.getParameter("option2").trim();
            String option3 = request.getParameter("option3").trim();
            String option4 = request.getParameter("option4").trim();
            String solution = "";
            // solution = string of all checkbox values
            for (String answer : request.getParameterValues("answer")) {
                solution += answer;
            }
            Date dateCreated = new Date(Calendar.getInstance().getTimeInMillis());
            Account createdBy = (Account) request.getSession().getAttribute("account");

            Question q = new Question();
            q.setQuestion(question);
            q.setOption1(option1);
            q.setOption2(option2);
            q.setOption3(option3);
            q.setOption4(option4);
            q.setSolution(solution);
            q.setDateCreated(dateCreated);
            q.setCreatedBy(createdBy);
            QuestionDAO questionDAO = new QuestionDAO();
            questionDAO.insert(q);
            request.getRequestDispatcher("make-quiz.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Page not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
