/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import daos.SinhVienDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Lop;

/**
 *
 * @author manhq
 */
@WebServlet(name = "AdminTraineeEditController", urlPatterns = {"/admin/trainee/edit"})
public class AdminTraineeEditController extends HttpServlet {

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
            response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		SinhVienDAO sinhvienDAO = new SinhVienDAO();
		
			int masv = Integer.parseInt(request.getParameter("id"));
		
		String tensv = request.getParameter("tensv");
		String diachi = request.getParameter("diachi");
		int sdt = 0;
		try {
			sdt = Integer.parseInt(request.getParameter("sdt"));
		} catch (NumberFormatException e) {
			System.out.println("Lỗi..!");
		}
		String email = request.getParameter("email");
		int malop = 0;
		try {
			malop = Integer.parseInt(request.getParameter("malop"));
		} catch (NumberFormatException e) {
			System.out.println("Lỗi..!");
		}

		sinhvienDAO.update( tensv, diachi, sdt, email, new Lop(malop,null),masv);
		try {
			response.sendRedirect(request.getContextPath()+"/admin/trainee?msg=OK");
			return;
		}catch(Exception e) {
			response.sendRedirect(request.getContextPath()+"/admin/trainee?msg=ERROR");
			return;
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
