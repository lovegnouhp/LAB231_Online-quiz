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
 * The class supplies methods use for display Register page<br>
 * and register new account<br>
 *
 * @author phuon
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Display register page.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").include(request, response);
    }

    /**
     * Perform register process.
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
            boolean isTeacher = request.getParameter("user-type").equals("1");
            String email = request.getParameter("email").trim();

            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            account.setIsTeacher(isTeacher);
            account.setEmail(email);

            AccountDAO accountDAO = new AccountDAO();
            boolean isSuccess = accountDAO.insertAccount(account);
            if (isSuccess) { // create account successfull
                response.sendRedirect("home");
            } else { // can not add: username already exist.
                request.setAttribute("registerSuccess", isSuccess);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Page not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
