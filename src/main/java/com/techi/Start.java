package com.techi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.techi.bindings.Passenger_RequestBinding_Class;
import com.techi.bindings.Ticket_ResponceBinding_Class;
import com.techi.service.Covid19Service;
import com.techi.service.TicketService;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
//@ComponentScan("com.techi")
public class Start {

	public static void main(String[] args) {
	    ConfigurableApplicationContext configAppContext=SpringApplication.run(Start.class, args);
	     
	   /* RestTemplate restTemplate=new RestTemplate();
	    ResponseEntity<String> responceEntity=restTemplate.getForEntity("http://mu.mulesoft-training.com/essentials/united/flights/", String.class);
	    String body=responceEntity.getBody();
	    System.out.println("Body :"+body);*/
	    /**
	  	Body :{
	  	"flights":
	  	[
	    {"code":"ER38sd","price":400,"origin":"MUA","destination":"SFO","departureDate":"2015/03/20","planeType":"Boeing 737","airlineName":"United","emptySeats":0
	    },
	    {"code":"ER45if","price":345.99,"origin":"MUA","destination":"LAX","departureDate":"2015/02/11","planeType":"Boeing 737","airlineName":"United","emptySeats":52
	    },
	    {"code":"ER45jd","price":346,"origin":"MUA","destination":"LAX","departureDate":"2015/04/11","planeType":"Boeing 777","airlineName":"United","emptySeats":12
	    },
	    {"code":"ER0945","price":423,"origin":"MUA","destination":"LAX","departureDate":"2015/06/11","planeType":"Boeing 707","airlineName":"United","emptySeats":0
	    },
	    {"code":"ER9fje","price":845,"origin":"MUA","destination":"CLE","departureDate":"2015/07/11","planeType":"Boeing 727","airlineName":"United","emptySeats":32
	    },
	    {"code":"ER3kfd","price":245,"origin":"MUA","destination":"CLE","departureDate":"2015/08/11","planeType":"Boeing 747","airlineName":"United","emptySeats":13
	    },
	    {"code":"ER39rk","price":945,"origin":"MUA","destination":"SFO","departureDate":"2015/09/11","planeType":"Boeing 757","airlineName":"United","emptySeats":54
	    },
	    {"code":"ER39rj","price":954,"origin":"MUA","destination":"SFO","departureDate":"2015/02/12","planeType":"Boeing 777","airlineName":"United","emptySeats":23
	    },
	    {"code":"ER95jf","price":234,"origin":"MUA","destination":"PDF","departureDate":"2015/02/12","planeType":"Boeing 787","airlineName":"United","emptySeats":23
	    },
	    {"code":"ER49fd","price":853,"origin":"MUA","destination":"PDX","departureDate":"2015/02/13","planeType":"Boeing 777","airlineName":"United","emptySeats":0
	    },
	    {"code":"ER95jf","price":483,"origin":"MUA","destination":"PDX","departureDate":"2015/02/20","planeType":"Boeing 777","airlineName":"United","emptySeats":95
	    },
	    {"code":"ER04kf","price":532,"origin":"MUA","destination":"PDX","departureDate":"2015/02/12","planeType":"Boeing 777","airlineName":"United","emptySeats":30
	    }
	    ]
	    }
*/
	    
	/**Example-1:
	  FlightService flightService=configAppContext.getBean(FlightService.class);
	    //Using RestTemplate 
	    flightService.getUnitedFlightService();
	    
	    //Using WebClient
	    flightService.getSynchronousFlightsUsingWebClient();
	    flightService.getASynchronousFlightsUsingWebClient();
	   */
	  
/**Example-2:
	    Covid19Service covid19Service=configAppContext.getBean(Covid19Service.class);
	  //Using WebClient
	  covid19Service.getLatestCountryDataByCode();
	   //covid19Service.getDailyReportByCountryName();
	   //covid19Service.getDailyReportByCountryCode();
	  // covid19Service.getLatestCountryDataByName();
//*********** Not Working ************************
	  //covid19Service.getDailyReportAllCountries();
	  // covid19Service.getLatestAllCountries();
	  //covid19Service.getASyncCovid19Info();
*/
/** Example-3:	   
	    TicketService ticketService=configAppContext.getBean(TicketService.class);
	    Passenger_RequestBinding_Class passenger=new Passenger_RequestBinding_Class();
	    passenger.setFirstName("Abdul");
	    passenger.setLastName("Aleem");
	    passenger.setJourneyfrom("MRGA");
	    passenger.setDestination("HYD");
	    passenger.setDateOfJourney("01-04-2024");
	    
	    Ticket_ResponceBinding_Class ticket=ticketService.bookTicketByUsingResourceApp(passenger);
	    System.out.println("Booked The Ticket using Resource App :"+ticket);
	    //Booked The Ticket using Resource App :Ticket_ResponceBinding_Class(pnr=1227100034, ticketStatus=Confirmed, ticketPrice=450.00, name=Abdul Aleem, fromAndTo=MRGA-HYD, dateOfJourny=01-04-2024)
	*/
	}
}