package com.sg.client;

import java.util.Scanner;

import com.sg.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;

public class CreateEmployee {

	public static void main(String[] args) {

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);
		client.addFilter(new HTTPBasicAuthFilter("rumaesa","@Rumi"));
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter employee id ?");
		int id = scanner.nextInt();
		System.out.println("Enter employee name ?");
		String name = scanner.next();
		System.out.println("Enter salary ?");
		int salary = scanner.nextInt();
		
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setsalary(salary);
		
		WebResource resource = client.resource("http://localhost:8080/JerseyEmployeeService/rest/employeeService/createEmployee");
				
		ClientResponse res = resource.type("application/json").post(ClientResponse.class, employee);
		
		int statusCode = res.getStatus();
		String resp = res.getEntity(String.class);
		System.out.println("Status Code =  "+statusCode);
		System.out.println("Output = "+resp);
		
		
	}

}
