package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.ProCapability;

public interface ProCapabilityService
{
    List<ProCapability> viewProCapability(String blockId, String buId,
            String projectId, String empLevelId, String empTypeId);

    ProCapability fetchProCapabilityByCapabilityId(String capabilityId);

    int updateProCapability(ProCapability proCapability) ;
    
    List<ProCapability> queryProCapability();
    
    int getSortByBlockId(String blockId);
    
    boolean addProCapability(ProCapability proCapability);
}
