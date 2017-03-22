package com.spidernet.dashboard.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spidernet.dashboard.entity.Employee;
import com.spidernet.util.Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
@Transactional
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
    @Rollback(true)
    public void testAddEmployee()
    {
        Boolean reg = false;
        Employee employeeTemp = new Employee();
        String uuid = Utils.getUUID();
        employeeTemp.setEmployeeId(uuid);
        employeeTemp.setErNumber("E100066789");
        employeeTemp.setHrNumber("66789");
        employeeTemp.setName("ëë");
        employeeTemp.seteName("Freded");
        employeeTemp.setEmpLevelId("e5b4d2d0792f4b88950c4fe2383b8068");
        employeeTemp.setEmpTypeId("a6b8fd9eb5e547da907c7a004810d0a1");
        employeeTemp.setBuId("be27be6911304fd1a265dfcf8d5cc80f");
        employeeTemp.setProjectId("083c3e88219542739ed202bbc38a56ea");
        
        reg = employeeService.addEmployee(employeeTemp);
        assertTrue(reg);
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
