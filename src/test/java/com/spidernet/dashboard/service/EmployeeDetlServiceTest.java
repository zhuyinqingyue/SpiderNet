package com.spidernet.dashboard.service;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class EmployeeDetlServiceTest
{

    @Resource
    EmployeeDetlService employeeDetlService;
    
    @Test
    public void testQueryDetail()
    {
        String empId = "14f014a655e04b88b10fc5a502fc4986";
        assertNotNull(employeeDetlService.queryDetail(empId));
    }

}
