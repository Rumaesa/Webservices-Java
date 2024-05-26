package com.sg.services;

import javax.jws.WebService;

@WebService(targetNamespace = "http://services.sg.com/", portName = "CalServicePort", serviceName = "CalServiceService")
public class CalService {

	public int add(int i, int j) {
		return i+j;
	}
	
}
