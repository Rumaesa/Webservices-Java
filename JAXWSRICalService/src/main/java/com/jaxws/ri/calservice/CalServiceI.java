package com.jaxws.ri.calservice;

import javax.jws.WebService;

@WebService
public interface CalServiceI {

	public int add(int i, int j);
	public int sub(int i, int j);
}
