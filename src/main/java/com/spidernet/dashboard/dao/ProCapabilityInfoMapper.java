package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.ProCapabilityInfo;
import com.spidernet.dashboard.entity.ProCapablityPageCondition;

public interface ProCapabilityInfoMapper
{
    List<ProCapabilityInfo> queryProCapabilityInfo(ProCapablityPageCondition proCapablityPageCondition);
    
    int countProCapabilityPage(ProCapablityPageCondition proCapablityPageCondition);
}
