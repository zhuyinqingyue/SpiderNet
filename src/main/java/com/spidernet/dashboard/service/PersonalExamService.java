package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.PersonalExam;

public interface PersonalExamService
{
    Boolean addPersonalExam(List<PersonalExam> personalExamList);
    Boolean checkPersonalExamExists(PersonalExam personalExam);
    boolean updataScore(PersonalExam personalExam);
    boolean addPersonalExam0(PersonalExam personalExam);
}
