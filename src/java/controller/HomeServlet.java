/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package controller;

import dao.impl.AccountDAO;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class get information from Database through DAO Layer.<br>
 * The class supplies methods use for display Home page & login<br>
 *
 * @author phuon
 */
public class HomeServlet extends HttpServlet {

    /**
     * Load Home page
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    /**
     * Perform login process.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();

            AccountDAO accountDAO = new AccountDAO();
            Account account = accountDAO.getAccount(username, password);
            if (account == null) { // login fail
                request.setAttribute("loginSuccess", false);
            } else { // login success
                request.getSession(true).setAttribute("account", account);
                request.setAttribute("loginSuccess", true);
            }
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Home page not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
