package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import connection.DBConnect;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.Employee;

public class AllEmpByIdMain {

	public static void main(String[] args) {
		
		Connection conn = DBConnect.getConnection();
		EmployeeDao employeeDao = new EmployeeDaoImpl(conn);
		int empId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your Employee Id: ");
		empId = sc.nextInt();
		try {
			Employee employee = employeeDao.getEmployeeById(empId);
			if(employee == null) {
				System.out.println("No Employee exists by emp_id = "+empId);
			}else {
				System.out.println(employee);
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
