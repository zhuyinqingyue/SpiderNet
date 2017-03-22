package com.spidernet.dashboard.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
    EmployeeService employeeService;

    @Test
    public void testAccountValidByErNumber()
    {
        Employee employee = new Employee();
        String erNumber = "E100033556";
        String password = "admin";
        employee.setErNumber(erNumber);
        employee.setPassword(password);

        assertNotNull(employeeService.accountValidByErNumber(employee));
    }

    @Test
    public void testAccountValidByHrNumber()
    {
        Employee employee = new Employee();
        String hrNumber = "123456";
        String password = "admin";
        employee.setErNumber(hrNumber);
        employee.setPassword(password);

        assertNotNull(employeeService.accountValidByHrNumber(employee));
    }

    @Test
    public void testFetchByErNumber()
    {
        String erNumber = "E100033556";
        assertNotNull(employeeService.fetchByErNumber(erNumber));
    }

    @Test
    public void testFetchByHrNumber()
    {
        String hrNumber = "123456";
        assertNotNull(employeeService.fetchByHrNumber(hrNumber));
    }

    @Test
    public void testAddEmployee()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testCheckErExists()
    {
        String erNum = "E100033556";
        assertFalse(employeeService.checkErExists(erNum));
    }

    @Test
    public void testCheckHrExists()
    {
        String hrNum = "123456";
        assertFalse(employeeService.checkHrExists(hrNum));
    }

}
