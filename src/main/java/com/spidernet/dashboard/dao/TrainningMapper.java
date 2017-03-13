package com.spidernet.dashboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spidernet.dashboard.entity.Trainning;

public interface TrainningMapper
{
    List<Trainning> fetchAllTrainning(@Param("capabilityId")String capabilityId, @Param("employeeId")String employeeId);
}
