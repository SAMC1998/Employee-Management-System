package entity;

import java.sql.Timestamp;

public class Employee {

	private int empId;
	private String empName;
	private String empEmail;
	private String empPhone;
	private String empAddress;
	private String empDepartment;
	private Timestamp empDOJ;
	private Timestamp empUpdate;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	public Employee(String empName, String empEmail, String empPhone, String empAddress, String empDepartment) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empAddress = empAddress;
		this.empDepartment = empDepartment;
	}


	public Employee(int empId, String empName, String empEmail, String empPhone, String empAddress,
			String empDepartment) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empAddress = empAddress;
		this.empDepartment = empDepartment;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	public Timestamp getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(Timestamp empDOJ) {
		this.empDOJ = empDOJ;
	}

	public Timestamp getEmpUpdate() {
		return empUpdate;
	}

	public void setEmpUpdate(Timestamp empUpdate) {
		this.empUpdate = empUpdate;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPhone=" + empPhone
				+ ", empAddress=" + empAddress + ", empDepartment=" + empDepartment + ", empDOJ=" + empDOJ
				+ ", empUpdate=" + empUpdate + "]";
	}
	
	
	
}
