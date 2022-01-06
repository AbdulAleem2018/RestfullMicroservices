package com.techi.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.techi.bindings.AllDailyCovid;
import com.techi.bindings.Passenger_RequestBinding_Class;
import com.techi.bindings.Ticket_ResponceBinding_Class;

@Service
public class TicketService {
	
	public Ticket_ResponceBinding_Class bookingTicket(Passenger_RequestBinding_Class passenger) {
		
		Ticket_ResponceBinding_Class ticket=new Ticket_ResponceBinding_Class();
		
		ticket.setPnr(ThreadLocalRandom.current().nextInt()+"");
		ticket.setTicketStatus("Confirmed");
		ticket.setTicketPrice("450.00");
		ticket.setDateOfJourny(passenger.getDateOfJourney());
		ticket.setFromAndTo(passenger.getJourneyfrom()+"-"+passenger.getDestination());
		ticket.setName(passenger.getFirstName()+" "+passenger.getLastName());
		
		return ticket;
	}
	
	public Ticket_ResponceBinding_Class updateTicket(Passenger_RequestBinding_Class passenger) {
		
		Ticket_ResponceBinding_Class ticket=new Ticket_ResponceBinding_Class();
		
		ticket.setPnr(ThreadLocalRandom.current().nextInt()+"");
		ticket.setTicketStatus("Confirmed");
		ticket.setTicketPrice("550.00");
		ticket.setDateOfJourny(passenger.getDateOfJourney());
		ticket.setFromAndTo(passenger.getJourneyfrom()+"-"+passenger.getDestination());
		ticket.setName(passenger.getFirstName()+" "+passenger.getLastName());
		
		return ticket;
	}
	
	public Ticket_ResponceBinding_Class updateTicketByPNR(String pnr) {
		
		Ticket_ResponceBinding_Class ticket=new Ticket_ResponceBinding_Class();
		
		ticket.setPnr(pnr);
		ticket.setTicketStatus("Confirmed");
		ticket.setTicketPrice("600.00");
		ticket.setDateOfJourny("10-10-2022");
		ticket.setFromAndTo("HYD-BNG");
		ticket.setName("Amatullah Rizwana");
		
		return ticket;
	}
	
public void cancelTicketByPNR(String pnr) {
		
		Ticket_ResponceBinding_Class ticket=new Ticket_ResponceBinding_Class();
		
		ticket.setPnr(pnr);
		ticket.setTicketStatus("Cancelled");
		ticket.setTicketPrice("600.00");
		ticket.setDateOfJourny("10-10-2022");
		ticket.setFromAndTo("HYD-BNG");
		ticket.setName("Amatullah Rizwana");
		//Deleted logic
		//return ticket;
	}
	

	public Ticket_ResponceBinding_Class bookTicketByUsingResourceApp(Passenger_RequestBinding_Class passenger) {
		String resourceAppUrl="localhost:8080/bookticket";
		
		WebClient webclient = WebClient.create();
		
		/*AllDailyCovid[] allDailyCovid = webclient.get()
				.uri("https://covid-19-data.p.rapidapi.com/report/country/all?date=2022-01-04")
				.header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
				.header("x-rapidapi-key", "0bb714115bmsh00c2fdfeba2078ep156d63jsn49cb1ea6536f").retrieve()
				.bodyToMono(AllDailyCovid[].class).block();
		*/
		
		Ticket_ResponceBinding_Class ticket=webclient.post()
		.uri(resourceAppUrl)
		.body(BodyInserters.fromValue(passenger))
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToMono(Ticket_ResponceBinding_Class.class)
		.block();
		
		return ticket;
	}
}