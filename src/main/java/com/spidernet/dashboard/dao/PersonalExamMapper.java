package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.PersonalExam;

public interface PersonalExamMapper
{
    int addPersonalExam(List<PersonalExam> personalExamList);
    int checkPersonalExamExists(PersonalExam personalExam);
}
