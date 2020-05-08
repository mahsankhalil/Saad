package com.mycompany.meven;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class TRMSLoginServlet
 */
@WebServlet("/TRMSLoginServlet")
public class TRMSLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TRMSLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String enteredUserName = request.getParameter("username"); //this is the same as name value from login form
		String enteredPassword = request.getParameter("password");
		RequestDispatcher rd = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/", "postgres",
				"andress10")) {
			
				Statement first_stmt = null;
				String first_query = "select user_name, pass_word, access_level from employees where user_name = " + "'" + enteredUserName + "';";
				
				first_stmt = conn.createStatement();
				
				ResultSet rs = first_stmt.executeQuery(first_query);
				
				while (rs.next()) {
					int accessLevel_db = rs.getInt("access_level");	
					String username_db = rs.getString("user_name");
					String password_db = rs.getString("pass_word");
				
					
					
			/*TRMSLoginDao access = new TRMSLoginDao();
				//access.login(userName.toString(), password.toString());
				
			//problem is right here accessLevel never gets updated stays at 0
				if(TRMSLoginDao.login(userName, password)) {*/
			
					
					
			if (enteredUserName.equals(username_db) && enteredPassword.equals(password_db) && accessLevel_db == 3) {
				//establish session stuff
				HttpSession session = request.getSession(); //create session object
				session.setAttribute("username", enteredUserName); // used session to set session attribute
				session.setAttribute("password", enteredPassword); // sets password attribute
				//String entered_UserName = (String) session.getAttribute("username");
				//establish session stuff
				
				rd = request.getRequestDispatcher("/DistrictManagerHome.jsp");
				rd.forward(request, response);
			} else if (enteredUserName.equals(username_db) && enteredPassword.equals(password_db) && accessLevel_db == 2) {
				//establish session stuff
				HttpSession session = request.getSession(); //create session object
				session.setAttribute("username", enteredUserName); // used session to set session attribute
				session.setAttribute("password", enteredPassword); // sets password attribute
				//establish session stuff
				
				rd = request.getRequestDispatcher("/ManagmentHome.jsp");
				rd.forward(request, response);
			} else if (enteredUserName.equals(username_db) && enteredPassword.equals(password_db) && accessLevel_db == 1) {
				//establish session stuff
				HttpSession session = request.getSession(); //create session object
				session.setAttribute("username", enteredUserName); // used session to set session attribute
				session.setAttribute("password", enteredPassword); // sets password attribute
				//establish session stuff
				
				rd = request.getRequestDispatcher("/EmployeeHome.jsp");
				rd.forward(request, response);
			} else { 
				rd = request.getRequestDispatcher("/error.html");
				rd.forward(request, response);
			}
			
			
			}
			} catch (Exception e) {
				e.printStackTrace();
		}
	
	}
	
	}



