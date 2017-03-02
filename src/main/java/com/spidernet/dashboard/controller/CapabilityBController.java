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
import com.spidernet.dashboard.entity.CapabilityB;
import com.spidernet.dashboard.entity.CapabilityMap;
import com.spidernet.dashboard.entity.ProCapability;
import com.spidernet.dashboard.service.CCapabilityService;
import com.spidernet.dashboard.service.CapabilityBService;
import com.spidernet.dashboard.service.ProCapabilityService;
import com.spidernet.util.Constants;

@Controller
public class CapabilityBController
{
    private static Logger logger = LoggerFactory.getLogger(BuController.class);

    @Resource
    CapabilityBService capabilityBService;

    @Resource
    CCapabilityService cCapabilityService;

    @Resource
    ProCapabilityService proCapabilityService;

    @RequestMapping("/viewCCapability")
    @ResponseBody
    public CapabilityMap viewCCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.debug("---------viewCapabilityB is begin!----------");

        CapabilityMap capabilityMap = new CapabilityMap();
        String buId = request.getParameter("buId");
        String projectId = request.getParameter("projectId");
        String empLevelId = request.getParameter("empLevelId");
        String empTypeId = request.getParameter("empTypeId");
        List<CCapability> cCapabilityL = null;
        List<ProCapability> proCapabilityL = null;
        List<CapabilityB> capabilityBL = capabilityBService.viewCapabilityB();
        for (int i = 0; i < capabilityBL.size(); i++)
        {
            CapabilityB block = capabilityBL.get(i);
            if (Constants.ONE == capabilityBL.get(i).getBlockType())
            {
                proCapabilityL = proCapabilityService.viewProCapability(
                        capabilityBL.get(i).getBlockId(), buId, projectId,
                        empLevelId, empTypeId);
               
                block.setProCapabilityL(proCapabilityL);
            }

            if (Constants.TWO == capabilityBL.get(i).getBlockType())
            {
                cCapabilityL = cCapabilityService.viewCCapability(
                        capabilityBL.get(i).getBlockId(), buId);
                block.setcCapabilityL(cCapabilityL);
            }
            capabilityMap.getCapabilityMap().add(block);
        }
        
        return capabilityMap;
    }

    // @RequestMapping("/viewCCapability")
    // @ResponseBody
    // public CCapability viewCCapability(final HttpServletRequest request,
    // final HttpServletResponse response, String json)
    // {
    // logger.debug("---------viewCapabilityB is begin!----------");
    // CCapability bean = new CCapability();
    ////
    //// CapabilityB bean = new CapabilityB();
    //// bean = capabilityBService.viewCapabilityB();
    // // 将 json转成 json数组
    //
    // JSONArray array = JSONArray.fromObject(json);
    //
    // // 将数组的 每个元素 转成 json对象
    //
    // for (Object obj : array)
    // {
    //
    // JSONObject jsonObject = JSONObject.fromObject(obj);
    //
    // // 调用 json对象的toBean方法将数据 反射到实体bean中
    //
    // bean = (CCapability) JSONObject.toBean(jsonObject,
    // CCapability.class);
    //
    // }
    //
    // return bean;
    // }
}
