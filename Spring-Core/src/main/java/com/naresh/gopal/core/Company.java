package com.naresh.gopal.core;

public class Company {
	
	private String companyName;
	
	private Address companyAddress;
	
	private Employee emp;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Address getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyAddress=" + companyAddress + ", emp=" + emp + "]";
	}
	
	

}
