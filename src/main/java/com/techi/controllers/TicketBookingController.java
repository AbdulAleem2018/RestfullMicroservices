package com.techi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techi.bindings.Passenger_RequestBinding_Class;
import com.techi.bindings.Ticket_ResponceBinding_Class;
import com.techi.service.TicketService;

@RestController
public class TicketBookingController {
	
	@Autowired
	TicketService ticketService;

	//Request---> json/xml  --->Javaobject(Controller(@BodyRequest)) ---> xml/json(Response)
	//Client can send data to PUT and DELETE  request method in 3 ways: 1. Request Body 2. Path Parameters 3. Query Parameters 

	@PostMapping(value="/bookticket",
				 consumes={"application/json","application/xml"},
				 produces= {"application/json","application/xml"}
			)
	public ResponseEntity<Ticket_ResponceBinding_Class> bookTocket(@RequestBody Passenger_RequestBinding_Class passenger) {
		
		Ticket_ResponceBinding_Class ticket=ticketService.bookingTicket(passenger);
		System.out.println("Ticket Details :"+ticket);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	/*
Test1:
Postman:POST:localhost:8080/bookticket Content-Type=application/json  and Accept=application/xml
Request-Body:
	 { 
	"firstName" : "Aleem",
	"lastName" : "Shaik",
	"journeyfrom" : "Miryalaguda",
	"destination" : "Hyderabad",
	"dateOfJourney" : "21-12-2021"
	}
	
Response-Body:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ticketResponceBindingClass>
    <dateOfJourny>21-12-2021</dateOfJourny>
    <fromAndTo>Miryalaguda-Hyderabad</fromAndTo>
    <name>Aleem Shaik</name>
    <pnr>-1350051019</pnr>
    <ticketPrice>450.00</ticketPrice>
    <ticketStatus>Confirmed</ticketStatus>
</ticketResponceBindingClass>
	 
Test-2:
Postman:POST:localhost:8080/bookticket Content-Type=application/xml  and Accept=application/json
Request-Body:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<passengerRequestBindingClass>
    <firstName>Abdul</firstName>
    <lastName>Azeez</lastName>
    <journeyfrom>Hyderabad</journeyfrom>
    <destination>Miryalaguda</destination>
    <dateOfJourney>31-12-2021</dateOfJourney>
</passengerRequestBindingClass>

Response-Body:
{
    "pnr": "688724009",
    "ticketStatus": "Confirmed",
    "ticketPrice": "450.00",
    "name": "Abdul Azeez",
    "fromAndTo": "Hyderabad-Miryalaguda",
    "dateOfJourny": "31-12-2021"
}

	 Note:In Test2- Class name is:Passenger_RequestBinding_Class but we have to give parent tag name is: <passengerRequestBindingClass>
	 */
	
	
	
	
	
	
	@PutMapping(value="/updateticket",
			 consumes={"application/json","application/xml"},
			 produces= {"application/json","application/xml"}
		)
	public ResponseEntity<Ticket_ResponceBinding_Class> updateTocket(@RequestBody Passenger_RequestBinding_Class passenger) {
	
		Ticket_ResponceBinding_Class ticket=ticketService.updateTicket(passenger);
		System.out.println("Updated Ticket Details :"+ticket);
		return new ResponseEntity<>(ticket,HttpStatus.OK);
	}
/*
 Test1:
 Postman:PUT:localhost:8080/updateticket    Content-Type=application/json  and Accept=application/xml
 RequestBody:
 { 
	"firstName" : "Abdul",
	"lastName" : "Shaik",
	"journeyfrom" : "Miryalaguda",
	"destination" : "Hyderabad",
	"dateOfJourney" : "31-12-2021"
	}
	
ResponseBody:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ticketResponceBindingClass>
    <dateOfJourny>31-12-2021</dateOfJourny>
    <fromAndTo>Miryalaguda-Hyderabad</fromAndTo>
    <name>Abdul Shaik</name>
    <pnr>-1776218181</pnr>
    <ticketPrice>550.00</ticketPrice>
    <ticketStatus>Confirmed</ticketStatus>
</ticketResponceBindingClass>
-------------------------------------------------------------
Test2:
Postman:PUT:localhost:8080/updateticket   Content-Type=application/xml  and Accept=application/json
RequestBody:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<passengerRequestBindingClass>
    <firstName>Amatullah</firstName>
    <lastName>Areebah</lastName>
    <journeyfrom>Hyderabad</journeyfrom>
    <destination>Chennai</destination>
    <dateOfJourney>31-01-2022</dateOfJourney>
</passengerRequestBindingClass>

ResponseBody:
{
    "pnr": "-747508513",
    "ticketStatus": "Confirmed",
    "ticketPrice": "550.00",
    "name": "Amatullah Areebah",
    "fromAndTo": "Hyderabad-Chennai",
    "dateOfJourny": "31-01-2022"
}
----------------------------------------------------------------
Test3:
Postman:PUT:localhost:8080/updateticket   Content-Type=application/xml  and Accept=application/xml

RequestBody:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<passengerRequestBindingClass>
    <firstName>Amatullah</firstName>
    <lastName>Areebah</lastName>
    <journeyfrom>Hyderabad</journeyfrom>
    <destination>Chennai</destination>
    <dateOfJourney>31-01-2022</dateOfJourney>
</passengerRequestBindingClass>
	
 ResponseBody:
 
 <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ticketResponceBindingClass>
    <dateOfJourny>31-01-2022</dateOfJourny>
    <fromAndTo>Hyderabad-Chennai</fromAndTo>
    <name>Amatullah Areebah</name>
    <pnr>-1320355172</pnr>
    <ticketPrice>550.00</ticketPrice>
    <ticketStatus>Confirmed</ticketStatus>
</ticketResponceBindingClass>

Console:
Updated Ticket Details :Ticket_ResponceBinding_Class(pnr=-1320355172, ticketStatus=Confirmed, ticketPrice=550.00, name=Amatullah Areebah, fromAndTo=Hyderabad-Chennai, dateOfJourny=31-01-2022)

----------------------------------------------------------------------
Test4:
Postman:PUT:localhost:8080/updateticket   Content-Type=application/json  and Accept=application/json
RequestBody:
{ 
	"firstName" : "Abdul",
	"lastName" : "Aleem",
	"journeyfrom" : "Miryalaguda",
	"destination" : "Chennai",
	"dateOfJourney" : "03-09-2022"
}

ResponseBody:

{
    "pnr": "-1800070607",
    "ticketStatus": "Confirmed",
    "ticketPrice": "550.00",
    "name": "Abdul Aleem",
    "fromAndTo": "Miryalaguda-Chennai",
    "dateOfJourny": "03-09-2022"
}

Console: 
Updated Ticket Details :Ticket_ResponceBinding_Class(pnr=-1800070607, ticketStatus=Confirmed, ticketPrice=550.00, name=Abdul Aleem, fromAndTo=Miryalaguda-Chennai, dateOfJourny=03-09-2022)

 */
	

	
	
	//PUT:localhost:8080/updateticketrp?pnr=186530654320  
	//Content-Type=  and Accept=
	//ResponceBody: Updated Ticket for PNR - 186530654320
	@PutMapping(value="/updateticketrp"//,
			// consumes={"application/json","application/xml"},
			// produces= {"application/json","application/xml"}
		)
	public ResponseEntity<String> updateTocketByQueryParameter(@RequestParam("pnr") String pnr) {
	
		Ticket_ResponceBinding_Class ticket=ticketService.updateTicketByPNR(pnr);
		System.out.println("Updated Ticket Using Request Param :"+ticket);
		return new ResponseEntity<>("Updated Ticket for PNR - "+pnr,HttpStatus.OK);
	}
	//Note: For RequestParam key and value should be pass through request
	//Note: For PathVariable key declare in RestAPI method and value will provide through request
	
	//PUT:localhost:8080/updateticketrp/186530654320  and Content-Type=  and Accept=application/json
	//PUT:localhost:8080/updateticketrp/186530654320  and Content-Type=  and Accept=application/xml
	@PutMapping(value="/updateticketpv/{pnr}",
			// consumes={"application/json","application/xml"},
			 produces= {"application/json","application/xml"}
		)
	public ResponseEntity<Ticket_ResponceBinding_Class> updateTocketByPathParameter(@PathVariable("pnr") String pnr) {
	
		Ticket_ResponceBinding_Class ticket=ticketService.updateTicketByPNR(pnr);
		System.out.println("Updated Ticket Using PathVariable :"+ticket);
		return new ResponseEntity<>(ticket,HttpStatus.OK);
	}
	/*
	Test-1: 
	 ResponseBody:
	 {
    "pnr": "186530654320",
    "ticketStatus": "Confirmed",
    "ticketPrice": "600.00",
    "name": "Amatullah Rizwana",
    "fromAndTo": "HYD-BNG",
    "dateOfJourny": "10-10-2022"
	}
	
	 Console:
	 Updated Ticket Using PathVariable :Ticket_ResponceBinding_Class(pnr=186530654320, ticketStatus=Confirmed, ticketPrice=600.00, name=Amatullah Rizwana, fromAndTo=HYD-BNG, dateOfJourny=10-10-2022)
	 
	 Test-2:
	  ResponseBody:
	 <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<ticketResponceBindingClass>
    	<dateOfJourny>10-10-2022</dateOfJourny>
    	<fromAndTo>HYD-BNG</fromAndTo>
    	<name>Amatullah Rizwana</name>
    	<pnr>186530654320</pnr>
    	<ticketPrice>600.00</ticketPrice>
    	<ticketStatus>Confirmed</ticketStatus>
	</ticketResponceBindingClass>
	
	 Console:
	 Updated Ticket Using PathVariable :Ticket_ResponceBinding_Class(pnr=186530654320, ticketStatus=Confirmed, ticketPrice=600.00, name=Amatullah Rizwana, fromAndTo=HYD-BNG, dateOfJourny=10-10-2022)
	 
	 */
	
	
	
	
	
	//DELETE:localhost:8080/deleteticketpv/864209653975  and Content-Type=  and Accept=
	@DeleteMapping(value="/deleteticketpv/{pnr}"//,
		// consumes={"application/json","application/xml"},
		//produces= {"application/json","application/xml"}
	)
	public ResponseEntity<String> cancelTicket(@PathVariable("pnr") String pnr) {
		System.out.println("Going to cancel the Ticket of PNR -"+pnr);
		ticketService.cancelTicketByPNR(pnr);
		System.out.println("Ticket is cancelled of PNR :"+pnr+" by using PathVariable");
		return new ResponseEntity<>("Ticket is Cancelled of PNR :"+pnr+", refund amount will credit with in 5 working days",HttpStatus.OK);
	}
	
	/*
	ResponceBody:
	Ticket is Cancelled of PNR :864209653975, refund amount will credit with in 5 working days
	
	Console:
	Going to cancel the Ticket of PNR -864209653975
	Ticket is cancelled of PNR :864209653975 by using PathVariable
	
	 **/
}