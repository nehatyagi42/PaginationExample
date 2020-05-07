package com.rtpl.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.rtpl.bean.Employee;



public class EmployeeDao {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			  Class.forName("com.mysql.jdbc.Driver");  
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/nehadb","root","root");
			
			
		} catch (Exception e) {
			{System.out.println(e);}  
		}
		return connection;
		
	}
	
	public static List<Employee>getRecords(int start,int total){
		List<Employee>list=new ArrayList<Employee>();
		try {
			Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from employee "+(start-1)+","+total);  
		ResultSet rs= ps.executeQuery();
		while (rs.next()) {
			
			Employee emp=new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getInt(3));
			 list.add(emp);  
		}
		} catch (Exception e) {
			{System.out.println(e);
		}
	
		
	}
		return list;
	

	}
}
