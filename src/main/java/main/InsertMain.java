package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connection.DBConnect;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.Employee;

public class InsertMain {

	public static void main(String[] args) {
		String empName, empEmail, empPhone, empAddress, empDepartment;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your name: ");
		empName = sc.nextLine();
		System.out.println("Please Enter your Email address: ");
		empEmail = sc.nextLine();
		System.out.println("Please Enter your Phone number: ");
		empPhone = sc.nextLine();
		System.out.println("Please Enter your Location: ");
		empAddress = sc.nextLine();
		System.out.println("Please Enter your Department: ");
		empDepartment = sc.nextLine();
		
		Employee employee = new Employee(empName, empEmail, empPhone, empAddress, empDepartment);
		Connection conn = DBConnect.getConnection();
		EmployeeDao employeeDao = new EmployeeDaoImpl(conn);
		
		try {
			int result = employeeDao.insertEmp(employee);
			if(result>0) {
				System.out.println("Insert Successfull");
			}else {
				System.out.println("Something bad happen on server..");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
