package com.mycompany.meven;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
/**
 * Servlet implementation class EmployeeControllerServlet
 */
@WebServlet("/EmployeeControllerServlet3")
public class EmployeeControllerServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private EmployeeDbUtil employeeDbUtil;
	 private EmployeeDbUtil2 employeeDbUtil2;
	 
	 @Resource(name="jdbc/postgres")
		private DataSource dataSource;
	 
	 @Override 
	 public void init() throws ServletException {
	 super.init();
	 
	// create our reimburse db util and pass in the connection pool
		 try {
			 employeeDbUtil = new EmployeeDbUtil();
		 } catch (Exception exc) {
			 throw new ServletException(exc);
		 }
		 
		 try {
			 employeeDbUtil2 = new EmployeeDbUtil2();
		 } catch (Exception exc) {
			 throw new ServletException(exc);
		 }
		  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			// read command parameter
			String theCommand = request.getParameter("command");
			
			
			//if the commmand is not represent then just list employees
			if (theCommand == null) {
				theCommand="LIST";
			}
			
			//route to correct method
			switch (theCommand) {
			
			case "LIST":
					listEmployees(request, response);
					break;
					
			case "ADD":
				addEmployee(request, response);
				break;
			case "LOAD":
				loadEmployee(request, response);
				break;
			case "UPDATE":
				updateEmployee(request, response);
				break;
			case "DELETE":
				deleteEmployee(request, response);
				break;
			default:
				listEmployees(request, response);
			
			}
		} 
		catch (Exception exc) {
			throw new ServletException(exc);
					
		}
	
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read id from form data
		String theEmployeeId = request.getParameter("employeeId");
		// delete from database
		employeeDbUtil.deleteEmployee(theEmployeeId);
		// send back to list page
		listEmployees(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
				// read info from form data
				int id = Integer.parseInt(request.getParameter("employeeId"));
				String userName = request.getParameter("userName");
				String passWord = request.getParameter("passWord");
				String accessLevel = request.getParameter("accessLevel");
				String dob = request.getParameter("dob");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String managerEmail = request.getParameter("managerEmail");
				// create a new object
				Employee theEmployee = new Employee(userName, passWord, accessLevel, dob, firstName, lastName, managerEmail, id);
				// perform update on database
				employeeDbUtil.updateEmployee(theEmployee);
				// send back to the list page
				listEmployees(request, response);
		
		
		
		
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read employee id from form data
		String theEmployeeId = request.getParameter("employeeId");
		
		// get student from database (db util)
		Employee theEmployee = employeeDbUtil.getEmployee(theEmployeeId);

		// place reimbursement in the request attribute
		request.setAttribute("THE_EMPLOYEE",  theEmployee);
		// send to update-employee-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-employee-form3.jsp");
		dispatcher.forward(request, response);
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//read employee info from form data
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String accessLevel = request.getParameter("accessLevel");
		String dob = request.getParameter("dob");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String managerEmail = request.getParameter("managerEmail");

		//create a new employee object
		Employee theEmployee = new Employee(userName, passWord, accessLevel, dob, firstName, lastName, managerEmail);
		//add the reimbursement to the database
		employeeDbUtil.addEmployee(theEmployee);
		//send back to main page (the list)
		listEmployees(request, response);
		
	}

	

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession(); 
		// get employees from db util
		String x = (String)session.getAttribute("username");
		List<Employee> employees = employeeDbUtil2.getEmployees(request, response);
		// add employees to the request
		request.setAttribute("EMPLOYEES_LIST", employees);
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees3.jsp");
		dispatcher.forward(request, response);
		
	}
	

	

}
