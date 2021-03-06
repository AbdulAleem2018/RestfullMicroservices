package com.techi;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
/**
 CREATE TABLE PRODUCT (
    PRODUCT_ID NUMBER(10) GENERATED BY DEFAULT AS IDENTITY,
    PRODUCT_NAME VARCHAR2(50) NOT NULL,
    PRODUCT_COST NUMBER(10) NOT NULL,
    MFG_DATE DATE NOT NULL,
    EXPIRE_DATE DATE NOT NULL,
    CONSTRAINT PRODUCT_PK PRIMARY KEY (PRODUCT_ID) 
 );
 
**/
@Data
@Entity
@XmlRootElement
@Table(name="PRODUCT")
public class Product {
	
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_Id;
	
	@Column(name="PRODUCT_NAME")
	private String product_name;
	
	@Column(name="PRODUCT_COST")
	private Double product_cost;
	
	@Column(name="MFG_DATE")
	private Date mfg_date;
	
	@Column(name="EXPIRE_DATE")
	private Date exp_date;
	
}
