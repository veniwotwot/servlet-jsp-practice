package com.reg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.reg.model.Employee;

public class EmployeeDAO {
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employee"
				+ " (first_name, last_name, username, password, address, contact) VALUES " + " (?, ?, ?, ?, ?, ?);";

		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://192.168.254.71:3306/employees?useSSL=false", "kencompany", "company1@Ken");
				// Step 2: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

			// preparedStatement.setInt(1, 2);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getAddress());
			preparedStatement.setString(6, employee.getContact());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return result;
	}

	public List<Employee> getUserList() throws ClassNotFoundException {
		
		List<Employee> e_List = new ArrayList<Employee>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String query = "SELECT * FROM employee;";
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://192.168.254.71:3306/employees?useSSL=false", "kencompany", "company1@Ken");
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				int id = results.getInt(1);
				String first_name = results.getString(2);
				String last_name = results.getString(3);
				String username = results.getString(4);
				String password = results.getString(5);
				String address = results.getString(6);
				String contact = results.getString(7);
				System.out.println(id + " " + first_name + " " + last_name + " " + username + " " + password + " "
						+ address + " " + contact);
				Employee e = new Employee(first_name, last_name, username, password, address, contact);
				e_List.add(e);
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return e_List;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
