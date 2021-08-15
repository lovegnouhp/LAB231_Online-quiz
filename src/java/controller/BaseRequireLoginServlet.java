/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package controller;

import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class supplies abstract class to check access of user login or not.<br>
 *
 * @author phuon
 */
public abstract class BaseRequireLoginServlet extends HttpServlet {

    /**
     * Check access of user to page.
     *
     * @param request request from HttpServlet
     * @return status can access page or not
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private boolean isAcceptedAccessing(HttpServletRequest request) {
        Account account = (Account) request.getSession(true).getAttribute("account");
        if (account == null) {
            return false;
        } else {
            /* normal user: only page take quiz
             * teacher: access all take quiz, make quiz & manage quiz */
            return (account.isIsTeacher() || request.getServletPath().equals("/take-quiz"));
        }
    }

    /**
     * Implement doGet process of child class.
     *
     * @param request request from HttpServlet
     * @param response response from HttpServlet
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * Implement doPost process of child class.
     *
     * @param request request from HttpServlet
     * @param response response from HttpServlet
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    /**
     * Pre-process doGet action, prevent user access if they don't have access.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAcceptedAccessing(request)) {
            processGet(request, response);
        } else {
            request.setAttribute("error", "Access denied.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Pre-process doPost action, prevent user access if they don't have access.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAcceptedAccessing(request)) {
            processPost(request, response);
        } else {
            request.setAttribute("error", "Access denied.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
