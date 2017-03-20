package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.TypeMapper;
import com.spidernet.dashboard.entity.Type;
import com.spidernet.dashboard.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService
{

    @Resource
    private TypeMapper typeMapper;

    @Override
    public List<Type> queryType()
    {

        List<Type> listT = typeMapper.queryType();

        return listT;
    }

}
