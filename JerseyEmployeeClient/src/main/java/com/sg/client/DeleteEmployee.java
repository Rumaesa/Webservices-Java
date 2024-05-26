package com.sg.client;

import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DeleteEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client client = Client.create();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id? ");
		int id = sc.nextInt();
		
		
		WebResource resource = client.resource("http://localhost:8080/JerseyEmployeeService/rest/employeeService/deleteEmployeeById?eid="+id);
		ClientResponse res = resource.get(ClientResponse.class);
		int status = res.getStatus();
		String response = res.getEntity(String.class);
		System.out.println("status = "+status);
		System.out.println("Response = "+response);
	}

}
