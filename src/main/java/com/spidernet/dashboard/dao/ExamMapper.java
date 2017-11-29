package com.spidernet.dashboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spidernet.dashboard.entity.Exam;
import com.spidernet.dashboard.entity.ExamCapability;

public interface ExamMapper
{
    List<ExamCapability> fetchAllExam(@Param("capabilityId")String capabilityId, @Param("employeeId")String employeeId, @Param("projectId")String projectId, @Param("buId")String buId);
    //List<ExamCapability> fetchAllExam(Map<String, Object> params);
    List<Exam> queryExamByName(String examName);
    int addExam(Exam exam);
    Exam queryExamById(String examId);
    List<Exam> queryExamName();
}
