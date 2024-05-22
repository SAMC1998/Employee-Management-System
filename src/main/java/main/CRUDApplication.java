package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import connection.DBConnect;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import entity.Employee;

public class CRUDApplication {
	public static void main(String[] args) {
		int userChoice;
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		EmployeeDao employeeDao = null;
		do {
			conn = DBConnect.getConnection(); 
			employeeDao = new EmployeeDaoImpl(conn);
			System.out.println("\n\n---------------------------------------");
			System.out.println("Pls enter your choice\n1. Add Employee ");
			System.out.println("2. Update Employee \n3. Delete Employee ");
			System.out.println("4. View All Employee \n3. View Employee By Id ");
			System.out.println("6. Exit");
			System.out.println("---------------------------------------");
			System.out.println("---------------------------------------");
			
			userChoice = sc.nextInt();
			switch (userChoice) {
			case 1: {
				System.out.println("Insert Employee");
				InsertMain(employeeDao);
				break;
			}
			case 2: {
				System.out.println("Update Employee");
				UpdateMain(employeeDao);
				break;
			}
			case 3: {
				System.out.println("Delete Employee");
				DeleteMain(employeeDao);
				break;
			}
			case 4: {
				System.out.println("View All Employee");
				ReadMain(employeeDao);
				break;
			}
			case 5: {
				System.out.println("View Employee By Id");
				
				break;
			}
			case 6: {
				System.out.println("---------------------------------------");
				System.out.println("Thanks and Visit Again");
				System.out.println("---------------------------------------");
				break;
			}
			default:
				System.out.println("Pls select from above list. Try Again..");
			}
		} while (userChoice!=6);
		
	}

	private static void ReadMain(EmployeeDao employeeDao) {
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
		}
		
	}

	private static void DeleteMain(EmployeeDao employeeDao) {
int empId;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your Employee id to delete your account: ");
		empId = sc.nextInt();
		
		
		Connection conn = null;
		try {
			
			
			int result = employeeDao.deleteEmployee(empId);
			if(result>0) {
				System.out.println("Delete successfull. Employee deleted with id  = "+ empId);
			}else {
				System.out.println("No employee found with emp id = "+ empId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void UpdateMain(EmployeeDao employeeDao) {
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
			
			
			int result = employeeDao.updateEmpployee(employee);
			if(result>0) {
				System.out.println("Update successfull Rows affected = "+ result);
			}else {
				System.out.println("No employee found with emp id = "+ empId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void InsertMain(EmployeeDao employeeDao) {
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
		}
		
	}



		
	
}
