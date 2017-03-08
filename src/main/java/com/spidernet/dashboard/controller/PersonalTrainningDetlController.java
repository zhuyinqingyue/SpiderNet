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

import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.entity.PersonalTrainning;
import com.spidernet.dashboard.service.PersonalTrainningService;
import com.spidernet.util.Utils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/trainning")
public class PersonalTrainningDetlController
{
    @Resource
    PersonalTrainningService personalTrainningService;

    private static Logger logger = LoggerFactory
            .getLogger(PersonalTrainningDetlController.class);

    @RequestMapping("/addPersonalTrainningDetl")
    @ResponseBody
    public Boolean addPersonalTrainningDetl(final HttpServletRequest request,
            final HttpServletResponse response) {

        logger.debug("Add the personal trainning detail begin");
        Boolean addResultFlag = false;

        String employeeId = ((Employee)request.getSession().getAttribute("employee")).getEmployeeId();
        String selectedTrainning = request.getParameter("selectedTrainningArray");

        JSONArray selectedTrainningArray = JSONArray.fromObject(selectedTrainning);

        List<PersonalTrainning> personalTrainningList = new ArrayList<PersonalTrainning>();

        PersonalTrainning personalTrainning = null;

        if (selectedTrainningArray.size() > 0) {
            for (int i = 0; i < selectedTrainningArray.size(); i++) {
                personalTrainning = new PersonalTrainning();

                String uuid = Utils.getUUID();
                personalTrainning.setPersonalTrainningId(uuid);
                personalTrainning.setEmployeeId(employeeId);
                personalTrainning.setTrainningId(new JSONObject(selectedTrainningArray.get(i).toString()).get("trainningId").toString());
                personalTrainning.setStatus(new JSONObject(selectedTrainningArray.get(i).toString()).get("status").toString());
                personalTrainningList.add(personalTrainning);
            }


            addResultFlag = personalTrainningService.addPersonalTrainning(personalTrainningList);

            return addResultFlag;

        }
        else {
            return false;
        }
    }

}
