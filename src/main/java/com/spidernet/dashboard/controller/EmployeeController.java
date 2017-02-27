package com.spidernet.dashboard.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
