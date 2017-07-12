package com.spidernet.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.TrainningMapper;
import com.spidernet.dashboard.entity.Trainning;
import com.spidernet.dashboard.entity.TrainningPageCondition;
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

    @Override
    public boolean addTraining(Trainning trainning)
    {
        if(trainningMapper.addTraining(trainning)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<Trainning> queryTrainingInfo(
            TrainningPageCondition trainningPageCondition)
    {
        List<Trainning> trainningList = trainningMapper.queryTrainingInfo(trainningPageCondition);
        return trainningList;
    }

    @Override
    public int countTrainingPage(TrainningPageCondition trainningPageCondition)
    {
        return trainningMapper.countTrainingPage(trainningPageCondition)/10 + 1;
    }

    @Override
    public List<Trainning> queryTrainingByName(String trainingName)
    {
        List<Trainning> trainingList = trainningMapper.queryTrainingByName(trainingName);
        return trainingList;
    }

    @Override
    public List<Trainning> queryTrainingName()
    {
        List<Trainning> trainingList = trainningMapper.queryTrainingName();

        return trainingList;
    }

    @Override
    public Trainning queryTrainingById(String trainingId)
    {
        Trainning trainning = trainningMapper.queryTrainingById(trainingId);
        return trainning;
    }

}
