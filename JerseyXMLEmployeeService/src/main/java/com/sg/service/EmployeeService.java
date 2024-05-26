package com.sg.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.sg.dao.ConnectionFactory;
import com.sg.model.Employee;

@Path("/employeeService")
public class EmployeeService{

	@GET
	@Path("/getEmployeeById/{id}")
	@Produces("application/xml")
	public Employee getEmployeeById(@PathParam("id") int id) {
		Employee employee = null;
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.dbConnect();
		String sql = "select * from employee where id=?";
		try {
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setInt(1, id);
			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) {
				employee = new Employee();
				employee.setId(rst.getInt(1));
				employee.setName(rst.getString(2));
				employee.setsalary(rst.getInt(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conFactory.dbClose();
		return employee;
	}
	
	@POST
	@Path("/createEmployee")
	@Consumes("application/xml")
	public Response createEmployee(Employee employee) {
		
		Response response = null;
		int id = employee.getId();
		String name = employee.getName();
		int salary = employee.getsalary();
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.dbConnect();
		String sql = "insert into employee values(?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, salary);
			
			int noOfRecordsUpdated = pstmt.executeUpdate();
			if(noOfRecordsUpdated>0) {
				response = Response.status(200).entity("employee inserted successfully..").build();
			}
			else {
				response = Response.status(201).entity("employee insertion failed..").build();
			}
			} catch (SQLException e) {
			e.printStackTrace();
			response = Response.status(202).entity("employee insertion failed..").build();
		}
		conFactory.dbClose();
		return response;
	}
	
	
	@GET
	@Path("/deleteEmployeeById")
	public Response deleteEmployeeById(@QueryParam("eid") int eid) {
		
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.dbConnect();
		String sql = "delete from employee where id=?";
		Response response = null;
		
		try {
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setInt(1, eid);
			
			int noOfRecordsUpdated = pstmt.executeUpdate();
			if(noOfRecordsUpdated>0) {
				response = Response.status(200).entity("employee deleted successfully..").build();
			}
			else {
				response = Response.status(201).entity("employee deletion failed..").build();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response = Response.status(200).entity("employee deletion failed..").build();
		}
		conFactory.dbClose();
		return response;		
	}
	
	@DELETE
	@Consumes("application/xml")
	@Path("/deleteEmployee")
	public Response deleteEmployee(Employee employee) {
		Response response = null;
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.dbConnect();
		String sql = "delete from employee where id=?";
		int id = employee.getId();
		try {
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setInt(1, id);
			
			int noOfRecordsUpdated = pstmt.executeUpdate();
			if(noOfRecordsUpdated>0) {
				response = Response.status(200).entity("employee deleted successfully..").build();
			}
			else {
				response = Response.status(201).entity("employee deletion failed..").build();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response = Response.status(200).entity("employee deletion failed..").build();
		}
		conFactory.dbClose();
		
		return response;
	}
	
	@GET
	@Path("/updateSalary/{id}/{salary}")
	public Response updateEmployeeSalary(@PathParam("id") int id, @PathParam("salary") int salary) {
		Response response = null;
		
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection con = conFactory.dbConnect();
		String sql = "update employee set salary=? where id=?";
		try {
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setInt(1, salary);
			pstmt.setInt(2, id);
			
			int noOfRecordsUpdated = pstmt.executeUpdate();
			if(noOfRecordsUpdated>0) {
				response = Response.status(200).entity("salary updated successfully..").build();
			}
			else {
				response = Response.status(201).entity("salary update failed..").build();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			response = Response.status(200).entity("salary update failed..").build();
		}
		conFactory.dbClose();
		
		return response;
	}
}

