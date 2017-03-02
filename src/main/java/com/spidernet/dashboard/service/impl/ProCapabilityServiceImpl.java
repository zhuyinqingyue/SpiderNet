package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.ProCapabilityMapper;
import com.spidernet.dashboard.entity.ProCapability;
import com.spidernet.dashboard.service.ProCapabilityService;

@Service
public class ProCapabilityServiceImpl implements ProCapabilityService
{

    @Resource
    private ProCapabilityMapper proCapabilityMapper;

    @Override
    public List<ProCapability> viewProCapability(String blockId, String buId,
            String projectId, String empLevelId, String empTypeId)
    {
        List<ProCapability> proCapabilityDb = proCapabilityMapper
                .viewProCapability(blockId, buId, projectId, empLevelId,
                        empTypeId);
        return proCapabilityDb;
    }
}
