package com.spidernet.dashboard.service;

public interface CapabilityExamService
{
    Boolean accountCapabilityExam(String capabilityId);
    String capabilityExamStatus(String capabilityId,String employeeId);
}
