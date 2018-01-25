package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.TrainPlan;

public interface TrainPlanMapper {

	int addTrainPlan(TrainPlan TrainPlan);
	int  updateTrainPlanByParentTrainName(TrainPlan TrainPlan);
	int deleteByAllocationPlanId(int allocationPlanId);
	List <TrainPlan> queryTrainPlanByTrainCourseId(String TrainCourseId);
	TrainPlan queryTrainPlanByAllocationPlanId(String allocationPlanId);
	String queryParentName(String parentId);
	String queryChildName(String childId);
}
