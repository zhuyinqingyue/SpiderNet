package com.spidernet.dashboard.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spidernet.dashboard.entity.CapabilityMap;
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.service.CapabilityExamService;
import com.spidernet.dashboard.service.CapabilityTrainingService;
import com.spidernet.dashboard.service.PersonalMapService;
import com.spidernet.util.Constants;
import com.spidernet.util.XmlUtil;

@RequestMapping("/capability")
@Controller
public class PersonalMapController
{
    private static Logger logger = LoggerFactory.getLogger(BuController.class);


    @Resource
    PersonalMapService personalMapService;

    @Resource
    CapabilityExamService capabilityExamService;

    @Resource
    CapabilityTrainingService capabilityTrainingService;
    
    @RequestMapping("/viewPersonalMap")
    @ResponseBody
    public CapabilityMap viewPersonalMap(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.debug("---------viewPersonalMap is begin!----------");
        
        String employeeId = request.getParameter("empId");
        
        PersonalMap personalMap = new PersonalMap();
        personalMap = personalMapService.fetchByEmpId(employeeId);
        
        CapabilityMap cBBean = (CapabilityMap) XmlUtil.convertXmlStrToObject(CapabilityMap.class,
                personalMap.getDetail());
        
        Boolean capabilityExam = false;
        Boolean capabilityTraining = false;
        String capabilityId = "";
        
        for (int i=0;i<cBBean.getCapabilityMap().size();i++)
        {
            if (Constants.ONE == cBBean.getCapabilityMap().get(i).getBlockType())
            {
                for(int j=0;j<cBBean.getCapabilityMap().get(i).getProCapabilityL().size();j++)
                {
                    capabilityId = cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).getProCapabilityId();
                    capabilityExam = capabilityExamService.accountCapabilityExam(capabilityId);
                    capabilityTraining = capabilityTrainingService.accountCapabilityTraining(capabilityId);
                    if (capabilityExam)
                    {
                        cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).setIsExam(capabilityExam);
                    }
                    if (capabilityTraining)
                    {
                        cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).setIsTraining(capabilityTraining);       
                    }
                }
            }
        }
        
        
        return cBBean;
    }
}
