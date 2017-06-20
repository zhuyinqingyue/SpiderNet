package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.Trainning;
import com.spidernet.dashboard.entity.TrainningPageCondition;

public interface TrainningService
{
    List<Trainning> fetchAllTrainning(String capabilityId, String employeeId);
    boolean addTraining(Trainning trainning);
    List<Trainning> queryTrainingInfo(TrainningPageCondition trainningPageCondition);
    int countTrainingPage(TrainningPageCondition trainningPageCondition);
}
