package com.spidernet.dashboard.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.service.EmployeeService;

@Controller
public class LoginController
{
    @Resource
    EmployeeService userService;

    private static Logger logger = LoggerFactory
            .getLogger(LoginController.class);

    @RequestMapping("/loginPage")
    public String loginPage(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.info("debug------test----");
        return "login";
    }

    @RequestMapping("/checkUser")
    public String checkUser(final HttpServletRequest request,
            final HttpServletResponse response, Employee employee)
    {
        employee.setHrNumber(employee.getName());
        boolean emp = userService.accountValid(employee);
        if (emp)
        {
            return "index";
        }
        else
        {
            return "login";
        }
    }

}
