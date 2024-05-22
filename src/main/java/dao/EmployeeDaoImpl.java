package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	private Connection conn;

	public EmployeeDaoImpl(Connection conn) {
		
		this.conn = conn;
	}

	@Override
	public int insertEmp(Employee employee) throws Exception {
		String sql = "insert into employee (emp_name, emp_email, emp_phno, emp_address, emp_department) values (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, employee.getEmpName());
		ps.setString(2, employee.getEmpEmail());
		ps.setString(3, employee.getEmpPhone());
		ps.setString(4, employee.getEmpAddress());
		ps.setString(5, employee.getEmpDepartment());
		
		int result = ps.executeUpdate();
		return result;
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> employees = new ArrayList<>();
		Employee emp = null;
		String sql = "select * from employee";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			emp = new Employee();
			emp.setEmpId(rs.getInt(1));
			emp.setEmpName(rs.getString(2));
			emp.setEmpEmail(rs.getString(3));
			emp.setEmpPhone(rs.getString(4));
			emp.setEmpAddress(rs.getString(5));
			emp.setEmpDepartment(rs.getString(6));
			emp.setEmpDOJ(rs.getTimestamp(7));
			emp.setEmpUpdate(rs.getTimestamp(8));
			
			employees.add(emp);
			
		}
		return employees;
	}

	@Override
	public int updateEmpployee(Employee employee) throws Exception {
		String sql = "update employee set emp_name=?, emp_email=?, emp_phno=?, emp_address=?, emp_department=? where emp_id=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, employee.getEmpName());
		ps.setString(2, employee.getEmpEmail());
		ps.setString(3, employee.getEmpPhone());
		ps.setString(4, employee.getEmpAddress());
		ps.setString(5, employee.getEmpDepartment());
		
		ps.setInt(6, employee.getEmpId());
		
		int result = ps.executeUpdate();
		return result;
	}

	@Override
	public Employee getEmployeeById(int empId) throws Exception {
		
		Employee emp = null;
		String sql = "select * from employee where emp_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			emp = new Employee();
			
			emp.setEmpName(rs.getString(2));
			emp.setEmpEmail(rs.getString(3));
			emp.setEmpPhone(rs.getString(4));
			emp.setEmpAddress(rs.getString(5));
			emp.setEmpDepartment(rs.getString(6));
			emp.setEmpDOJ(rs.getTimestamp(7));
			emp.setEmpUpdate(rs.getTimestamp(8));
			
			
			
		}
		return emp;
	}

	@Override
	public int deleteEmployee(int empId) throws Exception {
		String sql = "delete from employee where emp_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, empId);
		
		int result = ps.executeUpdate();
		return result;
	}
	
	
	
	
}
