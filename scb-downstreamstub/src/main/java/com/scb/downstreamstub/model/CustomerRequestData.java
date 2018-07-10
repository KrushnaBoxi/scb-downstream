package com.scb.downstreamstub.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @XmlRootElement @XmlAccessorType(XmlAccessType.FIELD) 
public class CustomerRequestData {
	private long customerId;
	private String customerName;
	private int serviceId;
	private String customerAccType;
	private String customerRegion;
	private String timeStamp;
	private long corelationId;
	private long transactionId;
	private String downStreamResponse;
}
