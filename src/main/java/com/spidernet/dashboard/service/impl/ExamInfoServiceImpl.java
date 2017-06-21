package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.ExamInfoMapper;
import com.spidernet.dashboard.entity.ExamInfo;
import com.spidernet.dashboard.entity.ExamPageCondition;
import com.spidernet.dashboard.service.ExamInfoService;

@Service
public class ExamInfoServiceImpl implements ExamInfoService
{

    @Resource
    private ExamInfoMapper examInfoMapper;
    
    @Override
    public List<ExamInfo> queryExamInfo(ExamPageCondition examPageCondition)
    {
        List<ExamInfo> examInfoList = examInfoMapper.queryExamInfo(examPageCondition);
        return examInfoList;
    }

    @Override
    public int countExamPage(ExamPageCondition examPageCondition)
    {
        return examInfoMapper.countExamPage(examPageCondition)/10 + 1;
    }

}
