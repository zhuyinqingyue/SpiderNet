package com.spidernet.dashboard.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spidernet.dashboard.entity.CCapability;
import com.spidernet.dashboard.service.CCapabilityService;
import com.spidernet.util.Utils;

@Controller
@RequestMapping("/commonCapability")
public class CCapabilityController
{
    @Resource
    CCapabilityService cCapabilityService;
    
    private static Logger logger = LoggerFactory.getLogger(CCapabilityController.class);
    
    @RequestMapping("/queryCCapability")
    @ResponseBody
    public Object queryCCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        List<CCapability> cCapabilityList = cCapabilityService.queryCommonCapability();

        return cCapabilityList;
    }
    
    
    @RequestMapping("/addCCapability")
    @ResponseBody
    public boolean addCCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String commCapabilityId = Utils.getUUID();
        String blockId = request.getParameter("cBlock2");
        String name = request.getParameter("cCapabilityName2");
        String description = request.getParameter("cDescribe");
        int sort = cCapabilityService.getSortByBlockId(blockId);
        String url = request.getParameter("cCapabilityURL");
        String parentId = request.getParameter("parentCapability");
        String buList = request.getParameter("buList");
        
        CCapability cCapability = new CCapability();
        
        cCapability.setCommCapabilityId(commCapabilityId);
        cCapability.setBlockId(blockId);
        cCapability.setName(name);
        cCapability.setDescription(description);
        cCapability.setSort(sort);
        cCapability.setUrl(url);
        cCapability.setParentId(parentId);
        cCapability.setBuList(buList);
        
        boolean resultFlag = cCapabilityService.addCommonCapability(cCapability);
        
        return resultFlag;
    }
    
    
    @RequestMapping("/queryParentCapability")
    @ResponseBody
    public Object queryCCapabilityListByBlockId(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String blockId = request.getParameter("blockId");
        
        List<CCapability> cCapabilityListB =  cCapabilityService.queryCCapabilityListByBlockId(blockId);
        
        return cCapabilityListB;
    }
}
