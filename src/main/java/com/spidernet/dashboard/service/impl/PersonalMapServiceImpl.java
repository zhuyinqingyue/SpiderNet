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
}
