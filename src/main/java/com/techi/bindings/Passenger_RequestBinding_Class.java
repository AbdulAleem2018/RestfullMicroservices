package com.techi.bindings;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Passenger_RequestBinding_Class {

	private String firstName;
	private String lastName;
	private String journeyfrom;
	private String destination;
	private String dateOfJourney;
}
