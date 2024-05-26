package com.sg.studentdata;

import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonToJava {

		public static void main(String args[]) throws JsonMappingException, IOException, JsonMappingException {
			
			ObjectMapper mapper = new ObjectMapper();
			Student student = mapper.readValue(new java.io.File("Student.json"), Student.class);
			
			System.out.println("Json fetched...");
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getMarks());
			
			Address address=student.getAddress();
			
			System.out.println(address.getFlatno());
			System.out.println(address.getBuildingName());
			System.out.println(address.getArea());
			
			
		}
	}

