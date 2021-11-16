package com.techi.converters;

import com.google.gson.Gson;
import com.techi.bindings.InsuranceCustomer;
import com.techi.bindings.InsurancePolicy;

public class JavaToJsonUsingGsonApi {

	public static void main(String[] args) {
		InsurancePolicy insurancePolicy=new InsurancePolicy("Jivan-Anand","19-10-2021","18-10-2031",25000.00);
		InsuranceCustomer insuranceCustomer=new InsuranceCustomer(111711978,"Aleem","skaleeminfo@gmail.com",36,insurancePolicy);
		
		Gson gson=new Gson();
		
		String jsonData=gson.toJson(insuranceCustomer);
		System.out.println(jsonData);
		
		InsuranceCustomer jsonToJava=gson.fromJson(jsonData, InsuranceCustomer.class);
		System.out.println(jsonToJava);
	}
}
/**
 * Output:
 Converted Java Object to JSON String using Gson API:
 {
	"customerId": 111711978,
	"customerName": "Aleem",
	"customerEmail": "skaleeminfo@gmail.com",
	"customerAge": 36,
	"insurancePolicy": {
		"policyName": "Jivan-Anand",
		"startDate": "19-10-2021",
		"endDate": "18-10-2031",
		"premiumAmount": 25000.0
	}
}

JSON String to Java Object using Gson API:
InsuranceCustomer 
[customerId=111711978,
 customerName=Aleem,
 customerEmail=skaleeminfo@gmail.com,
 customerAge=36, 
 insurancePolicy=InsurancePolicy 
 [
  policyName=Jivan-Anand,
  startDate=19-10-2021,
  endDate=18-10-2031,
  premiumAmount=25000.0
 ]
]

 * 
 * **/
