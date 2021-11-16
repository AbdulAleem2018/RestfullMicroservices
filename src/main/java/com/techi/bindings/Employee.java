package com.techi.bindings;

public class Employee {
	
	private Integer id;
	private String name;
	private String organization;
	private String location;
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(Integer id, String name, String organization, String location) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.location = location;
	}


	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getOrganization() {
		return organization;
	}


	public String getLocation() {
		return location;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", organization=" + organization + ", location=" + location
				+ "]";
	}

}
