package com.sg.client;

import java.util.Scanner;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UpdateEmployeeSalary {

	public static void main(String[] args) {

		Client client = Client.create();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter employee Id ? ");
		int id = sc.nextInt();

		System.out.println("Enter the salary ? ");
		int salary = sc.nextInt();

		WebResource resource = client.resource(
				"http://localhost:8080/JerseyEmployeeService/rest/employeeService/updateSalary/"+id+"/"+salary);

		ClientResponse res = resource.get(ClientResponse.class);

		int statusCode = res.getStatus();
		String resp = res.getEntity(String.class);
		
		System.out.println("status = "+statusCode);
		System.out.println("response = "+resp);

	}

}
