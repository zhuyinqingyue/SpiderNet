package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.PersonalTrainning;

public interface PersonalTrainningService
{
    Boolean addPersonalTrainning(List<PersonalTrainning> personalTrainning);
    Boolean checkPersonalTrainningExists(PersonalTrainning personalTrainning);
    int deleteEmpTrainingInfo(String ername, String trname);

	int updateEmpTrainingInfo(String ername, String trname);
}
