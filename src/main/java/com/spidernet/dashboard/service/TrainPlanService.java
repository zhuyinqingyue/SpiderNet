package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.TrainPlan;
import com.spidernet.dashboard.entity.TrainPlanContainId;

public interface TrainPlanService {

	boolean addTrainPlan(TrainPlan TrainPlan);
	boolean updateTrainPlanByParentTrainName(TrainPlan TrainPlan);
	boolean deleteByAllocationPlanId(int allocationPlanId);
	List <TrainPlanContainId> queryTrainPlanByTrainCourseId(String TrainCourseId);
	TrainPlan queryTrainPlanByAllocationPlanId(String allocationPlanId);
}
