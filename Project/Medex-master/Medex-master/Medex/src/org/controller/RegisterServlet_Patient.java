package org.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beans.Patient;
import org.dao.Dao;
import org.dao.DaoImpl;
import org.service.PatientService;
import org.service.PatientServiceImpl;


@WebServlet("/regserv_pat")
public class RegisterServlet_Patient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PatientService service_pat = new PatientServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int age;
		String fname,lname,passwd,contact,address,zipcode,city,gender,email;
		
		age=Integer.parseInt(request.getParameter("age"));
		fname=request.getParameter("fname");
		lname=request.getParameter("lname");
		passwd=request.getParameter("pwd");
		contact=request.getParameter("phn number");
		address=request.getParameter("address");
		zipcode=request.getParameter("zipcode");
		city=request.getParameter("city");
		gender=request.getParameter("gender");
		email=request.getParameter("email");
		
		
		boolean pat_id=service_pat.register(new Patient(fname,lname,passwd,gender,age,email,contact,address,city,zipcode));
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		if(pat_id)
		{
			pw.println("<h1>Inserted</h1>");
		}
		else{
			pw.println("<h1>Not Inserted</h1>");
		}
		
	
	}

}
