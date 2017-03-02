package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.CapabilityBMapper;
import com.spidernet.dashboard.entity.CapabilityB;
import com.spidernet.dashboard.service.CapabilityBService;

@Service
public class CapabilityBServiceImpl implements CapabilityBService
{
    @Resource
    private CapabilityBMapper capabilityBMapper;

    @Override
    public List<CapabilityB> viewCapabilityB()
    {
        List<CapabilityB> capabilityBDb = capabilityBMapper.viewCapabilityB();
        return capabilityBDb;
    }
}
