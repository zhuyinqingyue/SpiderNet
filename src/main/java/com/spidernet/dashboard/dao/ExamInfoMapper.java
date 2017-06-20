package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.ExamInfo;
import com.spidernet.dashboard.entity.ExamPageCondition;

public interface ExamInfoMapper
{
    
    List<ExamInfo> queryExamInfo(ExamPageCondition examPageCondition);
    
    int countExamPage(ExamPageCondition examPageCondition);

}
