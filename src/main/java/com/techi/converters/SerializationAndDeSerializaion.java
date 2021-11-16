package com.techi.converters;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techi.bindings.Employee;

public class SerializationAndDeSerializaion {

	public static void main(String[] args) {
		
		Employee employee=new Employee(101,"Aleem","Virtusa","Chennai");
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			//Convert Java Object to JSON is called as Serialization
			String json=objectMapper.writeValueAsString(employee);
			System.out.println(json);
			
			//Convert JSON to java object is called as de-serialization
			Employee jsonConvertedToEmployee=objectMapper.readValue(new File("employee.json"), Employee.class);
			System.out.println(jsonConvertedToEmployee);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
 * Output:
 * Serialization(Convert Java object to JSON):
 *{
"id":101,
"name":"Aleem",
"organization":"Virtusa",
"location":"Chennai"
}
De-Serialization(Convert JSON to Java Object):
Employee [id=101, name=Aleem, organization=Virtusa, location=Chennai]

 * ***/
