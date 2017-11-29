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
import com.spidernet.dashboard.entity.CapabilityMap;
import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.entity.ExamCapability;
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.entity.Trainning;
import com.spidernet.dashboard.service.CCapabilityService;
import com.spidernet.dashboard.service.CapabilityExamService;
import com.spidernet.dashboard.service.CapabilityTrainingService;
import com.spidernet.dashboard.service.EmployeeService;
import com.spidernet.dashboard.service.ExamService;
import com.spidernet.dashboard.service.PersonalMapService;
import com.spidernet.dashboard.service.TrainningService;
import com.spidernet.util.Constants;
import com.spidernet.util.XmlUtil;

import net.sf.json.JSONObject;

@RequestMapping("/capability")
@Controller
public class PersonalMapController
{
    private static Logger logger = LoggerFactory.getLogger(BuController.class);


    @Resource
    private PersonalMapService personalMapService;

    @Resource
    private CapabilityExamService capabilityExamService;

    @Resource
    private CapabilityTrainingService capabilityTrainingService;

    @Resource
    private TrainningService trainningService;

    @Resource
    private ExamService examService;
    
    @Resource
    private CCapabilityService cCapabilityService;
    
    @Resource
    private EmployeeService employeeService;
    

    @RequestMapping("/viewPersonalMap")
    @ResponseBody
    public CapabilityMap viewPersonalMap(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.debug("---------viewPersonalMap is begin!----------");

        String employeeId = request.getParameter("empId");

        PersonalMap personalMap = new PersonalMap();
        personalMap = personalMapService.fetchByEmpId(employeeId);
        if(null==personalMap){
            return null;
        }
        CapabilityMap cBBean = (CapabilityMap) XmlUtil.convertXmlStrToObject(CapabilityMap.class,
                personalMap.getDetail());

        String capabilityId = "";
        
        String projectId = ((Employee)request.getSession().getAttribute("employee")).getProjectId();
        String buId = ((Employee)request.getSession().getAttribute("employee")).getBuId();

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
                    List<ExamCapability> examList = examService.fetchAllExam(capabilityId, employeeId,projectId,buId);
                    
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
                    List<ExamCapability> examList = examService.fetchAllExam(capabilityId, employeeId,projectId,buId);
                    
                    String capabilityTrainingStatus = capabilityTrainingService.capabilityTrainingStatus(capabilityId, employeeId);
                    String capabilityExamStatus = capabilityExamService.capabilityExamStatus(capabilityId, employeeId);
                    
                    cBBean.getCapabilityMap().get(i).getcCapabilityL().get(j).setTrainingStatus(capabilityTrainingStatus);
                    cBBean.getCapabilityMap().get(i).getcCapabilityL().get(j).setStatus(capabilityExamStatus);
                    
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
    
    
    
    @RequestMapping("/updPersonalMapList")
    @ResponseBody
    public CapabilityMap updPersonalMapList(final HttpServletRequest request,
            final HttpServletResponse response, final String[] empArray,
            final String[] capabilityArray)
    {

        String employeeId = "";

        String capabilityId0 = "";

        String strC = "";

        String personalMapStr = "";

        CCapability cCpability0 = null;

        CCapability cCpability = null;

        CapabilityMap cBBean = null;

        PersonalMap personalMap = new PersonalMap();

        for (int a = 0; a < empArray.length; a++)
        {

            employeeId = employeeService.fetchByErNumber(empArray[a]).getEmployeeId();
            
            personalMap = personalMapService.fetchByEmpId(employeeId);
            
            cBBean = (CapabilityMap) XmlUtil.convertXmlStrToObject(CapabilityMap.class, personalMap.getDetail());

            for (int b = 0; b < capabilityArray.length; b++)
            {

                capabilityId0 = capabilityArray[b];

                cCpability0 = cCapabilityService.fetchCommonCapabilty(capabilityId0);

                strC = "{'commCapabilityId':'"
                        + cCpability0.getCommCapabilityId() + "', 'blockId':'"
                        + cCpability0.getBlockId() + "', 'name':'"
                        + cCpability0.getName() + "','url':'"
                        + cCpability0.getUrl()
                        + "','status':'','trainingStatus':''}";
                JSONObject capabilityMapJ = JSONObject.fromObject(strC);
                cCpability = (CCapability) JSONObject.toBean(capabilityMapJ,CCapability.class);

                for (int i = 0; i < cBBean.getCapabilityMap().size(); i++)
                {
                    if (cCpability0.getBlockId().equals(cBBean.getCapabilityMap().get(i).getBlockId()) && Constants.TWO == cBBean.getCapabilityMap().get(i).getBlockType())
                    {
                            if (cBBean.getCapabilityMap().get(i).getcCapabilityL().isEmpty())
                            {
                                cBBean.getCapabilityMap().get(i).getcCapabilityL().add(cCpability);
                                break;
                            }
                            if (!cBBean.getCapabilityMap().get(i).getcCapabilityL().contains(cCpability))
                            {
                                cBBean.getCapabilityMap().get(i).getcCapabilityL().add(cCpability);
                            }
                    }
                }

            }

            personalMapStr = XmlUtil.convertToXml(cBBean);

            personalMap.setDetail(personalMapStr);

            personalMapService.updatePersonalMap(personalMap);

        }

        return null;
    }
}
