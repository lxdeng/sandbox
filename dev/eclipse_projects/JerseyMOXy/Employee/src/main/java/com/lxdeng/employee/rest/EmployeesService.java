package com.lxdeng.employee.rest;

import java.util.ArrayList;

import com.lxdeng.employee.model.Employee;
import com.lxdeng.employee.model.Employees;

public class EmployeesService {
	static Employees ees = new Employees();
	
	static {
		ees.setEmployeeList(new ArrayList<Employee>());
	      
	    ees.getEmployeeList().add(new Employee(1, "Lokesh Gupta"));
	    ees.getEmployeeList().add(new Employee(2, "Alex Kolenchiskey"));
	    ees.getEmployeeList().add(new Employee(3, "David Kameron"));
	} 
}
