/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj302.pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import prj302.pe.user.UserDAO;
import prj302.pe.user.UserDTO;

/**
 *
 * @author TTNHAT
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private final static String ERROR = "SearchController";
    private final static String SUCCESS = "SearchController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String url = ERROR;
       try{
           String userID =  request.getParameter("userID");
           String fullName = request.getParameter("fullName");
           String roleID = request.getParameter("roleID");
           UserDAO dao = new UserDAO();
           UserDTO user = new UserDTO(userID, fullName, roleID, "");
           boolean check = dao.updateUser(user);
           if(check){
               HttpSession session = request.getSession();
               UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
               if(loginUser.getUserID().equals(userID)){
                   loginUser.setFullName(fullName);
                   loginUser.setRoleID(roleID);
                   session.setAttribute("LOGIN_USER", loginUser);
               }
               url=SUCCESS;
           }else{
               request.setAttribute("ERROR", "Unable to update user");
           }
           
       }catch (Exception e){
           log("Error at UpdateController "+e.toString());
       }finally{
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
