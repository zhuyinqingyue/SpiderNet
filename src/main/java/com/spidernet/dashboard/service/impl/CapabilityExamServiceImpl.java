package com.spidernet.dashboard.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.CapabilityExamMapper;
import com.spidernet.dashboard.entity.CapabilityExam;
import com.spidernet.dashboard.service.CapabilityExamService;
/**
 *
 * @author Hurricane
 *
 */
@Service
public class CapabilityExamServiceImpl implements CapabilityExamService
{

    @Resource
    private CapabilityExamMapper capabilityExamMapper;

    @Override
    public Boolean accountCapabilityExam(String capabilityId)
    {
        if (capabilityExamMapper.accountCapabilityExam(capabilityId) > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public String fetchCapabilityIdByExamId(String examId)
    {
        // TODO Auto-generated method stub
        String capabilityId = capabilityExamMapper.fetchCapabilityIdByExamId(examId);

        return capabilityId;
    }

    @Override
    public String capabilityExamStatus(String capabilityId,String employeeId)
    {
        String capabilityExamStatus = capabilityExamMapper.capabilityExamStatus(capabilityId, employeeId);
        return capabilityExamStatus;
    }

    @Override
    public Boolean addCapabilityExam(CapabilityExam capabilityExam)
    {
        if(capabilityExamMapper.addCapabilityExam(capabilityExam)>0){
            return true;
        }else{
            return false;
        }
    }
}
