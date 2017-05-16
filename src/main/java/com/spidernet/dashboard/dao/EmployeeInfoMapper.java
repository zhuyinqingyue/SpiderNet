package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.EmployeeInfo;
import com.spidernet.dashboard.entity.PageCondition;

public interface EmployeeInfoMapper
{
    
    List<EmployeeInfo> queryEmpInfo(PageCondition pageCondition);
    
    int countPage(PageCondition pageCondition);

}
