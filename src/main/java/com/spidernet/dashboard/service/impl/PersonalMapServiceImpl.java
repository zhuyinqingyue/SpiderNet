package com.spidernet.dashboard.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.PersonalMapMapper;
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.service.PersonalMapService;

@Service
public class PersonalMapServiceImpl implements PersonalMapService
{

    @Resource
    private PersonalMapMapper personalMapMapper;

    @Override
    public Boolean addPersonalMap(PersonalMap personalMap)
    {
        if (personalMapMapper.addPersonalMap(personalMap) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public PersonalMap fetchByEmpId(String employeeId)
    {
        PersonalMap personalMapDb = personalMapMapper.fetchByEmpId(employeeId);
        return personalMapDb;
    }

    @Override
    public Boolean updatePersonalMap(PersonalMap personalMap)
    {
        if (personalMapMapper.updatePersonalMap(personalMap) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public String findPersonalMapIdByEmpId(String employeeId)
    {
        // TODO Auto-generated method stub
        String personalMapId = personalMapMapper.findPersonalMapIdByEmpId(employeeId);
        return personalMapId;
    }
}
