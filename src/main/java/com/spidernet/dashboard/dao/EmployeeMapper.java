package com.spidernet.dashboard.dao;

import com.spidernet.dashboard.entity.Employee;

public interface EmployeeMapper
{
    int accountValid(Employee employee);
    Employee fetchByErNumber(String erNumber);
    Employee fetchByHrNumber(String hrNumber);
    Employee accountValidByErNumber(Employee employee);
    Employee accountValidByHrNumber(Employee employee);
    int addEmployee(Employee employee);
    int checkErExists(String erNumber);
    int checkHrExists(String hrNumber);
}
