package com.mycompany.meven;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/**
 * Servlet implementation class ReimbursementControllerServlet
 */
@WebServlet("/ReimbursementControllerServlet")
public class ReimbursementControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReimburseDbUtil reimburseDbUtil;
	
	
	 @Resource(name="jdbc/postgres") 
	 	private DataSource dataSource;
	 
	
	 @Override 
	 public void init() throws ServletException {
	 super.init();
	 
	  // create our reimburse db util and pass in the connection pool
	 	try {
		 reimburseDbUtil = new ReimburseDbUtil();
	 	}
	 	catch (Exception exc) {
	 		throw new ServletException(exc);
	 	}
	  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			// read command parameter
			String theCommand = request.getParameter("command");
			
			
			//if the commmand is not represent then just list requests
			if (theCommand == null) {
				theCommand="LIST";
			}
			
			switch (theCommand) {
			
			case "LIST":
				listReimbursements(request, response);
				break;
			case "ADD":
				addReimbursement(request, response);
				break;
			case "LOAD":
				loadReimbursement(request, response);
				break;
			case "UPDATE":
				updateReimbursement(request, response);
				break;
			case "DELETE":
				deleteReimbursement(request, response);
				break;
			default:
				listReimbursements(request, response);
			}
			
		 } catch (Exception exc) {
			 throw new ServletException(exc);
		 }
		
	}




	private void deleteReimbursement(HttpServletRequest request, HttpServletResponse response) throws Exception{

		// read id from form data
		String theReimbursementId = request.getParameter("reimbursementId");
		// delete from database
		reimburseDbUtil.deleteReimbursement(theReimbursementId);
		// send back to list page
		listReimbursements(request, response);
	}

	private void updateReimbursement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read info from form data
		int id = Integer.parseInt(request.getParameter("reimbursementId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String schoolName = request.getParameter("schoolName");
		String receiptLink = request.getParameter("firstName");
		String managerEmail = request.getParameter("managerEmail");
		String submitDate = request.getParameter("submitDate");
		String courseStartDate = request.getParameter("courseStartDate");
		String courseEndDate = request.getParameter("courseEndDate");
		String approvedByUsername = request.getParameter("approvedByUsername");
		String approvalDate = request.getParameter("approvalDate");
		String proofOfCompletionLink = request.getParameter("proofOfCompletionLink");
		// create a new object
		Reimbursement theReimbursement = new Reimbursement(firstName, lastName, userName, schoolName, receiptLink,
				managerEmail, submitDate, courseStartDate, courseEndDate,
				approvedByUsername, approvalDate, proofOfCompletionLink, id);
		// perform update on database
		reimburseDbUtil.updateReimbursement(theReimbursement);
		// send back to the list page
		listReimbursements(request, response);
		
		
		
	}

	private void loadReimbursement(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read reimbursement id from form
		String theReimbursementId = request.getParameter("reimbursementId");
		// get reimbursement from database (db util)
		Reimbursement theReimbursement = reimburseDbUtil.getReimbursement(theReimbursementId);
		// place employee in the request attribute
		request.setAttribute("THE_REIMBURSEMENT",  theReimbursement);
		// send to update-reimbursement-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-reimbursement-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addReimbursement(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
			//read reimbursement info from form data
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String userName = request.getParameter("userName");
			String schoolName = request.getParameter("schoolName");
			String receiptLink = request.getParameter("firstName");
			String managerEmail = request.getParameter("managerEmail");
			String submitDate = request.getParameter("submitDate");
			String courseStartDate = request.getParameter("courseStartDate");
			String courseEndDate = request.getParameter("courseEndDate");
			String approvedByUsername = request.getParameter("approvedByUsername");
			String approvalDate = request.getParameter("approvalDate");
			String proofOfCompletionLink = request.getParameter("proofOfCompletionLink");
		
				//create a new employee object
				Reimbursement theReimbursement = new Reimbursement(firstName, lastName, userName, schoolName, receiptLink,
						managerEmail, submitDate, courseStartDate, courseEndDate,
						approvedByUsername, approvalDate, proofOfCompletionLink);
				//add the reimbursement to the database
				reimburseDbUtil.addReimbursement(theReimbursement);
				//send back to main page (the list)
				listReimbursements(request, response);
	}

	private void listReimbursements(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
				// get employees from db util
		List<Reimbursement> reimbursements = reimburseDbUtil.getReimbursements(); 
				// add employees to the request
				request.setAttribute("REIMBURSEMENTS_LIST", reimbursements);
				// send to JSP page (view)
				RequestDispatcher dispatcher = request.getRequestDispatcher("/list-reimbursements.jsp");
				dispatcher.forward(request, response);
				return;
	}


}
