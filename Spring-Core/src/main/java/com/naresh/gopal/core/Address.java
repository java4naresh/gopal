package com.naresh.gopal.core;

public class Address {
	
	private String address1;
	
	private String city;

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [address1=" + address1 + ", city=" + city + "]";
	}
	
	

}
