package com.hospitalmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// accept request from user
		String accountType = request.getParameter("accountType");	// here is the user's account type
		String name = request.getParameter("name");					// here is the user's name
		String user = request.getParameter("username");				// user's username
		String pass1 = request.getParameter("pass1");				// first password entry
		String pass2 = request.getParameter("pass2");				// password confirmation entry
		
		// "process" the info in some way
		PrintWriter out = response.getWriter();
		if(!pass1.equals(pass2)) {
			out.println("Passwords do not match.");
		} else {
			out.println("Succesfully registered as " + accountType + ". Thank you for registering, " + name +"!");
		}
	}

}
