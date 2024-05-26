package com.sg.client;

import com.sg.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class GetEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		                      
		Client client = Client.create(clientConfig);
		
		WebResource resource = client.resource("http://localhost:8080/JerseyEmployeeService/rest/employeeService/getEmployeeById/102");
				
//		String result=response.get(String.class);
		Employee employee = resource.accept("application/json").get(Employee.class);
		
		System.out.println("Webservice response -> "+employee);
		
		System.out.println("Employee id: "+employee.getId());
		System.out.println("Employee name: "+employee.getName());
		System.out.println("Employee Salary: "+employee.getsalary());

		
	}

}
