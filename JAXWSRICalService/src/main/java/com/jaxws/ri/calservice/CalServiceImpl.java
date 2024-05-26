package com.jaxws.ri.calservice;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jaxws.ri.calservice.CalServiceI", serviceName = "calServiceImpl",targetNamespace = "http://www.calService.com")
public class CalServiceImpl implements CalServiceI{

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		return i+j;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		return i-j;
	}

	
	
}
