package com.spidernet.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.TrainningMapper;
import com.spidernet.dashboard.entity.Trainning;
import com.spidernet.dashboard.service.TrainningService;

@Service
public class TrainningServiceImpl implements TrainningService
{

    @Resource
    private TrainningMapper trainningMapper;

    @Override
    public List<Trainning> fetchAllTrainning(String capabilityId, String employeeId)
    {
        // TODO Auto-generated method stub
        List<Trainning> trainningList = new ArrayList<Trainning>();

        trainningList = trainningMapper.fetchAllTrainning(capabilityId, employeeId);
        return trainningList;
    }

}
