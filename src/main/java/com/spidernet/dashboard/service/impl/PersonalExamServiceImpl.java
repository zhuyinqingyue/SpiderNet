package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.PersonalExamMapper;
import com.spidernet.dashboard.entity.PersonalExam;
import com.spidernet.dashboard.service.PersonalExamService;

@Service
public class PersonalExamServiceImpl implements PersonalExamService
{

    @Resource
    PersonalExamMapper personalExamMapper;
    
    @Override
    public Boolean addPersonalExam(List<PersonalExam> personalExamList)
    {
        if(personalExamMapper.addPersonalExam(personalExamList) > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean checkPersonalExamExists(PersonalExam personalExam)
    {
        if(personalExamMapper.checkPersonalExamExists(personalExam) > 0){
            return true;
        }else{
            return false;
        }
    }

}
