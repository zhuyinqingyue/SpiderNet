package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.Exam;
import com.spidernet.dashboard.entity.ExamCapability;

public interface ExamService
{
    List<ExamCapability> fetchAllExam(String capabilityId, String employeeId);
    
    List<Exam> queryExamName();
    List<Exam> queryExamDate(String examId);
    Boolean addExam(Exam exam); 
    Exam queryExamById(String examId);
}
