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

import com.spidernet.dashboard.entity.ProCapabilityInfo;
import com.spidernet.dashboard.entity.ProCapablityPageCondition;
import com.spidernet.dashboard.service.ProCapabilityInfoService;

@Controller
@RequestMapping("/proCapabilityInfo")
public class ProCapabilityInfoController
{
    
    @Resource
    ProCapabilityInfoService proCapabilityInfoService;
    
    private static Logger logger = LoggerFactory
            .getLogger(ProCapabilityInfoController.class);
    
    @RequestMapping("/proCapabilityInfoList")
    @ResponseBody
    public Object proCapabilityInfoList(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String buId = request.getParameter("buId");
        
        String projectId = request.getParameter("projectId");
        
        String typeId = request.getParameter("typeId");
        
        String levelId = request.getParameter("levelId");
        
        String blockId = request.getParameter("blockId");
        
        String proCapabilityName = request.getParameter("proCapabilityName");
        
        String pageState = request.getParameter("pageState");
        
        String currentPage = null;
        
        int countPage = 0;
        
        ProCapablityPageCondition proCapablityPageCondition = new ProCapablityPageCondition();
        
        if("".equals(pageState) || pageState == null){
            currentPage = "0";
            proCapablityPageCondition.setBlockId(blockId);
            proCapablityPageCondition.setBuId(buId);
            proCapablityPageCondition.setProjectId(projectId);
            proCapablityPageCondition.setTypeId(typeId);
            proCapablityPageCondition.setLevelId(levelId);
            proCapablityPageCondition.setProCapabilityName(proCapabilityName);
            proCapablityPageCondition.setCurrentPage(currentPage);
            countPage = proCapabilityInfoService.countProCapabilityPage(proCapablityPageCondition);
            proCapablityPageCondition.setPageCount(countPage+"");
            request.getSession().setAttribute("proCapablityPageCondition", proCapablityPageCondition);
        }else if("frist".equals(pageState)){
            currentPage = "0";
            proCapablityPageCondition = (ProCapablityPageCondition) request.getSession().getAttribute("proCapablityPageCondition");
            proCapablityPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("proCapablityPageCondition", proCapablityPageCondition);
        }else if("next".equals(pageState)){
            proCapablityPageCondition = (ProCapablityPageCondition) request.getSession().getAttribute("proCapablityPageCondition");
            currentPage = Integer.parseInt(proCapablityPageCondition.getCurrentPage()) + 10 +"";
            proCapablityPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("proCapablityPageCondition", proCapablityPageCondition);
        }else if("previous".equals(pageState)){
            proCapablityPageCondition = (ProCapablityPageCondition) request.getSession().getAttribute("proCapablityPageCondition");
            currentPage = Integer.parseInt(proCapablityPageCondition.getCurrentPage()) - 10 +"";
            proCapablityPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("proCapablityPageCondition", proCapablityPageCondition);
        }else if("last".equals(pageState)){
            proCapablityPageCondition = (ProCapablityPageCondition) request.getSession().getAttribute("proCapablityPageCondition");
            currentPage = (Integer.parseInt(proCapablityPageCondition.getPageCount()) - 1) * 10 +"";
            proCapablityPageCondition.setCurrentPage(currentPage);
            request.getSession().setAttribute("proCapablityPageCondition", proCapablityPageCondition);
        }
        
        List<ProCapabilityInfo> proCapabilityList = proCapabilityInfoService.queryProCapabilityInfo(proCapablityPageCondition);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("data", proCapabilityList);
        result.put("pageInfo", request.getSession().getAttribute("proCapablityPageCondition"));
        
        return result;
    }

}
