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
import com.spidernet.dashboard.entity.PersonalExam;
import com.spidernet.dashboard.service.PersonalExamService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/exam")
public class PersonalExamDetlController
{

    @Resource
    PersonalExamService personalExamService;

    private static Logger logger = LoggerFactory
            .getLogger(PersonalTrainningDetlController.class);

    @RequestMapping("/addPersonalExamDetl")
    @ResponseBody
    public Boolean addPersonalExamDetl(final HttpServletRequest request,
            final HttpServletResponse response)
    {

        logger.debug("Add the personal exam detail begin");
        Boolean addResultFlag = false;

        String employeeId = ((Employee) request.getSession()
                .getAttribute("employee")).getEmployeeId();
        String selectedExam = request.getParameter("selectedExamArray");

        JSONArray selectedExamArray = JSONArray.fromObject(selectedExam);

        List<PersonalExam> personalExamList = new ArrayList<PersonalExam>();

        PersonalExam personalExam = null;

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
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("status").toString());
            
            if(personalExamService.checkPersonalExamExists(personalExam)){
                return false;
            }

            personalExamList.add(personalExam);
        }

        addResultFlag = personalExamService.addPersonalExam(personalExamList);

        return addResultFlag;

    }

}
