package com.spidernet.dashboard.service;

public interface CapabilityTrainingService
{
    Boolean accountCapabilityTraining(String capabilityId);
    String fetchCapabilityIdByTrainningId(String trainningId);
    String capabilityTrainingStatus(String capabilityId,String employeeId);
}
