package com.spidernet.dashboard.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spidernet.dashboard.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController
{
    @Resource
    EmployeeService userService;
}
