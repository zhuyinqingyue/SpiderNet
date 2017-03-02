package com.spidernet.dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.LevelMapper;
import com.spidernet.dashboard.entity.Level;
import com.spidernet.dashboard.service.LevelService;

@Service
public class LevelServiceImpl implements LevelService
{

    @Resource
    private LevelMapper levelMapper;

    @Override
    public List<Level> queryLevel()
    {

        List<Level> listL = new ArrayList();

        listL = levelMapper.queryLevel();

        return listL;
    }

}
