package com.spidernet.dashboard.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.CapabilityTrainingMapper;
import com.spidernet.dashboard.service.CapabilityTrainingService;
/**
 * 
 * @author Hurricane
 *
 */
@Service
public class CapabilityTrainingServiceImpl implements CapabilityTrainingService
{

    @Resource
    private CapabilityTrainingMapper capabilityTrainingMapper;
    
    @Override
    public Boolean accountCapabilityTraining(String capabilityId)
    {
        if (capabilityTrainingMapper.accountCapabilityTraining(capabilityId) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
