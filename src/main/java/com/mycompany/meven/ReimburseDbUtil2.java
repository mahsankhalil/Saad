package com.mycompany.meven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReimburseDbUtil2 {
	
	 
	
public List<Reimbursement> getReimbursements(HttpServletRequest request, HttpServletResponse response) throws Exception {
	HttpSession session = request.getSession(true);
	String username = (String)session.getAttribute("username");
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
	
			//get a connection 
			Class.forName("org.postgresql.Driver");
			try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123")) {
			//myConn = dataSource.getConnection();
			//create sql statement
			String sql = "select * from reimbursement_table where user_name="+"'"+username+"';";			
			myStmt = conn.createStatement();
			
			//execute query
			myRs = myStmt.executeQuery(sql);
			//process result set
			
			while (myRs.next()) {
				
				// retrieve data from result set row
				
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String userName = myRs.getString("user_name");
				String schoolName = myRs.getString("school_name");
				String receiptLink = myRs.getString("receipt_link");
				String managerEmail = myRs.getString("manager_email");
				String submitDate = myRs.getString("submit_date");
				String courseStartDate = myRs.getString("course_start_date");
				String courseEndDate = myRs.getString("course_end_date");
				String approvedByUsername = myRs.getString("approved_by_username");
				String approvalDate = myRs.getString("approval_date");
				String proofOfCompletionLink = myRs.getString("proof_of_completion_link");
				int ReimbursementId = myRs.getInt("reimbursement_id");
				
				// create new reimbursement object
				Reimbursement tempReimbursement = new Reimbursement(firstName, lastName, userName, schoolName, receiptLink,
						managerEmail, submitDate, courseStartDate, courseEndDate,
						approvedByUsername, approvalDate, proofOfCompletionLink, ReimbursementId);
				// add it to the list of reimbursements
				
				reimbursements.add(tempReimbursement);
			}
			
			
			
			return reimbursements;
		
		} 
		finally {
			//close JDBC objects
			close(myConn, myStmt, myRs);
		}
		
}

private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

	try {
		if (myRs != null) {
			myRs.close();
		}
		if (myStmt != null) {
			myStmt.close();
		}
		if (myConn != null) {
			myConn.close(); // doesn't really close it... just puts back in connection pool.
			//if you do not close this in a real life application over time it will eventually run into problems
			//when running out of resources.
		}
		
	}
	catch (Exception exc) {
		exc.printStackTrace();
	}
	
}


public void addReimbursement(Reimbursement theReimbursement) throws Exception {
	PreparedStatement myStmt = null;
	Connection myConn = null;

		//get a connection 
		Class.forName("org.postgresql.Driver");
			try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123")) {
				conn.setAutoCommit(false);
		//create sql statement for insert
		String sql = "insert into reimbursement_table " + "(first_name, last_name, user_name, school_name, receipt_link, manager_email, submit_date, course_start_date, course_end_date, approved_by_username, approval_date, proof_of_completion_link) " + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		myStmt = conn.prepareStatement(sql);
		//set the param values for the employee
		myStmt.setString(1,  theReimbursement.getFirstName());
		myStmt.setString(2,  theReimbursement.getLastName());
		myStmt.setString(3,  theReimbursement.getUserName());
		myStmt.setString(4,  theReimbursement.getSchoolName());
		myStmt.setString(5,  theReimbursement.getReceiptLink());
		myStmt.setString(6,  theReimbursement.getManagerEmail());
		myStmt.setString(7,  theReimbursement.getSubmitDate());
		myStmt.setString(8,  theReimbursement.getCourseStartDate());
		myStmt.setString(9,  theReimbursement.getCourseEndDate());
		myStmt.setString(10, theReimbursement.getApprovedByUsername());
		myStmt.setString(11, theReimbursement.getApprovalDate());
		myStmt.setString(12, theReimbursement.getProofOfCompletionLink());
		//execute sql insert
		
		myStmt.execute();
	
		conn.commit();
		
		
	
	
	} 
	finally {
		//clean up JDBC objects
		close(myConn,myStmt, null);
	}
	
}


public Reimbursement getReimbursement(String theReimbursementId) throws Exception{

	Reimbursement theReimbursement = null;
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	int reimbursementId;

		//convert id to int
		reimbursementId = Integer.parseInt(theReimbursementId);
		//get a connection 
		Class.forName("org.postgresql.Driver");
			try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123")) {
				
			
			// create sql to get selected student
			String sql = "select * from reimbursement_table where reimbursement_id = ?";
			// create prepared Statement
			myStmt = conn.prepareStatement(sql);
			// set params
			myStmt.setInt(1, reimbursementId);
			// execute statement
			myRs = myStmt.executeQuery();
			// retrieve data from result set row
			if (myRs.next()) {
				
				// retrieve data from result set row
				
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String userName = myRs.getString("user_name");
				String schoolName = myRs.getString("school_name");
				String receiptLink = myRs.getString("receipt_link");
				String managerEmail = myRs.getString("manager_email");
				String submitDate = myRs.getString("submit_date");
				String courseStartDate = myRs.getString("course_start_date");
				String courseEndDate = myRs.getString("course_end_date");
				String approvedByUsername = myRs.getString("approved_by_username");
				String approvalDate = myRs.getString("approval_date");
				String proofOfCompletionLink = myRs.getString("proof_of_completion_link");
				int ReimbursementId = myRs.getInt("reimbursement_id");
				
				// create new reimbursement object
				theReimbursement = new Reimbursement(firstName, lastName, userName, schoolName, receiptLink,
						managerEmail, submitDate, courseStartDate, courseEndDate,
						approvedByUsername, approvalDate, proofOfCompletionLink, ReimbursementId);
				
				
				
			} else {
				throw new Exception("Could not locate reimbursement id: " + reimbursementId);
				
				
			}
			

		return theReimbursement;
		
		
	
	
	} 
	finally {
		//clean up JDBC objects
		close(myConn,myStmt, null);
	}
	
	
	
	
	

	
}


public void updateReimbursement(Reimbursement theReimbursement) throws Exception{
	
	Connection myConn = null;
	
	PreparedStatement myStmt = null;
	
	    //get a connection 
		Class.forName("org.postgresql.Driver");
			try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123")) {
				
			conn.setAutoCommit(true);
			
			// create SQL update Statement
			
			String sql = "update reimbursement_table " + "set first_name=?, last_name=?, user_name=?, school_name=?, receipt_link=?, manager_email=?, submit_date=?, course_start_date=?, course_end_date=?, approved_by_username=?, approval_date=?, proof_of_completion_link=? " + "where reimbursement_id=?;";			
			
			// Prepare Statement
			
			myStmt = conn.prepareStatement(sql);
			
			// set params
		
			myStmt.setString(1,  theReimbursement.getFirstName());
			myStmt.setString(2,  theReimbursement.getLastName());
			myStmt.setString(3,  theReimbursement.getUserName());
			myStmt.setString(4,  theReimbursement.getSchoolName());
			myStmt.setString(5,  theReimbursement.getReceiptLink());
			myStmt.setString(6,  theReimbursement.getManagerEmail());
			myStmt.setString(7,  theReimbursement.getSubmitDate());
			myStmt.setString(8,  theReimbursement.getCourseStartDate());
			myStmt.setString(9,  theReimbursement.getCourseEndDate());
			myStmt.setString(10, theReimbursement.getApprovedByUsername());
			myStmt.setString(11, theReimbursement.getApprovalDate());
			myStmt.setString(12, theReimbursement.getProofOfCompletionLink());
			myStmt.setInt(13, theReimbursement.getReimbursementId());
					
			// execute statement
			
			myStmt.executeUpdate();
	} 
		
	finally {
		//clean up JDBC objects
		close(myConn,myStmt, null);
	}

	
	
}


public void deleteReimbursement(String theReimbursementId) throws Exception{
	Connection myConn = null;
	PreparedStatement myStmt = null;
		//get a connection 
		Class.forName("org.postgresql.Driver");
			try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123")) {
				//convert id to int
			int reimbursementId = Integer.parseInt(theReimbursementId);
			// create SQL delete Statement
			String sql = "delete from reimbursement_table where reimbursement_id=?";			
			// Prepare Statement
			myStmt = conn.prepareStatement(sql);
			// set params
			myStmt.setInt(1, reimbursementId);
			// execute statement
			myStmt.execute();
	} 
	finally {
		//clean up JDBC objects
		close(myConn,myStmt, null);
	}
	
}
}
