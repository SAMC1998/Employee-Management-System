package dao;

import java.util.List;

import entity.Employee;

public interface EmployeeDao {
	public int insertEmp (Employee employee) throws Exception;
	
	public List<Employee> getAllEmployees() throws Exception;
	
	public int updateEmpployee (Employee employee) throws Exception;
	
	public Employee getEmployeeById(int empId) throws Exception;
	
	public int deleteEmployee(int empId) throws Exception;

}
