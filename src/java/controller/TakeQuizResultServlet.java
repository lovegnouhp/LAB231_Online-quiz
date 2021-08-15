/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package controller;

import entity.Question;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class get information from Database through DAO Layer.<br>
 * The class supplies methods use for display test result<br>
 * in Take quiz page<br>
 *
 * @author phuon
 */
@WebServlet(name = "TakeQuizResultServlet", urlPatterns = {"/take-quiz-result"})
public class TakeQuizResultServlet extends HttpServlet {

    /**
     * Display test result
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double score = (double) request.getSession().getAttribute("score");
        List<Question> bank = (List<Question>) request.getSession().getAttribute("bank");
        int numOfQuests = bank.size();
        double percent = score / numOfQuests;

        request.setAttribute("score", score);
        request.setAttribute("percent", percent);
        request.getSession().removeAttribute("bank");
        request.getSession().removeAttribute("expiredTime");
        request.getSession().removeAttribute("currentIndex");
        request.getSession().removeAttribute("score");
        request.getRequestDispatcher("take-quiz-result.jsp").forward(request, response);
    }
}
