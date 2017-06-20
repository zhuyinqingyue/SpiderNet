package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.CCapabilityInfoMapper;
import com.spidernet.dashboard.entity.CCapabilityInfo;
import com.spidernet.dashboard.entity.CCapabilityPageCondition;
import com.spidernet.dashboard.service.CCapabilityInfoService;

@Service
public class CCapabilityInfoServiceImpl implements CCapabilityInfoService
{

    @Resource
    private CCapabilityInfoMapper cCapabilityInfoMapper;
    
    @Override
    public List<CCapabilityInfo> queryCommonCapabilityInfo(
            CCapabilityPageCondition cCapabilityPageCondition)
    {
        List<CCapabilityInfo> cCapabilityInfoList = cCapabilityInfoMapper.queryCommonCapabilityInfo(cCapabilityPageCondition);
        return cCapabilityInfoList;
    }

    @Override
    public int countCommonCapabilityPage(
            CCapabilityPageCondition cCapabilityPageCondition)
    {
        cCapabilityInfoMapper.countCommonCapabilityPage(cCapabilityPageCondition);
        return cCapabilityInfoMapper.countCommonCapabilityPage(cCapabilityPageCondition)/10 + 1;
    }

}
