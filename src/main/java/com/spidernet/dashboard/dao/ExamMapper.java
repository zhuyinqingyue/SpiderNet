package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.ExamCapability;

public interface ExamMapper
{
    List<ExamCapability> fetchAllExam(String capabilityId);
}
