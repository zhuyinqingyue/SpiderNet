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

import com.spidernet.dashboard.entity.Bu;
import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.service.BuService;

@Controller
@RequestMapping("/bu")
public class BuController
{
    private static Logger logger = LoggerFactory
            .getLogger(BuController.class);
    
    @Resource
    BuService buService;
    
    @RequestMapping("/queryBuName")
    @ResponseBody
    public Object queryAll(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.info("debug------test----");

        HttpSession session = request.getSession();

        Employee employee = (Employee) session.getAttribute("employee");

        String buId = employee.getBuId();

        Bu bu = buService.findBuName(buId);
        
        return bu;
    }
}
