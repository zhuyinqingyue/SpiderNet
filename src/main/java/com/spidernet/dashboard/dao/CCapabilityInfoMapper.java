package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.CCapabilityInfo;
import com.spidernet.dashboard.entity.CCapabilityPageCondition;

public interface CCapabilityInfoMapper
{
    
    List<CCapabilityInfo> queryCommonCapabilityInfo(CCapabilityPageCondition cCapabilityPageCondition);
    
    int countCommonCapabilityPage(CCapabilityPageCondition cCapabilityPageCondition);

}
