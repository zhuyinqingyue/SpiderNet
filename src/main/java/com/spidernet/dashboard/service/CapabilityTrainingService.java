package com.spidernet.dashboard.service;

import com.spidernet.dashboard.entity.CapabilityTraining;

public interface CapabilityTrainingService
{
    Boolean accountCapabilityTraining(String capabilityId);
    String fetchCapabilityIdByTrainningId(String trainningId);
    String capabilityTrainingStatus(String capabilityId,String employeeId);
    boolean addCapabilityTrainning(CapabilityTraining capabilityTraining);
}
