package com.spidernet.dashboard.service;

public interface CapabilityTrainingService
{
    Boolean accountCapabilityTraining(String capabilityId);
    
    String capabilityTrainingStatus(String capabilityId,String employeeId);
}
