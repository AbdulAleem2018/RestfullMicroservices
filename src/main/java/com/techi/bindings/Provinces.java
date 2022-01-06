package com.techi.bindings;

import lombok.Data;

@Data
public class Provinces {
	
	private String province;
	private int confirmed;
	private int recovered;
	private int deaths;
	private int active;
}
