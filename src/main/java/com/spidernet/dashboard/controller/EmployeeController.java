package com.spidernet.dashboard.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.service.EmployeeService;

@Controller
@RequestMapping(value="/employee")
public class EmployeeController {
	@Resource
	EmployeeService userService;
	
	private static Logger logger = LoggerFactory
            .getLogger(EmployeeController.class);

    @RequestMapping("/register")
    public String register(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.info("debug------test----");
        return "employee/register";
    }

    @RequestMapping("/queryEmpInfo")
    @ResponseBody
    public Employee queryEmpInfo(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.info("debug------test----");
        
        HttpSession session = request.getSession();
        
        Employee employee = new Employee();
        
        employee = (Employee) session.getAttribute("employee");
        
        return employee;
    }
    
    @RequestMapping("/index")
    public String index(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.info("debug------test----");
        return "index";
    }



}
