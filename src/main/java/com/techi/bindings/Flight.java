package com.techi.bindings;

import lombok.Data;

@Data
public class Flight {
//It is used to represent 1 flight data
	private String code;
	private String price;
	private String origin;
	private String destination;
	private String departureDate;
	private String planeType; 
	private String airlineName;
	private int emptySeats;
}
