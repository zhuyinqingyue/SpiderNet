package com.spidernet.dashboard.dao;

import org.apache.ibatis.annotations.Param;

public interface CapabilityTrainingMapper
{
    int accountCapabilityTraining(@Param("capabilityId")String capabilityId);
}
