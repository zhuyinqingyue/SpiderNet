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
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.entity.PersonalTrainning;
import com.spidernet.dashboard.entity.ProCapability;
import com.spidernet.dashboard.service.CCapabilityService;
import com.spidernet.dashboard.service.CapabilityTrainingService;
import com.spidernet.dashboard.service.PersonalMapService;
import com.spidernet.dashboard.service.PersonalTrainningService;
import com.spidernet.dashboard.service.ProCapabilityService;
import com.spidernet.util.Constants;
import com.spidernet.util.XmlUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/trainning")
public class PersonalTrainningDetlController
{
    @Resource
    PersonalTrainningService personalTrainningService;

    @Resource
    CapabilityTrainingService capabilityTrainingService;

    @Resource
    CCapabilityService ccapabilityService;

    @Resource
    ProCapabilityService proCapabilityService;

    @Resource
    PersonalMapService personalMapService;

    private static Logger logger = LoggerFactory
            .getLogger(PersonalTrainningDetlController.class);

    @RequestMapping("/addPersonalTrainningDetl")
    @ResponseBody
    public Boolean addPersonalTrainningDetl(final HttpServletRequest request,
            final HttpServletResponse response)
    {

        logger.debug("Add the personal trainning detail begin");
        ProCapability proCapability = null;
        CCapability commonCapability = null;
        PersonalMap personalMap = null;
        Boolean addResultFlag = false;
        String capabilityId = null;

        String employeeId = ((Employee) request.getSession()
                .getAttribute("employee")).getEmployeeId();
        String selectedTrainning = request
                .getParameter("selectedTrainningArray");

        JSONArray selectedTrainningArray = JSONArray
                .fromObject(selectedTrainning);

        List<PersonalTrainning> personalTrainningList = new ArrayList<PersonalTrainning>();

        PersonalTrainning personalTrainning = null;
        personalMap = personalMapService.fetchByEmpId(employeeId);
        String personalDetail = personalMap.getDetail();
        CapabilityMap capabilityMap = (CapabilityMap) XmlUtil
                .convertXmlStrToObject(CapabilityMap.class,
                        personalMap.getDetail());

        for (int i = 0; i < selectedTrainningArray.size(); i++)
        {
            personalTrainning = new PersonalTrainning();

            personalTrainning.setEmployeeId(employeeId);
            personalTrainning.setTrainningId(
                    new JSONObject(selectedTrainningArray.get(i).toString())
                            .get("trainningId").toString());
            personalTrainning.setStatus(Constants.TRAINNING_STATUS_REGISTED);

            if (personalTrainningService
                    .checkPersonalTrainningExists(personalTrainning))
            {
                return false;
            }
            personalTrainningList.add(personalTrainning);
        }

        if (personalTrainningList.size() > 0)
        {
            capabilityId = capabilityTrainingService
                    .fetchCapabilityIdByTrainningId(
                            personalTrainningList.get(0).getTrainningId());
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
                                .getProCapabilityL().get(j).setTrainingStatus(
                                        Constants.TRAINNING_STATUS_REGISTED);
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
                                .getcCapabilityL().get(j).setTrainingStatus(
                                        Constants.TRAINNING_STATUS_REGISTED);
                    }
                }

            }
        }

        personalDetail = XmlUtil.convertToXml(capabilityMap);

        personalMap.setDetail(personalDetail);
        personalMapService.updatePersonalMap(personalMap);

        addResultFlag = personalTrainningService
                .addPersonalTrainning(personalTrainningList);

        return addResultFlag;

    }

}
