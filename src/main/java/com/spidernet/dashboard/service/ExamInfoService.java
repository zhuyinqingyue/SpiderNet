package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.ExamInfo;
import com.spidernet.dashboard.entity.ExamPageCondition;

public interface ExamInfoService
{
    List<ExamInfo> queryExamInfo(ExamPageCondition examPageCondition);
    
    int countExamPage(ExamPageCondition examPageCondition);
}
