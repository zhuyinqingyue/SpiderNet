package com.spidernet.dashboard.dao;

import org.apache.ibatis.annotations.Param;

import com.spidernet.dashboard.entity.CapabilityExam;

public interface CapabilityExamMapper
{
    int accountCapabilityExam(@Param("capabilityId")String capabilityId);
    String fetchCapabilityIdByExamId(String examId);
	String capabilityExamStatus(@Param("capabilityId")String capabilityId,@Param("employeeId")String employeeId);
	int addCapabilityExam(CapabilityExam capabilityExam);
}
