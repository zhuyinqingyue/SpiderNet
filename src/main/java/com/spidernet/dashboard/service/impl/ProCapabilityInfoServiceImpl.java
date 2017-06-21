package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.ProCapabilityInfoMapper;
import com.spidernet.dashboard.entity.ProCapabilityInfo;
import com.spidernet.dashboard.entity.ProCapablityPageCondition;
import com.spidernet.dashboard.service.ProCapabilityInfoService;

@Service
public class ProCapabilityInfoServiceImpl implements ProCapabilityInfoService
{
    @Resource
    private ProCapabilityInfoMapper proCapabilityInfoMapper;

    @Override
    public List<ProCapabilityInfo> queryProCapabilityInfo(
            ProCapablityPageCondition proCapablityPageCondition)
    {
        List<ProCapabilityInfo> proCapabilityList = proCapabilityInfoMapper.queryProCapabilityInfo(proCapablityPageCondition);
        return proCapabilityList;
    }

    @Override
    public int countProCapabilityPage(
            ProCapablityPageCondition proCapablityPageCondition)
    {
        return proCapabilityInfoMapper.countProCapabilityPage(proCapablityPageCondition)/10 + 1;
    }

}
