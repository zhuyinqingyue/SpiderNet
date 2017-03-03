package com.spidernet.dashboard.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.BuMapper;
import com.spidernet.dashboard.entity.Bu;
import com.spidernet.dashboard.service.BuService;
/**
 * 
 * @author nick
 *
 */
@Service
public class BuServiceImpl implements BuService
{

    @Resource
    private BuMapper bumapper;
    
    @Override
    public Bu findBuName(String buId)
    {

        Bu bu = bumapper.findBuName(buId);
        
        return bu;
    }

}
