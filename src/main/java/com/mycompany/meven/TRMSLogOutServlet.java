package com.mycompany.meven;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TRMSLogOutServlet")
public class TRMSLogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TRMSLogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		RequestDispatcher rd = null;
		//session stuff
		HttpSession session = request.getSession();
		session.invalidate();//removes all the attributes from the session and cause the session to expire
		//end session stuff
		rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
	}


}
