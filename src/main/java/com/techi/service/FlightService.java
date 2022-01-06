package com.techi.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.techi.bindings.Flight;
import com.techi.bindings.Flights;

import reactor.core.Disposable;

@Service
public class FlightService {

	private static final String FLIGHT_URL="http://mu.mulesoft-training.com/essentials/united/flights/";
	
	public void getUnitedFlightService() {
		RestTemplate restTemplate=new RestTemplate();
	    
		//ResponseEntity<Flights> responceEntity=restTemplate.getForEntity("http://mu.mulesoft-training.com/essentials/united/flights/", Flights.class);
		
		//Send HttpHeaders in request
		HttpHeaders headers=new HttpHeaders();
		headers.add("Accept","application/json");
		HttpEntity entity=new HttpEntity<>(headers);
	    ResponseEntity<Flights> responceEntity=restTemplate.getForEntity(FLIGHT_URL,Flights.class,HttpMethod.GET,entity);

	    
	    Flights flights=responceEntity.getBody();//Caused by: java.lang.ClassCastException: com.techi.bindings.Flights cannot be cast to java.util.List
	    List<Flight> allFlights=flights.getFlights();
	    System.out.println("AllFlights are :"+allFlights.size());
	    allFlights.forEach(System.out::println);

/**
AllFlights are :12
Flight(code=ER38sd, price=400, origin=MUA, destination=SFO, departureDate=2015/03/20, planeType=Boeing 737, airlineName=United, emptySeats=0)
Flight(code=ER45if, price=345.99, origin=MUA, destination=LAX, departureDate=2015/02/11, planeType=Boeing 737, airlineName=United, emptySeats=52)
Flight(code=ER45jd, price=346, origin=MUA, destination=LAX, departureDate=2015/04/11, planeType=Boeing 777, airlineName=United, emptySeats=12)
Flight(code=ER0945, price=423, origin=MUA, destination=LAX, departureDate=2015/06/11, planeType=Boeing 707, airlineName=United, emptySeats=0)
Flight(code=ER9fje, price=845, origin=MUA, destination=CLE, departureDate=2015/07/11, planeType=Boeing 727, airlineName=United, emptySeats=32)
Flight(code=ER3kfd, price=245, origin=MUA, destination=CLE, departureDate=2015/08/11, planeType=Boeing 747, airlineName=United, emptySeats=13)
Flight(code=ER39rk, price=945, origin=MUA, destination=SFO, departureDate=2015/09/11, planeType=Boeing 757, airlineName=United, emptySeats=54)
Flight(code=ER39rj, price=954, origin=MUA, destination=SFO, departureDate=2015/02/12, planeType=Boeing 777, airlineName=United, emptySeats=23)
Flight(code=ER95jf, price=234, origin=MUA, destination=PDF, departureDate=2015/02/12, planeType=Boeing 787, airlineName=United, emptySeats=23)
Flight(code=ER49fd, price=853, origin=MUA, destination=PDX, departureDate=2015/02/13, planeType=Boeing 777, airlineName=United, emptySeats=0)
Flight(code=ER95jf, price=483, origin=MUA, destination=PDX, departureDate=2015/02/20, planeType=Boeing 777, airlineName=United, emptySeats=95)
Flight(code=ER04kf, price=532, origin=MUA, destination=PDX, departureDate=2015/02/12, planeType=Boeing 777, airlineName=United, emptySeats=30)
	     
*/
	    
	}
	
	public void getSynchronousFlightsUsingWebClient() {
		
		WebClient webclient=WebClient.create();
		
		String block=webclient.get()
				 .uri(FLIGHT_URL)
				 .accept(MediaType.APPLICATION_JSON)
				 .retrieve()
				 .bodyToMono(String.class)
				 .block();
		System.out.println("block :"+block);
	}
	//block :{"flights":[{"code":"ER38sd","price":400,"origin":"MUA","destination":"SFO","departureDate":"2015/03/20","planeType":"Boeing 737","airlineName":"United","emptySeats":0},{"code":"ER45if","price":345.99,"origin":"MUA","destination":"LAX","departureDate":"2015/02/11","planeType":"Boeing 737","airlineName":"United","emptySeats":52},{"code":"ER45jd","price":346,"origin":"MUA","destination":"LAX","departureDate":"2015/04/11","planeType":"Boeing 777","airlineName":"United","emptySeats":12},{"code":"ER0945","price":423,"origin":"MUA","destination":"LAX","departureDate":"2015/06/11","planeType":"Boeing 707","airlineName":"United","emptySeats":0},{"code":"ER9fje","price":845,"origin":"MUA","destination":"CLE","departureDate":"2015/07/11","planeType":"Boeing 727","airlineName":"United","emptySeats":32},{"code":"ER3kfd","price":245,"origin":"MUA","destination":"CLE","departureDate":"2015/08/11","planeType":"Boeing 747","airlineName":"United","emptySeats":13},{"code":"ER39rk","price":945,"origin":"MUA","destination":"SFO","departureDate":"2015/09/11","planeType":"Boeing 757","airlineName":"United","emptySeats":54},{"code":"ER39rj","price":954,"origin":"MUA","destination":"SFO","departureDate":"2015/02/12","planeType":"Boeing 777","airlineName":"United","emptySeats":23},{"code":"ER95jf","price":234,"origin":"MUA","destination":"PDF","departureDate":"2015/02/12","planeType":"Boeing 787","airlineName":"United","emptySeats":23},{"code":"ER49fd","price":853,"origin":"MUA","destination":"PDX","departureDate":"2015/02/13","planeType":"Boeing 777","airlineName":"United","emptySeats":0},{"code":"ER95jf","price":483,"origin":"MUA","destination":"PDX","departureDate":"2015/02/20","planeType":"Boeing 777","airlineName":"United","emptySeats":95},{"code":"ER04kf","price":532,"origin":"MUA","destination":"PDX","departureDate":"2015/02/12","planeType":"Boeing 777","airlineName":"United","emptySeats":30}]}
	public void getASynchronousFlightsUsingWebClient() {
		
		WebClient webclient=WebClient.create();
		
		Disposable disposable=webclient.get()
				 .uri(FLIGHT_URL)
				 .accept(MediaType.APPLICATION_JSON)
				 .retrieve()
				 .bodyToMono(String.class)
				 .subscribe(System.out::println);
		//System.out.println("disposable :"+disposable.toString());
	}
	//{"flights":[{"code":"ER38sd","price":400,"origin":"MUA","destination":"SFO","departureDate":"2015/03/20","planeType":"Boeing 737","airlineName":"United","emptySeats":0},{"code":"ER45if","price":345.99,"origin":"MUA","destination":"LAX","departureDate":"2015/02/11","planeType":"Boeing 737","airlineName":"United","emptySeats":52},{"code":"ER45jd","price":346,"origin":"MUA","destination":"LAX","departureDate":"2015/04/11","planeType":"Boeing 777","airlineName":"United","emptySeats":12},{"code":"ER0945","price":423,"origin":"MUA","destination":"LAX","departureDate":"2015/06/11","planeType":"Boeing 707","airlineName":"United","emptySeats":0},{"code":"ER9fje","price":845,"origin":"MUA","destination":"CLE","departureDate":"2015/07/11","planeType":"Boeing 727","airlineName":"United","emptySeats":32},{"code":"ER3kfd","price":245,"origin":"MUA","destination":"CLE","departureDate":"2015/08/11","planeType":"Boeing 747","airlineName":"United","emptySeats":13},{"code":"ER39rk","price":945,"origin":"MUA","destination":"SFO","departureDate":"2015/09/11","planeType":"Boeing 757","airlineName":"United","emptySeats":54},{"code":"ER39rj","price":954,"origin":"MUA","destination":"SFO","departureDate":"2015/02/12","planeType":"Boeing 777","airlineName":"United","emptySeats":23},{"code":"ER95jf","price":234,"origin":"MUA","destination":"PDF","departureDate":"2015/02/12","planeType":"Boeing 787","airlineName":"United","emptySeats":23},{"code":"ER49fd","price":853,"origin":"MUA","destination":"PDX","departureDate":"2015/02/13","planeType":"Boeing 777","airlineName":"United","emptySeats":0},{"code":"ER95jf","price":483,"origin":"MUA","destination":"PDX","departureDate":"2015/02/20","planeType":"Boeing 777","airlineName":"United","emptySeats":95},{"code":"ER04kf","price":532,"origin":"MUA","destination":"PDX","departureDate":"2015/02/12","planeType":"Boeing 777","airlineName":"United","emptySeats":30}]}
}