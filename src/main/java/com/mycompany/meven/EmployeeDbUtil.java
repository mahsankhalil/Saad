package com.mycompany.meven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class EmployeeDbUtil {
	

public List<Employee> getEmployees() throws Exception {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
	
			//get a connection 
			//Class.forName("com.mysql.jdbc.Driver");
                       Class.forName("org.postgresql.Driver");
			try {
			//create sql statement
                         Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123");
			String sql = "select * from employees order by manager_email;";
			
			myStmt = conn.createStatement();
			//execute query
			myRs = myStmt.executeQuery(sql);
			//process result set
			
			while (myRs.next()) {
				
				// retrieve data from result set row
				
				String userName = myRs.getString("user_name");
				String passWord = myRs.getString("pass_word");
				String accessLevel = myRs.getString("access_level");
				String dob = myRs.getString("d_o_b");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String managerEmail = myRs.getString("manager_email");
				int id = myRs.getInt("i_d");
				
				// create new employee object
				Employee tempEmployee = new Employee(userName, passWord, accessLevel, dob, firstName, lastName,
						managerEmail, id);
				// add it to the list of reimbursements
				
				employees.add(tempEmployee);
			}
			return employees;
		
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


public void addEmployee(Employee theEmployee) throws Exception {
	PreparedStatement myStmt = null;
	

		//get a connection 
		Class.forName("org.postgresql.Driver");
		try  {
                    Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123");
                       
			//create sql statement for insert
			String sql = "insert into employees " + "(user_name, pass_word, access_level, d_o_b, first_name, last_name, manager_email) " + "values (?,?,?,?,?,?,?)";
			
			myStmt = conn.prepareStatement(sql);
			//set the param values for the employee
			myStmt.setString(1, theEmployee.getUserName());
			myStmt.setString(2, theEmployee.getPassWord());
			myStmt.setString(3, theEmployee.getAccessLevel());
			myStmt.setString(4, theEmployee.getDob());
			myStmt.setString(5, theEmployee.getFirstName());
			myStmt.setString(6, theEmployee.getLastName());
			myStmt.setString(7, theEmployee.getManagerEmail());
			//execute sql insert
			myStmt.execute();
		
	} 
	finally {
		//clean up JDBC objects
		//close(myConn,myStmt, null);
	}
}


public Employee getEmployee(String theEmployeeId) throws Exception{

	Employee theEmployee = null;
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	int employeeId;
	
	
		//convert id to int
		employeeId = Integer.parseInt(theEmployeeId);
		//get a connection 
		Class.forName("org.postgresql.Driver");
		try {
		 Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123");
                // create sql to get selected employee
		String sql = "select * from employees where i_d = ?";
		// create prepared Statement
		myStmt = conn.prepareStatement(sql);
		// set params
		myStmt.setInt(1, employeeId);
		// execute statement
		myRs = myStmt.executeQuery();
		// retrieve data from result set row
		
		if (myRs.next()) {
			
			// retrieve data from result set row
			
			String userName = myRs.getString("user_name");
			String passWord = myRs.getString("pass_word");
			String accessLevel = myRs.getString("access_level");
			String dob = myRs.getString("d_o_b");
			String firstName = myRs.getString("first_name");
			String lastName = myRs.getString("last_name");
			String managerEmail = myRs.getString("manager_email");
			int id = myRs.getInt("i_d");
			
			// create new employee object
			theEmployee = new Employee(userName, passWord, accessLevel, dob, firstName, lastName,
					managerEmail, id);
		
			
			
		} else {
			throw new Exception("Could not locate employee id: " + employeeId);
			
		}
		return theEmployee;
	
	
	} 
	finally {
		//clean up JDBC objects
		close(myConn,myStmt, null);
	}
	
	
}


public void updateEmployee(Employee theEmployee) throws Exception{

	Connection myConn = null;
	PreparedStatement myStmt = null;
	
		//get a connection 
		Class.forName("org.postgresql.Driver");
		try {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123");
		// create SQL update Statement
			
			
		String sql = "update employees " + "set user_name=?, pass_word=?, d_o_b=?, first_name=?, last_name=?, manager_email=?, access_level=? " + "where i_d=?;";
	
		// Prepare Statement
		
		
		myStmt = conn.prepareStatement(sql);
		
		
		// set params
	
		myStmt.setString(1, theEmployee.getUserName());
		myStmt.setString(2, theEmployee.getPassWord());
		myStmt.setString(3, theEmployee.getDob());
		myStmt.setString(4, theEmployee.getFirstName());
		myStmt.setString(5, theEmployee.getLastName());
		myStmt.setString(6, theEmployee.getManagerEmail());
		myStmt.setString(7, theEmployee.getAccessLevel());
		myStmt.setInt(8, theEmployee.getId());

		// execute statement
	
		myStmt.executeUpdate();
			
	} 
	finally {
		//clean up JDBC objects
		close(myConn,myStmt, null);
	}
	
	
}


public void deleteEmployee(String theEmployeeId) throws Exception{
	Connection myConn = null;
	PreparedStatement myStmt = null;
		//get a connection 
		Class.forName("org.postgresql.Driver");
		try {
                   Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123");
			//convert id to int
			int employeeId = Integer.parseInt(theEmployeeId);
			// create SQL delete Statement
			String sql = "delete from employees where i_d=?";			
			// Prepare Statement
			myStmt = conn.prepareStatement(sql);
			// set params
			myStmt.setInt(1, employeeId);
			// execute statement
			myStmt.execute();
	} 
	finally {
		//clean up JDBC objects
		close(myConn,myStmt, null);
	}
	
}
}
