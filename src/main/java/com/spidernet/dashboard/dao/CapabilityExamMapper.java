package com.spidernet.dashboard.dao;

import org.apache.ibatis.annotations.Param;

public interface CapabilityExamMapper
{
    int accountCapabilityExam(@Param("capabilityId")String capabilityId);
    String capabilityExamStatus(@Param("capabilityId")String capabilityId,@Param("employeeId")String employeeId);
}
