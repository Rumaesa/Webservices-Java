package com.sg.service.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class HelloServiceClient {

	public static void main(String args[]) {
	Client client = Client.create();
	
	WebResource response = client.resource("http://localhost:8080/JerseyHelloService/rest/helloService/sayHello/23?name=Rumaesa");
	
	String result=response.get(String.class);
	
	System.out.println("Webservice response -> "+result);

	}
}
	