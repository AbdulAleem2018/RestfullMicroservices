package com.techi.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.techi.bindings.Book;

@RestController
public class BookControllerUsingHateoas {

	@GetMapping(value="/book/{bid}")
	public Book getSelectedBookInfo(@PathVariable("bid") int bid) {
		
		Book book=new Book(bid,"Spring","kathe Seray",500.00);
		
		//Logic to construct hyperlink using HATEOAS
		Link bookLink=WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookControllerUsingHateoas.class).getAllBooksInfo()).withRel("All Spring Books");
				
		book.add(bookLink);
		return book;
	}
	/*Test-1:
	 Request: GET:http://localhost:8080/book/1  and accept=application/json
	 
	 Response Body:
	 {
    	"id": 1,
    	"name": "Spring",
    	"authour": "kathe Seray",
    	"price": 500.0,
    	"_links": {
        	"All Spring Books": {
            	"href": "http://localhost:8080/books"
        	}
    	}
	  }
	Test-2:
	Request: GET:http://localhost:8080/book/1  and accept=application/xml
	ResponseBody: No Response in Body
	
	Test-3:
	GET:http://localhost:8080/books  and accept=application/json
	ResponseBody:
	[
    {
        "id": 1,
        "name": "Spring",
        "authour": "Kathe seray",
        "price": 550.0,
        "links": []
    },
    {
        "id": 2,
        "name": "Spring Boot",
        "authour": "Rad Jonson",
        "price": 720.0,
        "links": []
    },
    {
        "id": 3,
        "name": "Spring Cloud",
        "authour": "Preeti Shenoy",
        "price": 200.0,
        "links": []
    }
	]
	 
	 */
	
	@GetMapping(value="/books",produces={"application/json","application/xml"})
	public List<Book> getAllBooksInfo() {
		Book springBook=new Book(1,"Spring", "Kathe seray",550.00);
		Book springBootBook=new Book(2,"Spring Boot","Rad Jonson",720.00);
		Book springCloudBook=new Book(3,"Spring Cloud", "Preeti Shenoy",200.00);
		List<Book> books=Arrays.asList(springBook,springBootBook,springCloudBook);
		return books;
	}
}