package com.naresh.gopal.core;

//dependent
public class Employee {
	
	private String name;
	
	private String empId;
	
	//dependency
	private Address address;
	
	public Employee() {
		System.out.println("Employee");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		System.out.println("setEmpId");
		this.empId = empId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("setAddress");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", address=" + address + "]";
	}

	
	
	

}
