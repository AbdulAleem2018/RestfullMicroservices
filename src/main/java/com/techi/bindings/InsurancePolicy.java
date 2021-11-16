package com.techi.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class InsurancePolicy {
	
	@JsonProperty("NameOfPolicy")
	private String policyName;
	
	@JsonProperty("sdate")
	private String startDate;
	
	@JsonProperty("edate")
	private String endDate;
	
	@JsonProperty("yearlyPayAmount")
	private Double premiumAmount;
	
	public InsurancePolicy() {
		super();
	}
	
	public InsurancePolicy(String policyName, String startDate, String endDate, Double premiumAmount) {
		super();
		this.policyName = policyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.premiumAmount = premiumAmount;
	}
	public String getPolicyName() {
		return policyName;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public Double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policyName=" + policyName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", premiumAmount=" + premiumAmount + "]";
	}
	
}
