package com.lxdeng.employee.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lxdeng.employee.model.Employee;
import com.lxdeng.employee.model.Employees;

// https://howtodoinjava.com/jersey/jax-rs-jersey-moxy-json-example/
	
@Path("/employees")
public class EmployeesResource {
		
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employees getAllEmployees() { 
    	return EmployeesService.ees;
    }
    
    
    /*
    $ curl -X POST -H "Content-Type:application/json" --data @employee.txt http://localhost:8080/employees
    $ cat employee.txt 
    {
      "id": 4,
      "name": "Tom"
    }
	*/
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public int createEmployee(Employee e) {
    	System.out.println(e);
    	EmployeesService.ees.addEmployee(e);
    	return e.getId();
    }
    
}  