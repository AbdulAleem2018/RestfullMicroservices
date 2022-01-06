package com.techi.bindings;

import lombok.Data;
@Data
public class DailyCovid {

	private String country;
	Provinces[] provinces;
	private int latitude;
	private int longitude;
	private String date;
}
