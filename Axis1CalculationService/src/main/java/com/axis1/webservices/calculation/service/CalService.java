package com.axis1.webservices.calculation.service;

public class CalService {

	public int add(int i, int j) {
		if(i<1 && j<1) {
			throw new ArithmeticException("Pls send valid values");
		}
		
		return i+j;
	}
	
	public int addition(int[] i, int j) {
		if(i[0]<1 && j<1) {
			throw new ArithmeticException("Pls send valid values");
		}
		
		return i[0]+j;
	}
	
}
