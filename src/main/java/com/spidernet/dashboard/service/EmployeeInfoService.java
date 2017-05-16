package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.EmployeeInfo;
import com.spidernet.dashboard.entity.PageCondition;

public interface EmployeeInfoService
{
    
    List<EmployeeInfo> queryEmpInfo(PageCondition pageCondition);
    
    int countPage(PageCondition pageCondition);

}
