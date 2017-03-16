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

import com.spidernet.dashboard.entity.CapabilityMap;
import com.spidernet.dashboard.entity.ExamCapability;
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.entity.Trainning;
import com.spidernet.dashboard.service.CapabilityExamService;
import com.spidernet.dashboard.service.CapabilityTrainingService;
import com.spidernet.dashboard.service.ExamService;
import com.spidernet.dashboard.service.PersonalMapService;
import com.spidernet.dashboard.service.TrainningService;
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

    @Resource
    TrainningService trainningService;

    @Resource
    ExamService examService;

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

        String capabilityId = "";

        for (int i=0;i<cBBean.getCapabilityMap().size();i++)
        {
            if (Constants.ONE == cBBean.getCapabilityMap().get(i).getBlockType())
            {
                for(int j=0;j<cBBean.getCapabilityMap().get(i).getProCapabilityL().size();j++)
                {
                    Boolean capabilityExam = false;
                    Boolean capabilityTraining = false;
                    capabilityId = cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).getProCapabilityId();
                    List<Trainning> trainningList = trainningService.fetchAllTrainning(capabilityId, employeeId);
                    List<ExamCapability> examList = examService.fetchAllExam(capabilityId, employeeId);
                    
                    String capabilityTrainingStatus = capabilityTrainingService.capabilityTrainingStatus(capabilityId, employeeId);
                    String capabilityExamStatus = capabilityExamService.capabilityExamStatus(capabilityId, employeeId);
                    
                    cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).setTrainingStatus(capabilityTrainingStatus);
                    cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).setStatus(capabilityExamStatus);
                    
                    if (examList.size() <= Constants.ZERO)
                    {
                        cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).setIsExam(capabilityExam);
                    }
                    else
                    {
                        capabilityExam = true;
                        cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).setIsExam(capabilityExam);
                    }

                    if (trainningList.size() <= Constants.ZERO)
                    {
                        cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).setIsTraining(capabilityTraining);
                    }
                    else
                    {
                        capabilityTraining = true;
                        cBBean.getCapabilityMap().get(i).getProCapabilityL().get(j).setIsTraining(capabilityTraining);
                    }
                }
            }
            
            if (Constants.TWO == cBBean.getCapabilityMap().get(i).getBlockType())
            {
                for(int j=0;j<cBBean.getCapabilityMap().get(i).getcCapabilityL().size();j++)
                {
                    Boolean capabilityExam = false;
                    Boolean capabilityTraining = false;
                    capabilityId = cBBean.getCapabilityMap().get(i).getcCapabilityL().get(j).getCommCapabilityId();
                    List<Trainning> trainningList = trainningService.fetchAllTrainning(capabilityId, employeeId);
                    List<ExamCapability> examList = examService.fetchAllExam(capabilityId, employeeId);
                    
                    if (examList.size() <= Constants.ZERO)
                    {
                        cBBean.getCapabilityMap().get(i).getcCapabilityL().get(j).setIsExam(capabilityExam);
                    }
                    else
                    {
                        capabilityExam = true;
                        cBBean.getCapabilityMap().get(i).getcCapabilityL().get(j).setIsExam(capabilityExam);
                    }
                    
                    if (trainningList.size() <= Constants.ZERO)
                    {
                        cBBean.getCapabilityMap().get(i).getcCapabilityL().get(j).setIsTraining(capabilityTraining);       
                    }
                    else
                    {
                        capabilityTraining = true;
                        cBBean.getCapabilityMap().get(i).getcCapabilityL().get(j).setIsTraining(capabilityTraining);
                    }
                }
            }
        }


        return cBBean;
    }
}
