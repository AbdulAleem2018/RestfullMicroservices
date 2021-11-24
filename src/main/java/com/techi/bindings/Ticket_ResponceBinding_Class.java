package com.techi.bindings;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Ticket_ResponceBinding_Class {
	
	private String pnr;
	private String ticketStatus;
	private String ticketPrice;
	private String name;
	private String fromAndTo;
	private String dateOfJourny;
}
