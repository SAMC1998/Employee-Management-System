package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connection.DBConnect;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.Employee;

public class DeleteMain {

	public static void main(String[] args) {
		int empId;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your Employee id to delete your account: ");
		empId = sc.nextInt();
		
		
		Connection conn = null;
		try {
			conn = DBConnect.getConnection();
			EmployeeDao employeeDao = new EmployeeDaoImpl(conn);
			
			int result = employeeDao.deleteEmployee(empId);
			if(result>0) {
				System.out.println("Delete successfull. Employee deleted with id  = "+ empId);
			}else {
				System.out.println("No employee found with emp id = "+ empId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
