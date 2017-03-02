package com.spidernet.dashboard.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spidernet.dashboard.entity.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class EmployeeServiceTest
{
    @Resource
    EmployeeService empService;

    @Test
    public void seachUserByHRNum()
    {
        Employee employee = new Employee();
        employee.setHrNumber("123456");
        employee.setPassword("admin");
        empService.accountValidByErNumber(employee);
    }
}
