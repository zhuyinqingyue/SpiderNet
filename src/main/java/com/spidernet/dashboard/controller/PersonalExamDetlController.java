package com.spidernet.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spidernet.dashboard.entity.CCapability;
import com.spidernet.dashboard.entity.CapabilityMap;
import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.entity.PersonalExam;
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.entity.ProCapability;
import com.spidernet.dashboard.service.CCapabilityService;
import com.spidernet.dashboard.service.CapabilityExamService;
import com.spidernet.dashboard.service.PersonalExamService;
import com.spidernet.dashboard.service.PersonalMapService;
import com.spidernet.dashboard.service.ProCapabilityService;
import com.spidernet.util.Constants;
import com.spidernet.util.XmlUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/exam")
public class PersonalExamDetlController
{

    @Resource
    PersonalExamService personalExamService;

    @Resource
    CapabilityExamService capabilityExamService;

    @Resource
    CCapabilityService ccapabilityService;

    @Resource
    ProCapabilityService proCapabilityService;

    @Resource
    PersonalMapService personalMapService;

    private static Logger logger = LoggerFactory
            .getLogger(PersonalTrainningDetlController.class);

    @RequestMapping("/addPersonalExamDetl")
    @ResponseBody
    public Boolean addPersonalExamDetl(final HttpServletRequest request,
            final HttpServletResponse response)
    {

        logger.debug("Add the personal exam detail begin");

        ProCapability proCapability = null;
        CCapability commonCapability = null;
        PersonalMap personalMap = null;
        String capabilityId = null;
        Boolean addResultFlag = false;

        String employeeId = ((Employee) request.getSession()
                .getAttribute("employee")).getEmployeeId();
        String selectedExam = request.getParameter("selectedExamArray");

        JSONArray selectedExamArray = JSONArray.fromObject(selectedExam);

        List<PersonalExam> personalExamList = new ArrayList<PersonalExam>();

        PersonalExam personalExam = null;

        personalMap = personalMapService.fetchByEmpId(employeeId);

        String personalDetail = personalMap.getDetail();

        CapabilityMap capabilityMap = (CapabilityMap) XmlUtil
                .convertXmlStrToObject(CapabilityMap.class,
                        personalMap.getDetail());


        for (int i = 0; i < selectedExamArray.size(); i++)
        {
            personalExam = new PersonalExam();

            personalExam.setEmployeeId(employeeId);
            personalExam.setExamId(
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("examId").toString());
            personalExam.setPersonalExam(
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("examName").toString());
            personalExam.setRegisterTime(
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("startTime").toString());
            personalExam.setUpdateTime(
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("endTime").toString());
            personalExam.setStatus(
                    Constants.EXAM_STATUS_REGISTED);

            if(personalExamService.checkPersonalExamExists(personalExam)){
                return false;
            }

            personalExamList.add(personalExam);
        }

        if (personalExamList.size() > 0)
        {
            capabilityId = capabilityExamService
                    .fetchCapabilityIdByExamId(
                            personalExamList.get(0).getExamId());
        }

        commonCapability = ccapabilityService
                .fetchCommonCapabilty(capabilityId);

        proCapability = proCapabilityService
                .fetchProCapabilityByCapabilityId(capabilityId);

        for (int i = 0; i < capabilityMap.getCapabilityMap().size(); i++)
        {
            if (Constants.ONE == capabilityMap.getCapabilityMap().get(i)
                    .getBlockType())
            {
                for (int j = 0; j < capabilityMap.getCapabilityMap().get(i)
                        .getProCapabilityL().size(); j++)
                {
                    if (proCapability.getProCapabilityId()
                            .equals(capabilityMap.getCapabilityMap().get(i)
                                    .getProCapabilityL().get(j)
                                    .getProCapabilityId()))
                    {
                        capabilityMap.getCapabilityMap().get(i)
                                .getProCapabilityL().get(j).setStatus(
                                        Constants.EXAM_STATUS_REGISTED);
                    }
                }
            }
            else
            {
                for (int j = 0; j < capabilityMap.getCapabilityMap().get(i)
                        .getcCapabilityL().size(); j++)
                {
                    if (commonCapability.getCommCapabilityId()
                            .equals(capabilityMap.getCapabilityMap().get(i)
                                    .getcCapabilityL().get(j)
                                    .getCommCapabilityId()))
                    {
                        capabilityMap.getCapabilityMap().get(i)
                                .getcCapabilityL().get(j).setStatus(
                                        Constants.EXAM_STATUS_REGISTED);
                    }
                }

            }
        }

        personalDetail = XmlUtil.convertToXml(capabilityMap);

        personalMap.setDetail(personalDetail);
        personalMapService.updatePersonalMap(personalMap);

        addResultFlag = personalExamService.addPersonalExam(personalExamList);

        return addResultFlag;

    }

}
