/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vuthi
 */
public class ControllerServlet extends HttpServlet {

    private final String loginServlet = "LoginServlet";
    private final String logoutServlet = "LogoutServlet";
    private final String loginPage = "login.jsp";
    private final String searchServlet = "SearchServlet";
    private final String deleteServlet = "DeleteServlet";
    private final String updateServlet = "UpdateServlet";
    private final String nullServlet = "NullServlet";
    private final String createAccountServlet = "CreateNewAccountServlet";
    private final String takeQuizServlet = "TakeQuizServlet";
    private final String forwardQuestionServlet = "ForwardQuestionServlet";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String button = request.getParameter("btAction");
            String url = loginPage;

            if (button == null) {
                url = nullServlet;
            } else if (button.equals("Login")) {
                url = loginServlet;
            } else if (button.equals("Logout")) {
                url = logoutServlet;
            } else if (button.equals("Search")) {
                url = searchServlet;
            } else if (button.equals("del")) {
                url = deleteServlet;
            } else if (button.equals("Update")) {
                url = updateServlet;
            } else if (button.equals("Create New Account")) {
                url = createAccountServlet;
            } else if (button.equals("Take Quiz")) {
                url = takeQuizServlet;
            } else if (button.equals("Next")) {
                request.setAttribute("ACTION", "Next");
                url = forwardQuestionServlet;
            } else if (button.equals("Previous")) {
                request.setAttribute("ACTION", "Previous");
                url = forwardQuestionServlet;
            }

            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } finally {
            out.close();
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
