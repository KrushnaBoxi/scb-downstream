package com.scb.downstreamstub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.scb.downstreamstub.model.CustomerRequest;
import com.scb.downstreamstub.model.CustomerRequestData;
import com.scb.downstreamstub.model.CustomerResponse;
import com.scb.downstreamstub.service.CustomerRequestService;
import com.scb.downstreamstub.utils.ReceiverConstants;

import lombok.extern.log4j.Log4j2;


@RestController @Log4j2
@RequestMapping(ReceiverConstants.CUSTOMER_URL)
public class CustomerRequestController {
	@Autowired
	private CustomerRequestService customerRequestService;

	@RequestMapping(value = ReceiverConstants.CUSTOMER_REQUEST_HANDLE_URL, method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public ResponseEntity<CustomerRequestData> customerRequestHandle(@RequestBody CustomerRequestData customerRequestData ) {
		log.info("Request received "+ customerRequestData.toString());
		CustomerResponse customerResponse = new CustomerResponse();
			customerResponse = customerRequestService.customerRequestHandleService(customerRequestData);
		log.info("Response: "+customerResponse.toString());
		return new ResponseEntity<CustomerRequestData>(customerResponse.getCustomerRequestData(), HttpStatus.OK);
		//return customerResponse;
	}

	@RequestMapping(value = ReceiverConstants.CUSTOMER_REQUEST_HANDLE_URL_REQUEST)
	public CustomerRequest customerRequestHandleExampleRequest() {

		return CustomerRequest.builder().customerAccType("Saving").customerId(22).customerName("Test Customer")
				.customerRegion("India").corelationId(200).build();
		// return
		// customerRequestService.customerRequestHandleService(customerRequest);

	}

}