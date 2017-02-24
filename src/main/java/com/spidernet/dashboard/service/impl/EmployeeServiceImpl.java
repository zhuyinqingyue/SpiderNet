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
    public boolean accountValid(Employee employee)
    {
        if (userMapper.accountValid(employee) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
