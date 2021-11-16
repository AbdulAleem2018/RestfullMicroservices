package com.techi.converters;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.techi.bindings.Address;
import com.techi.bindings.Student;

public class MarshallingAndUnMarshalling {

	public static void main(String[] args) {
		
		JAXBContext context;
		Address address=new Address("India","Telangana","Hyderabad");
		Student student=new Student();
		student.setStudentId(1);
		student.setStudentName("Aleem");
		student.setStudentAge(36);
		student.setStudentRank(5);
		student.setAddress(address);
		try {
			//Marshalling(Convert java object to xml format)
			context = JAXBContext.newInstance(Student.class);
			Marshaller marsheller=context.createMarshaller();
			marsheller.marshal(student,System.out);
			
			//Un-Marshalling(Convert Xml to java Object)
			Unmarshaller unmarshaller=context.createUnmarshaller();
			Student convertedToStudentObj=(Student) unmarshaller.unmarshal(new File("Student.xml"));
			System.out.println(convertedToStudentObj);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}

/**Marshalling:
 * <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<student id="1" name="Aleem">
	<rank>5</rank>
	<age>36</age>
	<address>
		<country>India</country>
		<state>Telangana</state>
		<city>Hyderabad</city>
	</address>
</student>

Un-Marshalling:
Student [studentId=1, studentName=Aleem, studentRank=5, studentAge=36, address=Address [country=India, state=Telangana, city=Hyderabad]]
 * **/