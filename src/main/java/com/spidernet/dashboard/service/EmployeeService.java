package com.spidernet.dashboard.service;

import com.spidernet.dashboard.entity.Employee;

public interface EmployeeService
{
    Employee accountValidByErNumber(Employee employee);
    Employee accountValidByHrNumber(Employee employee);
    Employee fetchByErNumber(String erNumber);
    Employee fetchByHrNumber(String hrNumber);
    Boolean addEmployee(Employee employee);
    Boolean checkErExists(String erNumber);
    Boolean checkHrExists(String hrNumber);
    Boolean updEmployee(Employee employee);
}
