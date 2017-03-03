package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.Trainning;

public interface TrainningService
{
    List<Trainning> fetchAllTrainning(String capabilityId);
}
