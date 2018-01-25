package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.PersonalTrainning;

public interface PersonalTrainningMapper
{
    int addPersonalTrainning(List<PersonalTrainning> personalTrainningList);
    int checkPersonalTrainningExists(PersonalTrainning personalTrainning);
    int updateEmpTrainingInfo(String ername, String trname);
	int deleteEmpTrainingInfo(String ername, String trname);
}
