package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.Trainning;

public interface TrainningMapper
{
    List<Trainning> fetchAllTrainning(String capabilityId);
}
