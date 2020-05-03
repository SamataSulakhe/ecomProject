package com.practice.ecom.modal;


public class Company {
	
	private String name;
	private String address;
	private String warehouse;
	private String territory;
	private CompanyGroup companyGroupName;
		
	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public CompanyGroup getCompanyGroupName() {
		return companyGroupName;
	}

	public void setCompanyGroupName(CompanyGroup companyGroupName) {
		this.companyGroupName = companyGroupName;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", address=" + address
				+ ", warehouse=" + warehouse + ", companyGroupName="
				+ companyGroupName + "]";
	}
	
	
	
}
