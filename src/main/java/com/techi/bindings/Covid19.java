package com.techi.bindings;

import lombok.Data;
@Data
public class Covid19 {
	
	private String country;
	private String code;
	private int confirmed;
	private int recovered;
	private int critical;
	private int deaths;
	private int latitude;
	private int longitude;
	private String lastChange;
	private String lastUpdate;
}
