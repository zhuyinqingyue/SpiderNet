package com.spidernet.dashboard.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.EmployeeMapper;
import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    @Resource
    private EmployeeMapper userMapper;

    @Override
    public Employee accountValidByErNumber(Employee employee)
    {
        Employee employeeDb = userMapper.accountValidByErNumber(employee);
        return employeeDb;
    }

    @Override
    public Employee accountValidByHrNumber(Employee employee)
    {
        Employee employeeDb = userMapper.accountValidByHrNumber(employee);
        return employeeDb;
    }

    @Override
    public Employee fetchByErNumber(String erNumber)
    {
        Employee employee = userMapper.fetchByErNumber(erNumber);
        return employee;
    }

    @Override
    public Employee fetchByHrNumber(String hrNumber)
    {
        Employee employee = userMapper.fetchByHrNumber(hrNumber);
        return employee;
    }

    @Override
    public Boolean addEmployee(Employee employee)
    {
        if (userMapper.addEmployee(employee) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Boolean checkErExists(String erNumber)
    {
        if(userMapper.checkErExists(erNumber)>0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Boolean checkHrExists(String hrNumber)
    {
        if(userMapper.checkHrExists(hrNumber)>0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Boolean updEmployee(Employee employee)
    {
        if (userMapper.updEmployee(employee) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
