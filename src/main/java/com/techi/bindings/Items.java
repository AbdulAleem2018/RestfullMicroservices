package com.techi.bindings;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Items {
	
	@Id
	@Column(name="ITEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemNo;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="PURCHASED_DATE")
	private Date purchasedDate;
	
	@Column(name="COST")
	private Double cost;
	

}
