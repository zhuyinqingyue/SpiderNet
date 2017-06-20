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

import com.spidernet.dashboard.entity.ProCapability;
import com.spidernet.dashboard.service.ProCapabilityService;
import com.spidernet.util.Utils;

@Controller
@RequestMapping("/proCapability")
public class ProCapabilityController
{
    @Resource
    ProCapabilityService proCapabilityService;
    
    private static Logger logger = LoggerFactory.getLogger(ProCapabilityController.class);
    
    @RequestMapping("/queryProCapability")
    @ResponseBody
    public Object queryProCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        List<ProCapability> proCapabilityList = proCapabilityService.queryProCapability();

        return proCapabilityList;
    }
    
    @RequestMapping("/addProCapability")
    @ResponseBody
    public boolean addProCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String proCapabilityId = Utils.getUUID();
        String blockId = request.getParameter("pBlock2");
        String buId = request.getParameter("pBu2");
        String projectId = request.getParameter("pProject2");
        String empLevelId = request.getParameter("pLevel2");
        String name = request.getParameter("pCapabilityName2");
        String description = request.getParameter("pDescribe");
        int sort = proCapabilityService.getSortByBlockId(blockId);
        String url = request.getParameter("pCapabilityURL");
        String empTypeId = request.getParameter("pType2");
        
        ProCapability proCapability = new ProCapability();
        
        proCapability.setProCapabilityId(proCapabilityId);
        proCapability.setBlockId(blockId);
        proCapability.setBuId(buId);
        proCapability.setProjectId(projectId);
        proCapability.setEmpLevelId(empLevelId);
        proCapability.setName(name);
        proCapability.setDescription(description);
        proCapability.setSort(sort);
        proCapability.setUrl(url);
        proCapability.setEmpTypeId(empTypeId);
        
        boolean resultFlag = proCapabilityService.addProCapability(proCapability);
        
        return resultFlag;
    }
}
