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

/**
 *
 * @author Faizan-Ahmad
 */
@WebServlet(name = "ListReimbursements2Ajax", urlPatterns = {"/ListReimbursements2Ajax"})
public class ListReimbursements2Ajax extends HttpServlet {

    private ReimburseDbUtil2 reimburseDbUtil2= new ReimburseDbUtil2() ;
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
        
        try (PrintWriter out = response.getWriter()) {
           
            List<Reimbursement> reimbursements =new ArrayList();
            try {
                reimbursements = reimburseDbUtil2.getReimbursements(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ListReimbursements2Ajax.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            String html="";
            html=html+"<tr><th>First Name</th>";
            html=html+"<th>Last Name</th>";
            html=html+"<th>Email</th>";
            html=html+"<th>Learning Institution Name</th>";
            html=html+"<th>Receipt Link</th>";
            html=html+"<th>Proof Of Completion Link</th>";
            html=html+"<th>Manager Email</th>";
            html=html+"<th>Submit Date</th>";
            html=html+"<th>Start Date</th>";
            html=html+"<th>Completion Date</th>";
            html=html+"<th>Approved By (Email)</th>";
            html=html+"<th>Approval Date</th>";
            html=html+"<th>Reimbursement ID#</th>";
            html=html+"<th>Revision</th><tr>";
            for(Reimbursement obj : reimbursements)
            {
                html=html+"<tr>";
                html=html+"<td>"+obj.getFirstName()+"</td>";
                html=html+"<td>"+obj.getLastName()+"</td>";
                html=html+"<td>"+obj.getUserName()+"</td>";
                html=html+"<td>"+obj.getSchoolName()+"</td>";
                html=html+"<td>"+obj.getReceiptLink()+"</td>";
                html=html+"<td>"+obj.getProofOfCompletionLink()+"</td>";
                html=html+"<td>"+obj.getManagerEmail()+"</td>";
                html=html+"<td>"+obj.getSubmitDate()+"</td>";
                html=html+"<td>"+obj.getCourseStartDate()+"</td>";
                html=html+"<td>"+obj.getCourseEndDate()+"</td>";
                html=html+"<td>"+obj.getApprovedByUsername()+"</td>";
                html=html+"<td>"+obj.getApprovalDate()+"</td>";
                html=html+"<td>"+obj.getReimbursementId()+"</td>";
                html=html+"<td><a href='./ReimbursementControllerServlet?command=LOAD&reimbursementId="+obj.getReimbursementId()+"'>Update</a></td></tr>";
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
