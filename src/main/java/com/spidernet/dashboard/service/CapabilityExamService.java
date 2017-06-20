package com.spidernet.dashboard.service;

import com.spidernet.dashboard.entity.CapabilityExam;

public interface CapabilityExamService
{
    Boolean accountCapabilityExam(String capabilityId);
    String fetchCapabilityIdByExamId(String examId);
    String capabilityExamStatus(String capabilityId,String employeeId);
    Boolean addCapabilityExam(CapabilityExam capabilityExam);
}
