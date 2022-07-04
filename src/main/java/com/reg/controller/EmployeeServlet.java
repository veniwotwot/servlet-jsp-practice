package com.reg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reg.dao.EmployeeDAO;
import com.reg.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDao;

	public void init()
	{
		employeeDao = new EmployeeDAO();
	}

	public EmployeeServlet() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");

		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(userName);
		employee.setPassword(password);
		employee.setContact(contact);
		employee.setAddress(address);

		try
		{
			employeeDao.registerEmployee(employee);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		response.sendRedirect("employeedetails.jsp");
	}


}
