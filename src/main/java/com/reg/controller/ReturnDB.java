package com.reg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reg.dao.EmployeeDAO;
import com.reg.model.Employee;

/**
 * Servlet implementation class ReturnDB
 */
@WebServlet("/ReturnDB")
public class ReturnDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDao;

	public void init() {
		employeeDao = new EmployeeDAO();
	}

	public ReturnDB() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		
		try {
			List<Employee> e_List;
			e_List = employeeDao.getUserList();
			request.setAttribute("first_name", "Vin");
			request.setAttribute("last_name", e_List.size());
			request.setAttribute("e_list", e_List);
			RequestDispatcher dispatcher = request.getRequestDispatcher("returndb.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
