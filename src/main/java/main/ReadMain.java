package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import connection.DBConnect;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.Employee;

public class ReadMain {

	public static void main(String[] args) {
		
		Connection conn = DBConnect.getConnection();
		EmployeeDao employeeDao = new EmployeeDaoImpl(conn);
		
		try {
			List<Employee> employees = employeeDao.getAllEmployees();
			if(employees.isEmpty()) {
				System.out.println("No Employee exists...");
			}else {
				for(Employee tempEmployee:employees) {
					System.out.println(tempEmployee);
				}
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
