
package com.techi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techi.bindings.Address;
import com.techi.bindings.Student;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController//This class represent as Distributed Component and Spring Bean
@RequestMapping("/controler")
public class WelcomeController {
	
	//Below all methods to handle the request, every method should be binded to HTTP Protocol methods, GET request will not contain request body(getting data)
	//localhost:8080/controler/
	@GetMapping
	public ResponseEntity<String> defaultMapping(){
		String responceMessage="Hi!!, This is Home Page !!!";
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	//localhost:8080/controler/welcome
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMessage(){
		String responceMessage="Welcome to Distributed Apllications for all world Techi guys !!!!!";
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	//localhost:8080/controler/login
	@GetMapping("/login")
	public ResponseEntity<String> loginPage(){
		String responceMessage="This is Login Page !!!!!";
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	//localhost:8080/controler/logout
	@GetMapping("/logout")
	public ResponseEntity<String> logoutPage(){
		String responceMessage="This is Logout Page !!!!!";
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	//send data to server via URL
	//localhost:8080/controler/cource?name=SPRINGBoot&triner=ALEEM
	@GetMapping("/cource")
	public ResponseEntity<String> getCourceDetails(@RequestParam ("name") String courceName, @RequestParam("triner") String trainer){
		String responceMessage = null;
		if(courceName.equalsIgnoreCase("Springboot") && trainer.equalsIgnoreCase("Aleem") )
			responceMessage=courceName+" will start on 1st day of every month, trainer is Abdul Aleem";
		else if(courceName.equalsIgnoreCase("Restfull") && trainer.equalsIgnoreCase("Aleem"))
			responceMessage=courceName+" will start on 16th day of every month, trainer is Abdul Aleem";
		else if(courceName.equalsIgnoreCase("Microservices") && trainer.equalsIgnoreCase("Aleem"))
			responceMessage=courceName+" will start on 22nd day of every month, trainer is Abdul Aleem";
		else if(courceName.equalsIgnoreCase("Angular")&& trainer.equalsIgnoreCase("Aleem"))
			responceMessage=courceName+" is Free, will provide vedios";
		else
			responceMessage=courceName+" contact skaleeminfo@gmail.com";
		
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	//localhost:8080/controler/cource/REstfull/Aleem/
	@GetMapping("/cource/{name}/{trainer}")
	public ResponseEntity<String> getCourceDetailsUsingPathParameter(@PathVariable("name") String courceName,@PathVariable("trainer") String trainer){
		String responceMessage = null;
		
		if(courceName.equalsIgnoreCase("Springboot") && trainer.equalsIgnoreCase("Aleem") )
			responceMessage=courceName+" will start on 1st day of every month, trainer is Abdul Aleem";
		else if(courceName.equalsIgnoreCase("Restfull") && trainer.equalsIgnoreCase("Aleem"))
			responceMessage=courceName+" will start on 16th day of every month, trainer is Abdul Aleem";
		else if(courceName.equalsIgnoreCase("Microservices") && trainer.equalsIgnoreCase("Aleem"))
			responceMessage=courceName+" will start on 22nd day of every month, trainer is Abdul Aleem";
		else if(courceName.equalsIgnoreCase("Angular")&& trainer.equalsIgnoreCase("Aleem"))
			responceMessage=courceName+" is Free, will provide vedios";
		else
			responceMessage=courceName+" contact skaleeminfo@gmail.com";
		
		return new ResponseEntity<String>(responceMessage,HttpStatus.OK);
	}
	
	//Test1: localhost:8080/controler/students and Headers(7): Accept:application/json
	//Test2: localhost:8080/controler/students and Headers(7): Accept:application/xml
	@GetMapping(
					value="/students",
					//produces = {"application/json"}//if Accept=application/xml then responce/output is empty
					produces = {"application/xml","application/json"}
				)
	public Student getStudent() {
		
		Address address=new Address();
		address.setCity("MLG");
		address.setState("Telangana");
		address.setCountry("India");
		
		Student student=new Student();
		student.setStudentId(1);
		student.setStudentName("Aleem");
		student.setStudentAge(36);
		student.setStudentRank(5);
		student.setAddress(address);
		
		return student;
	}
	/**
Test1:
{
    "studentId": 1,
    "studentName": "Aleem",
    "studentRank": 5,
    "studentAge": 36,
    "address": {
        "country": "India",
        "state": "Telangana",
        "city": "MLG"
    }
}

Test2:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<student id="1" name="Aleem">
    <rank>5</rank>
    <age>36</age>
    <address>
        <country>India</country>
        <state>Telangana</state>
        <city>MLG</city>
    </address>
</student>


**/
	 
/**
 Test1:
 POST: localhost:8080/controler/add-student
 Headers: Content-Type=application/json
 Body:raw:
{
    "studentId": 10,
    "studentName": "Abdul Aleem",
    "studentRank": 3,
    "studentAge": 36,
    "address": {
        "country": "India",
        "state": "Telangana",
        "city": "Miryalaguda"
    }
}
	 
Output:
Console: Student [studentId=10, studentName=Abdul Aleem, studentRank=3, studentAge=36, address=Address [country=India, state=Telangana, city=Miryalaguda]]
PostMan: Student details saved (Status: 201 Created)

Test2:
 POST: localhost:8080/controler/add-student
 Headers: Content-Type=application/xml
 Body:raw:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<student id="1" name="Rizwana Shaik">
    <rank>13</rank>
    <age>8</age>
    <address>
        <country>India</country>
        <state>Telangana</state>
        <city>Miryalaguda</city>
    </address>
</student>
	 
Output:
Console: Student [studentId=1, studentName=Rizwana Shaik, studentRank=13, studentAge=8, address=Address [country=India, state=Telangana, city=Miryalaguda]]
PostMan: Student details saved (Status: 201 Created)
**/

	@PostMapping(
				value="add-student",
				consumes = {"application/xml", "application/json"}
			 )
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		System.out.println(student);
		String message="Student details saved";
		
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	
	/**
	 Request: GET: http://localhost:8080/controler/swaggerMsg/Aleem
	 Response: Aleem Good Morning!!
	 */
	@ApiOperation(value="This operation is used for generate swagger message" ,response = String.class)
	@GetMapping("/swaggerMsg/{name}")
	public String swaggerMessage(@ApiParam("Name to Wish") @PathVariable String name) {
		return name+" Good Morning!!";
	}
	
}
