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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class get information from Database through DAO Layer.<br>
 * The class supplies methods use for display Manage quiz page<br>
 * This class extends BaseRequireLoginServlet<br>
 *
 * @author phuon
 */
public class ManageQuizServlet extends BaseRequireLoginServlet {

    /**
     * Load Manage quiz page
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            QuestionDAO questionDAO = new QuestionDAO();
            List<Question> questions = questionDAO.getQuestions(account);

            request.setAttribute("questions", questions);
            request.setAttribute("numOfQuestion", questions.size());
            request.getRequestDispatcher("manage-quiz.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Page not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
