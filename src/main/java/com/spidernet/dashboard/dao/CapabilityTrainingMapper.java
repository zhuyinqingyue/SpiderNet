package com.spidernet.dashboard.dao;

import org.apache.ibatis.annotations.Param;

import com.spidernet.dashboard.entity.CapabilityTraining;

public interface CapabilityTrainingMapper
{
    int accountCapabilityTraining(@Param("capabilityId")String capabilityId);
    String fetchCapabilityIdByTrainningId(String trainningId);
	String capabilityTrainingStatus(@Param("capabilityId")String capabilityId,@Param("employeeId")String employeeId);
	int addCapabilityTrainning(CapabilityTraining capabilityTraining);
}
