package com.spidernet.dashboard.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.EmployeeDetlMapper;
import com.spidernet.dashboard.entity.EmployeeDetl;
import com.spidernet.dashboard.service.EmployeeDetlService;

@Service
public class EmployeeDetlServiceImpl implements EmployeeDetlService
{
    @Resource
    private EmployeeDetlMapper employeeDetlMapper;

    @Override
    public EmployeeDetl queryDetail(String empId)
    {
        EmployeeDetl employeeDetl = employeeDetlMapper.queryDetail(empId);
        
        return employeeDetl;
    }

}
