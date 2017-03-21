package com.spidernet.dashboard.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class EmployeeServiceTest
{

    @Resource
    EmployeeService employeeService;
    
    @Test
    public void testAccountValid()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testAccountValidByErNumber()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testAccountValidByHrNumber()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testFetchByErNumber()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testFetchByHrNumber()
    {
        fail("Not yet implemented");
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
