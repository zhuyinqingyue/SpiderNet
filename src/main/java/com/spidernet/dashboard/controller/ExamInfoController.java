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

import com.spidernet.dashboard.entity.ExamInfo;
import com.spidernet.dashboard.entity.ExamPageCondition;
import com.spidernet.dashboard.service.ExamInfoService;

@Controller
@RequestMapping("/examInfo")
public class ExamInfoController
{
    
    @Resource
    ExamInfoService examInfoService;
    
    private static Logger logger = LoggerFactory
            .getLogger(EmployeeInfoController.class);
    
    @RequestMapping("/examInfoList")
    @ResponseBody
    public Object examInfoList(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String examName = request.getParameter("examName");
        
        String projectId = request.getParameter("projectId");
        
        String buId = request.getParameter("buId");
        
        String pageState = request.getParameter("pageState");
        
        String currentPage = null;
        
        int countPage = 0;
        
        ExamPageCondition examPageCondition = new ExamPageCondition();
        
        if("".equals(pageState) || pageState == null){
            currentPage = "0";
            examPageCondition.setBuId(buId);
            examPageCondition.setProjectId(projectId);
            examPageCondition.setExamName(examName);;
            examPageCondition.setCurrentPage(currentPage);
            countPage = examInfoService.countExamPage(examPageCondition);
            examPageCondition.setPageCount(countPage+"");
            request.getSession().setAttribute("examPageCondition", examPageCondition);
        }else if("frist".equals(pageState)){
            currentPage = "0";
            examPageCondition = (ExamPageCondition) request.getSession().getAttribute("examPageCondition");
            examPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("examPageCondition", examPageCondition);
        }else if("next".equals(pageState)){
            examPageCondition = (ExamPageCondition) request.getSession().getAttribute("examPageCondition");
            currentPage = Integer.parseInt(examPageCondition.getCurrentPage()) + 10 +"";
            examPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("examPageCondition", examPageCondition);
        }else if("previous".equals(pageState)){
            examPageCondition = (ExamPageCondition) request.getSession().getAttribute("examPageCondition");
            currentPage = Integer.parseInt(examPageCondition.getCurrentPage()) - 10 +"";
            examPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("examPageCondition", examPageCondition);
        }else if("last".equals(pageState)){
            examPageCondition = (ExamPageCondition) request.getSession().getAttribute("examPageCondition");
            currentPage = (Integer.parseInt(examPageCondition.getPageCount()) - 1) * 10 +"";
            examPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("examPageCondition", examPageCondition);
        }
        
        List<ExamInfo> examInfoList = examInfoService.queryExamInfo(examPageCondition);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("data", examInfoList);
        result.put("pageInfo", request.getSession().getAttribute("examPageCondition"));
        return result;
    }

}
