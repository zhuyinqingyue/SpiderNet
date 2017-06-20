package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.CCapabilityInfo;
import com.spidernet.dashboard.entity.CCapabilityPageCondition;

public interface CCapabilityInfoService
{
    
    List<CCapabilityInfo> queryCommonCapabilityInfo(CCapabilityPageCondition cCapabilityPageCondition);
    
    int countCommonCapabilityPage(CCapabilityPageCondition cCapabilityPageCondition);

}
