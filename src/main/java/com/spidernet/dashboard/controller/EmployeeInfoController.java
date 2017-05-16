package com.spidernet.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spidernet.dashboard.entity.EmpPageCondition;
import com.spidernet.dashboard.entity.EmployeeInfo;
import com.spidernet.dashboard.service.EmployeeInfoService;

@Controller
@RequestMapping("/employeeInfo")
public class EmployeeInfoController
{
    
    @Resource
    EmployeeInfoService employeeInfoService;
    
    private static Logger logger = LoggerFactory
            .getLogger(EmployeeInfoController.class);
    
    
    @RequestMapping("/employeeInfoList")
    @ResponseBody
    public Object employeeInfoList(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String er = request.getParameter("er");
        
        String buId = request.getParameter("buId");
        
        String projectId = request.getParameter("projectId");
        
        String pageState = request.getParameter("pageState");
        
        String currentPage = null;
        
        int countPage = 0;
        
        EmpPageCondition pageCondition = new EmpPageCondition();
        
        if("".equals(pageState) || pageState == null){
            currentPage = "0";
            pageCondition.setBuId(buId);
            pageCondition.setProjectId(projectId);
            pageCondition.setEr(er);
            pageCondition.setCurrentPage(currentPage);
            countPage = employeeInfoService.countPage(pageCondition);
            pageCondition.setPageCount(countPage+"");
            request.getSession().setAttribute("pageCondition", pageCondition);
        }else if("frist".equals(pageState)){
            currentPage = "0";
            pageCondition = (EmpPageCondition) request.getSession().getAttribute("pageCondition");
            pageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("pageCondition", pageCondition);
        }else if("next".equals(pageState)){
            pageCondition = (EmpPageCondition) request.getSession().getAttribute("pageCondition");
            currentPage = Integer.parseInt(pageCondition.getCurrentPage()) + 10 +"";
            pageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("pageCondition", pageCondition);
        }else if("previous".equals(pageState)){
            pageCondition = (EmpPageCondition) request.getSession().getAttribute("pageCondition");
            currentPage = Integer.parseInt(pageCondition.getCurrentPage()) - 10 +"";
            pageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("pageCondition", pageCondition);
        }else if("last".equals(pageState)){
            pageCondition = (EmpPageCondition) request.getSession().getAttribute("pageCondition");
            currentPage = (Integer.parseInt(pageCondition.getPageCount()) - 1) * 10 +"";
            pageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("pageCondition", pageCondition);
        }
        
        List<EmployeeInfo> listE = employeeInfoService.queryEmpInfo((EmpPageCondition) request.getSession().getAttribute("pageCondition"));
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("data", listE);
        result.put("pageInfo", request.getSession().getAttribute("pageCondition"));
        return result;
    }
    
}
