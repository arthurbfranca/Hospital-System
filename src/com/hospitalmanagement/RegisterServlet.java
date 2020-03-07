package com.hospitalmanagement;

import java.io.File;
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
	
	File file = new File("users");
	private static newRegistration newUser = new newRegistration();
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
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");		// here is the user's first name
		String lastName = request.getParameter("lastName");
		String user = request.getParameter("username");				// user's username
		String pass1 = request.getParameter("pass1");				// first password entry
		String pass2 = request.getParameter("pass2");				// password confirmation entry
		
		// "process" the info in some way
		PrintWriter out = response.getWriter();
		if(!pass1.equals(pass2)) {
			out.println("Passwords do not match.");
		} else {
			out.println("Succesfully registered as " + accountType + ". Thank you for registering, " + firstName +"!");
		}
		
		String contextPath = getServletContext().getRealPath("/");
		String xmlFilePath=contextPath+"\\users";
		System.out.println(xmlFilePath);
		File myfile = new File(xmlFilePath);
		myfile.createNewFile();
		
		newUser.addInfo(id, firstName, lastName, pass1, xmlFilePath);
	}

}
