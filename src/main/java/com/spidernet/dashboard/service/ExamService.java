package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.ExamCapability;

public interface ExamService
{
    List<ExamCapability> fetchAllExam(String capabilityId, String employeeId);
}
