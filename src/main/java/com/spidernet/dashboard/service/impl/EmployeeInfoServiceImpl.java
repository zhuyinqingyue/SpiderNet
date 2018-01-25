package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.EmployeeInfoMapper;
import com.spidernet.dashboard.entity.EmployeeInfo;
import com.spidernet.dashboard.entity.PageCondition;
import com.spidernet.dashboard.entity.TrainingInfo;
import com.spidernet.dashboard.service.EmployeeInfoService;

/**
 * 
 * @author nick
 *
 */
@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService
{

    @Resource
    private EmployeeInfoMapper employeeInfoMapper;
    
    @Override
    public List<EmployeeInfo> queryEmpInfo(PageCondition pageCondition)
    {
        List<EmployeeInfo> listE = employeeInfoMapper.queryEmpInfo(pageCondition);
        return listE;
    }
    
    @Override
    public int countPage(PageCondition pageCondition)
    {
        return employeeInfoMapper.countPage(pageCondition)/10 + 1;
    }

    @Override
    public List<EmployeeInfo> queryEmpList(String trainingId)
    {
        List<EmployeeInfo> listE = employeeInfoMapper.queryEmpList(trainingId);
        return listE;
    }
    
    @Override
    public List<TrainingInfo> queryEmpTrainingInfo(String erId)
    {
        List<TrainingInfo> listE = employeeInfoMapper.queryEmpTrainingInfo(erId);
        return listE;
    }
    
    public int updateEmpTrainingInfo(String ername, String trname) 
    {
    	int result=employeeInfoMapper.updateEmpTrainingInfo(ername, trname);
        return result ;
    }

	public int deleteEmpTrainingInfo(String ername, String trname) 
	{

		int result= employeeInfoMapper.deleteEmpTrainingInfo(ername, trname);
        return result;
	}

}
