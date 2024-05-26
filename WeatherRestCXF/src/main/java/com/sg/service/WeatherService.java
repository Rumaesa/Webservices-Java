package com.sg.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.sg.dao.WeatherDao;
import com.sg.model.Weather;

@Path("/weatherService")
public class WeatherService {

	private WeatherDao weatherDao;
	
	public WeatherDao getWeatherDao() {
		return weatherDao;
	}
	
	public void setWeatherDao(WeatherDao weatherDao) {
		this.weatherDao = weatherDao;
	}
	
	
	@GET
	@Path("/getWeatherByCity")
	@Produces({"application/xml","application/json"})
	public Weather getWeatherByCity(@QueryParam("city") String cityName) {
		return weatherDao.getWeatherByCity(cityName);
	}
	
	@POST
	@Path("/createWeather")
	@Consumes({"application/json", "application/xml"})
	public Response createWeather(Weather weather) {
		Response response = null;
		
		return response;
	}
}
