package com.techi.bindings;

import org.springframework.hateoas.RepresentationModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends RepresentationModel<Book> {
	//RepresentationModel is hateoas class
	private int id;
	private String name;
	private String authour;
	private double price;
}
