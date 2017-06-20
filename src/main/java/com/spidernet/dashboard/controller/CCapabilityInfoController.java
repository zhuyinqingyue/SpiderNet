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

import com.spidernet.dashboard.entity.CCapabilityInfo;
import com.spidernet.dashboard.entity.CCapabilityPageCondition;
import com.spidernet.dashboard.service.CCapabilityInfoService;

@Controller
@RequestMapping("/cCapabilityInfo")
public class CCapabilityInfoController
{

    @Resource
    CCapabilityInfoService cCapabilityInfoService;
    
    private static Logger logger = LoggerFactory
            .getLogger(CCapabilityInfoController.class);
    
    @RequestMapping("/cCapabilityInfoList")
    @ResponseBody
    public Object cCapabilityInfoList(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String blockId = request.getParameter("cBlock");
        
        String capabilityName = request.getParameter("cCapabilityName");
        
        String pageState = request.getParameter("pageState");
        
        String currentPage = null;
        
        int countPage = 0;
        
        CCapabilityPageCondition cCapabilityPageCondition = new CCapabilityPageCondition();
        
        if("".equals(pageState) || pageState == null){
            currentPage = "0";
            cCapabilityPageCondition.setBlockId(blockId);
            cCapabilityPageCondition.setcCapabilityName(capabilityName);
            cCapabilityPageCondition.setCurrentPage(currentPage);
            countPage = cCapabilityInfoService.countCommonCapabilityPage(cCapabilityPageCondition);
            cCapabilityPageCondition.setPageCount(countPage+"");
            request.getSession().setAttribute("cCapabilityPageCondition", cCapabilityPageCondition);
        }else if("frist".equals(pageState)){
            currentPage = "0";
            cCapabilityPageCondition = (CCapabilityPageCondition) request.getSession().getAttribute("cCapabilityPageCondition");
            cCapabilityPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("cCapabilityPageCondition", cCapabilityPageCondition);
        }else if("next".equals(pageState)){
            cCapabilityPageCondition = (CCapabilityPageCondition) request.getSession().getAttribute("cCapabilityPageCondition");
            currentPage = Integer.parseInt(cCapabilityPageCondition.getCurrentPage()) + 10 +"";
            cCapabilityPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("cCapabilityPageCondition", cCapabilityPageCondition);
        }else if("previous".equals(pageState)){
            cCapabilityPageCondition = (CCapabilityPageCondition) request.getSession().getAttribute("cCapabilityPageCondition");
            currentPage = Integer.parseInt(cCapabilityPageCondition.getCurrentPage()) - 10 +"";
            cCapabilityPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("cCapabilityPageCondition", cCapabilityPageCondition);
        }else if("last".equals(pageState)){
            cCapabilityPageCondition = (CCapabilityPageCondition) request.getSession().getAttribute("cCapabilityPageCondition");
            currentPage = (Integer.parseInt(cCapabilityPageCondition.getPageCount()) - 1) * 10 +"";
            cCapabilityPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("cCapabilityPageCondition", cCapabilityPageCondition);
        }
        
        List<CCapabilityInfo> cCapabilityInfoList = cCapabilityInfoService.queryCommonCapabilityInfo(cCapabilityPageCondition);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("data", cCapabilityInfoList);
        result.put("pageInfo", request.getSession().getAttribute("cCapabilityPageCondition"));
        
        return result;
    }
    
}
