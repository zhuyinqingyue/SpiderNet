package com.spidernet.dashboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spidernet.dashboard.entity.Exam;
import com.spidernet.dashboard.entity.ExamCapability;

public interface ExamMapper
{
    List<ExamCapability> fetchAllExam(@Param("capabilityId")String capabilityId, @Param("employeeId")String employeeId);
    List<Exam> queryExamName();
    List<Exam> queryExamDate(String examId);
    int addExam(Exam exam);
    Exam queryExamById(String examId);
}
