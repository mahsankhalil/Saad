package com.mycompany.meven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TRMSLoginDao {
	
	


	public static boolean login(String username, String password) {
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/", "postgres",
				"andress10")) {
			

			PreparedStatement ps = conn.prepareStatement("select * from employees where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
				return true;
				
				// returns true if records exist in database and false if does not
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; 
	}
}
