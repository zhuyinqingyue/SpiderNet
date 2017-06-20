package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.BlockMapper;
import com.spidernet.dashboard.entity.Block;
import com.spidernet.dashboard.service.BlockService;

@Service
public class BlockServiceImpl implements BlockService
{

    @Resource
    private BlockMapper blockMapper;
    
    @Override
    public List<Block> queryBlockList()
    {
        List<Block> blockList = blockMapper.queryBlockList();
        return blockList;
    }

}
