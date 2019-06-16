package com.lxdeng.employee.model;

import java.util.List;

public class Employees {
    private List<Employee> employeeList;
 
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
 
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public void addEmployee(Employee e) {
    	employeeList.add(e);
    }
}