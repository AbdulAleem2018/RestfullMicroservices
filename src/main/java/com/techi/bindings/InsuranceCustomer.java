package com.techi.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;

//@NoArgsConstructor
//@AllArgsConstructor
public class InsuranceCustomer {
	
	@JsonProperty("custId")
	private Integer customerId;
	
	@JsonProperty("custName")
	private String customerName;
	
	@JsonProperty("custEmail")
	private String customerEmail;
	
	@JsonProperty("custAge")
	private Integer customerAge;
	
	private InsurancePolicy insurancePolicy;
	
	public InsuranceCustomer() {
		super();
	}
	
	public InsuranceCustomer(Integer customerId, String customerName, String customerEmail, Integer customerAge,
			InsurancePolicy insurancePolicy) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAge = customerAge;
		this.insurancePolicy = insurancePolicy;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public Integer getCustomerAge() {
		return customerAge;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}
	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}
	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}

	@Override
	public String toString() {
		return "InsuranceCustomer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerAge=" + customerAge + ", insurancePolicy=" + insurancePolicy + "]";
	}

}
