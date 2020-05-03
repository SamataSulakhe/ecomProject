package com.practice.ecom.modal;

public class CompanyGroup {
	
	private String companyGroupName;
	private String companyGroupDescription;
	
	public String getCompanyGroupName() {
		return companyGroupName;
	}

	public void setCompanyGroupName(String companyGroupName) {
		this.companyGroupName = companyGroupName;
	}


	public String getCompanyGroupDescription() {
		return companyGroupDescription;
	}


	public void setCompanyGroupDescription(String companyGroupDescription) {
		this.companyGroupDescription = companyGroupDescription;
	}


	@Override
	public String toString() {
		return "CompanyGroup [companyGroupName=" + companyGroupName
				+ ", companyGroupDescription=" + companyGroupDescription + "]";
	}

}
