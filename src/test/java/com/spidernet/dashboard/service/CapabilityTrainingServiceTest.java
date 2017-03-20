package com.spidernet.dashboard.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class CapabilityTrainingServiceTest
{

    @Resource
    CapabilityTrainingService capabilityTrainingService;
    
    @Test
    public void testAccountCapabilityTraining()
    {
        String capabilityId = "8c5cbd091caf49c09832b8f31df5ac36";
        assertTrue(capabilityTrainingService.accountCapabilityTraining(capabilityId));
    }

}
