package com.techi.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
//@Data
@XmlRootElement//This class is become binding class
/** Using binding class object we can perform marshaling and un-marshaling
 * When we perform marshalling, binding class name will be considered as root element and binding classs variables will be considered as child elements **/
public class Student {
	
//	private Integer studentId;
//	private String studentName;
//	private Integer studentRank;
//	private Integer studentAge;
//	private Address address;
	
	//If you want represent one variable as xml attribute then we will use @XmlAttribute annotation
	@XmlAttribute(name="id")
	private Integer studentId;
	
	@XmlAttribute(name="name")
	private String studentName;
	
	@XmlElement(name="rank")
	private Integer studentRank;
	
	@XmlElement(name="age")
	private Integer studentAge;
	
	//@XmlElement(name="studentAddress")
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Integer getStudentRank() {
		return studentRank;
	}
	public void setStudentRank(Integer studentRank) {
		this.studentRank = studentRank;
	}
	public Integer getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentRank=" + studentRank
				+ ", studentAge=" + studentAge + ", address=" + address + "]";
	}
}