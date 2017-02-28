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
@SessionAttributes("employeeTemp")
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
        Employee employeeTemp = null;

        if (patternEr.matcher(userName).matches()) {
            employeeTemp = new Employee();
            employee.setErNumber(userName);
            employeeTemp = userService.accountValidByErNumber(employee);
        } else if (patternHr.matcher(userName).matches()) {
            employeeTemp = new Employee();
            employee.setHrNumber(userName);
            employeeTemp = userService.accountValidByHrNumber(employee);
        } else if (patternWechat.matcher(userName).matches()) {
            //employee.setWechatOpenId(userName);
        }

        if (employeeTemp != null)
        {
            logger.info("Find the Employee correctly, enter the index page");
            mv.setViewName("index");
            mv.addObject("employee", employeeTemp);
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
