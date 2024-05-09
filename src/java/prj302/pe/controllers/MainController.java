/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj302.pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private final static String WELCOME = "login.jsp";
    private final static String LOGIN = "Login";
    private final static String LOGIN_CONTROLLER = "LoginController";

    private final static String SEARCH = "Search";
    private final static String SEARCH_CONTROLLER = "SearchController";

    private final static String LOGOUT = "Logout";
    private final static String LOGOUT_CONTROLLER = "LogoutController";

    private final static String UPDATE = "Update";
    private final static String UPDATE_CONTROLLER = "UpdateController";
    
    private final static String DELETE = "Delete";
    private final static String DELETE_CONTROLLER = "DeleteController";
    
    private final static String CREATE_PAGE = "CreatePage";
    private final static String CREATE_PAGE_VIEW="create.jsp";
     
    private final static String CREATE = "Create";
    private final static String CREATE_CONTROLLER="CreateController";
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = WELCOME;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equalsIgnoreCase(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SEARCH.equalsIgnoreCase(action)) {
                url = SEARCH_CONTROLLER;
            } else if (LOGOUT.equalsIgnoreCase(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (UPDATE.equalsIgnoreCase(action)) {
                url = UPDATE_CONTROLLER;
            } else if (DELETE.equalsIgnoreCase(action)) {
                url = DELETE_CONTROLLER;
            }else if (CREATE_PAGE.equalsIgnoreCase(action)) {
                url = CREATE_PAGE_VIEW;
            }else if (CREATE.equalsIgnoreCase(action)) {
                url = CREATE_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
