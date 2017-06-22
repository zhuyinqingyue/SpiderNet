package com.spidernet.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.ExamMapper;
import com.spidernet.dashboard.entity.Exam;
import com.spidernet.dashboard.entity.ExamCapability;
import com.spidernet.dashboard.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService
{
    @Resource
    private ExamMapper examMapper;

    @Override
    public List<ExamCapability> fetchAllExam(String capabilityId, String employeeId)
    {
        List<ExamCapability> examList = new ArrayList<ExamCapability>();
        examList = examMapper.fetchAllExam(capabilityId, employeeId);

        return examList;
    }

    @Override
    public List<Exam> queryExamName()
    {
        List<Exam> examNameList = examMapper.queryExamName();
        return examNameList;
    }

    @Override
    public List<Exam> queryExamDate(String examId)
    {
        List<Exam> examDateList = examMapper.queryExamDate(examId);
        return examDateList;
    }

    @Override
    public Boolean addExam(Exam exam)
    {
        if(examMapper.addExam(exam)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Exam queryExamById(String examId)
    {
        Exam exam = examMapper.queryExamById(examId);
        return exam;
    }
}
