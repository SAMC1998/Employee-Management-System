package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connection.DBConnect;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.Employee;

public class UpdateMain {

	public static void main(String[] args) {
		String empName, empEmail, empPhone, empAddress, empDepartment;
		int empId;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your updated name: ");
		empName = sc.nextLine();
		System.out.println("Please Enter your updated Email address: ");
		empEmail = sc.nextLine();
		System.out.println("Please Enter your updated Phone number: ");
		empPhone = sc.nextLine();
		System.out.println("Please Enter your updated Location: ");
		empAddress = sc.nextLine();
		System.out.println("Please Enter your updated Department: ");
		empDepartment = sc.nextLine();
		System.out.println("Please Enter your Employee Id: ");
		empId = sc.nextInt();
		
		Employee employee = new Employee(empId, empName, empEmail, empPhone, empAddress, empDepartment);
		Connection conn = null;
		try {
			conn = DBConnect.getConnection();
			EmployeeDao employeeDao = new EmployeeDaoImpl(conn);
			
			int result = employeeDao.updateEmpployee(employee);
			if(result>0) {
				System.out.println("Update successfull Rows affected = "+ result);
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
