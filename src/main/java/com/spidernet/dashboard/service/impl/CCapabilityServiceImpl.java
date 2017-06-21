package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.CCapabilityMapper;
import com.spidernet.dashboard.entity.CCapability;
import com.spidernet.dashboard.service.CCapabilityService;

@Service
public class CCapabilityServiceImpl implements CCapabilityService
{
    @Resource
    private CCapabilityMapper cCapabilityMapper;

    @Override
    public List<CCapability> viewCCapability(String blockId, String buList)
    {
        List<CCapability> cCapabilityDb = cCapabilityMapper.viewCCapability(blockId, buList);
        return cCapabilityDb;
    }

    @Override
    public CCapability fetchCommonCapabilty(String capabilityId)
    {
        // TODO Auto-generated method stub
        CCapability commonCapability = cCapabilityMapper.fetchCommonCapabilty(capabilityId);

        return commonCapability;
    }

    @Override
    public List<CCapability> queryCommonCapability()
    {
        List<CCapability> cCapabilityList = cCapabilityMapper.queryCommonCapability();
        return cCapabilityList;
    }

    @Override
    public int getSortByBlockId(String blockId)
    {
        return cCapabilityMapper.getSortByBlockId(blockId) + 1;
    }

    @Override
    public boolean addCommonCapability(CCapability cCapability)
    {
        if(cCapabilityMapper.addCommonCapability(cCapability)>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<CCapability> queryCCapabilityListByBlockId(String blockId)
    {
        List<CCapability> cCapabilityListB =  cCapabilityMapper.queryCCapabilityListByBlockId(blockId);
        return cCapabilityListB;
    }
}
