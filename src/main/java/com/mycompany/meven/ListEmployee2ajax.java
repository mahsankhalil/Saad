/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.meven;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Faizan-Ahmad
 */
@WebServlet(name = "ListEmployee2ajax", urlPatterns = {"/ListEmployee2ajax"})
public class ListEmployee2ajax extends HttpServlet {

    private EmployeeDbUtil2 employeeDbUtil2=new EmployeeDbUtil2();
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
        HttpSession session = request.getSession(); 
		// get employees from db util
	String x = (String)session.getAttribute("username");
        try (PrintWriter out = response.getWriter()) {
            List<Employee> employees=new ArrayList();
            try {
                employees = employeeDbUtil2.getEmployees(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ListEmployee2ajax.class.getName()).log(Level.SEVERE, null, ex);
            }
            String html="";
            html=html+"<tr><th>Email</th>";
            html=html+"<th>Password</th>";
            html=html+"<th>Access Level</th>";
            html=html+"<th>DOB</th>";
            html=html+"<th>First Name</th>";
            html=html+"<th>Last Name</th>";
            html=html+"<th>Manager Email</th>";
            html=html+"<th>Revision</th><tr>";
            for(Employee obj : employees)
            {
                html=html+"<tr>";
                html=html+"<td>"+obj.getUserName()+"</td>";
                html=html+"<td>"+obj.getPassWord()+"</td>";
                html=html+"<td>"+obj.getAccessLevel()+"</td>";
                html=html+"<td>"+obj.getDob()+"</td>";
                html=html+"<td>"+obj.getFirstName()+"</td>";
                html=html+"<td>"+obj.getLastName()+"</td>";
                html=html+"<td>"+obj.getManagerEmail()+"</td>";
                html=html+"<td><a href='./EmployeeControllerServlet?command=LOAD&employeeId="+obj.getId()+"'>Update</a>"+
						"</td></tr>";
            }
            out.println(html);
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
