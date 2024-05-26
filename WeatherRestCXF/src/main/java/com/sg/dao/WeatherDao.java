package com.sg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sg.model.Weather;

public class WeatherDao {

	public Weather getWeatherByCity(String cityName) {
		
		String name = cityName;
		Weather weather = null;
		
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.dbConnect();
		
		String sql = "select * from weather where cityName=?";
		try {
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setString(1, cityName);
			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) {
				weather = new Weather();
				weather.setCityId(rst.getInt(1));
				weather.setCityName(rst.getString(2));
				weather.setTemp(rst.getInt(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conFactory.dbClose();
		
		return null;
	}
	
}
