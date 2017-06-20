package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.ProCapabilityInfo;
import com.spidernet.dashboard.entity.ProCapablityPageCondition;

public interface ProCapabilityInfoService
{
    List<ProCapabilityInfo> queryProCapabilityInfo(ProCapablityPageCondition proCapablityPageCondition);
    
    int countProCapabilityPage(ProCapablityPageCondition proCapablityPageCondition);
}
