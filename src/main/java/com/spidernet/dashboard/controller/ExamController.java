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

import com.spidernet.dashboard.entity.ExamCapability;
import com.spidernet.dashboard.service.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController
{
    @Resource
    ExamService examService;

    private static Logger logger = LoggerFactory
            .getLogger(ExamController.class);

    @RequestMapping("/personalExamList")
    @ResponseBody
    public Object examList(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String capabilityId = request.getParameter("capabilityId");

        List<ExamCapability> examList = examService.fetchAllExam(capabilityId);

        return examList;
    }

}
