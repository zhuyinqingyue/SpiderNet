package com.spidernet.dashboard.service;

import com.spidernet.dashboard.entity.Employee;

public interface EmployeeService
{
    Boolean accountValid(Employee employee);
    Employee accountValidByErNumber(Employee employee);
    Employee accountValidByHrNumber(Employee employee);
    Employee fetchByErNumber(String erNumber);
    Employee fetchByHrNumber(String hrNumber);
}
