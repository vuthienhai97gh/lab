/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haivt.servlet;

import haivt.registration.RegistrationCreateError;
import haivt.registration.RegistrationDAO;
import haivt.utils.PasswordUtilities;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vuthi
 */
public class CreateNewAccountServlet extends HttpServlet {

    private final String ShowInserErr = "createNewAccount.jsp";
    private final String LoginPage = "login.jsp";

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("txtEmail");
        String name = request.getParameter("txtName");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");

        boolean error = false;
        RegistrationCreateError errors = new RegistrationCreateError();
        String url = ShowInserErr;
        try {
            if (email.trim().length() == 0) {
                error = true;
                errors.setEmailErr("Email khong duoc de trong");
            } else if (!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
                error = true;
                errors.setEmailErr("Email phai dung dinh dang vd: ???@????.???");
            }
            if (name.trim().length() == 0) {
                error = true;
                errors.setNameErr("Name ko dc de trong");
            }
            if (password.trim().length() == 0) {
                error = true;
                errors.setPasswordErr("Password khong dc de trong");
            } else if (!confirm.trim().equals(password.trim())) {
                error = true;
                errors.setConfirmNotMatch("confirm phai dung vs password");
            }
            if (error) {
                request.setAttribute("INSERTERR", errors);
            } else {
                RegistrationDAO dao = new RegistrationDAO();

                PasswordUtilities pass = new PasswordUtilities();
                password = pass.getEncryptPassword(password);

                boolean result = dao.createAccount(email, name, password);
                if (result) {
                    url = LoginPage;
                }
            }
        } catch (NamingException ex) {
            log("CreateNewAccountServlet _ Naming: " + ex.getMessage());
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("CreateAccountServlet _ SQL: " + msg);
            if (msg.contains("duplicate")) {
                errors.setEmailIsExisted(email + " da ton tai!!!");
                request.setAttribute("INSERTERR", errors);
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateNewAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CreateNewAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
