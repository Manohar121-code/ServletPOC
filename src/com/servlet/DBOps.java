package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBOps {
	
	String dbDriver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/septemberdatabase";
	String userName = "root";
	String password = "manah";

	public void saveEmployee(Employee emp) {
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			Class.forName(dbDriver);
			String sql = "insert into employee(name, age, salary) values(?,?,?)";
			
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setString(1, emp.getName());
			prepareStatement.setInt(2, emp.getAge());
			prepareStatement.setDouble(3, emp.getSalary());
			
			prepareStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && prepareStatement != null) {
					connection.close();
					prepareStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
	
	public List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			Class.forName(dbDriver);
			String sql = "select * from employee";
			
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				double salary = resultSet.getDouble("salary");
				
				Employee emp = new Employee(name, age, salary);
				emp.setId(id);
				
				list.add(emp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && prepareStatement != null) {
					connection.close();
					prepareStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
	
}
