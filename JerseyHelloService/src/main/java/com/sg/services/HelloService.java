package com.sg.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/helloService")
public class HelloService {

	@Path("/sayHello/{age}")
	@GET
	public String sayHello(@QueryParam("name") String name, @PathParam("age") int age) {
		return "hello "+name+" Your age is "+age;
	}   
	
}
