package com.spidernet.dashboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spidernet.dashboard.entity.ProCapability;

public interface ProCapabilityMapper
{
    List<ProCapability> viewProCapability(@Param("blockId")String blockId, @Param("buId")String buId,
            @Param("projectId")String projectId, @Param("empLevelId")String empLevelId, @Param("empTypeId")String empTypeId);

    ProCapability fetchProCapabilityByCapabilityId(String capabilityId);

    int updateProCapability(ProCapability proCapability);
    
    List<ProCapability> queryProCapability();
    
    int getSortByBlockId(String blockId);
    
    int addProCapability(ProCapability proCapability);
}
