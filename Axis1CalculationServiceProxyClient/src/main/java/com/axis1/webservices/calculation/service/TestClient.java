package com.axis1.webservices.calculation.service;

import java.net.MalformedURLException;

public class TestClient {

	public static void main(String[] args) throws Exception {

		java.net.URL url = new java.net.URL("http://localhost:8080/Axis1CalculationService/services/CalService?wsdl");
		
		org.apache.axis.client.Service service = new org.apache.axis.client.Service(); 
		
		CalServiceSoapBindingStub stub = new CalServiceSoapBindingStub(url, service); 
		
		int result = stub.add(10, 10);
		
		System.out.println("Result of Cal Service's add method ->" +result);
		
	}

}
