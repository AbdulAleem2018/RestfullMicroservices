package com.techi.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
//@Data
@XmlRootElement//This class is become binding class
public class Address {
	
	
	private String country;
	private String state;
	private String city;
	
	public Address() {
		super();
	}
	public Address(String country, String state, String city) {
		super();
		this.country = country;
		this.state = state;
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
		public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [country=" + country + ", state=" + state + ", city=" + city + "]";
	}
}