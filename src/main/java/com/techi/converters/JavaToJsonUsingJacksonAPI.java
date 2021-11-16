package com.techi.converters;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techi.bindings.InsuranceCustomer;
import com.techi.bindings.InsurancePolicy;

public class JavaToJsonUsingJacksonAPI {

	public static void main(String[] args) {
		
		InsurancePolicy insurancePolicy=new InsurancePolicy("Jivan-Anand","19-10-2021","18-10-2031",25000.00);
		InsuranceCustomer insuranceCustomer=new InsuranceCustomer(111711978,"Aleem","skaleeminfo@gmail.com",36,insurancePolicy);
		ObjectMapper objectMapper=new ObjectMapper();
		
		try {
			//Convert Java object to create JSON file using JACKSON API
			objectMapper.writeValue(new File("customer.json"),insuranceCustomer);
			
			//Convert JSON file to Java Object using JACKSON API
			InsuranceCustomer customer=objectMapper.readValue(new File("customer.json"), InsuranceCustomer.class);
			System.out.println(customer);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
 * Output:
 * Convert Java Object to JSON:
  
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
(OR)
{
	"insurancePolicy": {
		"NameOfPolicy": "Jivan-Anand",
		"sdate": "19-10-2021",
		"edate": "18-10-2031",
		"yearlyPayAmount": 25000.0
	},
	"custId": 111711978,
	"custName": "Aleem",
	"custEmail": "skaleeminfo@gmail.com",
	"custAge": 36
}
Convert JSON file to Java Object:
InsuranceCustomer [customerId=111711978, customerName=Aleem, customerEmail=skaleeminfo@gmail.com, customerAge=36, 
insurancePolicy=InsurancePolicy [policyName=Jivan-Anand, startDate=19-10-2021, endDate=18-10-2031, premiumAmount=25000.0]]
 
 * */