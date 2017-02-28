package com.spidernet.dashboard.controller;

import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.service.EmployeeService;
import com.spidernet.util.Constants;

@Controller
@SessionAttributes("employee")
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
        return "login";
    }

    @RequestMapping("/top")
    public String top(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        return "top";
    }

    @RequestMapping("/left")
    public String left(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        return "left";
    }

    @RequestMapping("/footer")
    public String footer(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        return "footer";
    }

    @RequestMapping("/checkUser")
    public ModelAndView checkUser(final HttpServletRequest request,
            final HttpServletResponse response, Employee employee)
    {
        String userName = request.getParameter("userName");
        request.getSession().setAttribute("SystemName", "SpiderNet");

        Pattern patternEr = Pattern.compile(Constants.ER_PATTERN);
        Pattern patternHr = Pattern.compile(Constants.HR_PATTERN);
        Pattern patternWechat = Pattern.compile(Constants.WECHAT_PATTERN);
        ModelAndView mv = new ModelAndView();

        if (patternEr.matcher(userName).matches()) {
            employee.setErNumber(userName);
            employee = userService.accountValidByErNumber(employee);
        } else if (patternHr.matcher(userName).matches()) {
            employee.setHrNumber(userName);
            employee = userService.accountValidByHrNumber(employee);
        } else if (patternWechat.matcher(userName).matches()) {
            //employee.setWechatOpenId(userName);
        }

        if (employee != null)
        {
            logger.info("Find the Employee correctly, enter the index page");
            mv.setViewName("index");
            mv.addObject("employee", employee);
            return mv;
        }
        else
        {
            logger.info("Can not find the Employee in the DB");
            mv.setViewName("login");
            return mv;
        }
    }

}
