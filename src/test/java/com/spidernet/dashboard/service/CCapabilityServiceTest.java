package com.spidernet.dashboard.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class CCapabilityServiceTest
{

    @Resource
    CCapabilityService cCapabilityService;
    
    @Test
    public void testViewCCapability()
    {
        String blockId = "a591e17545694727a20b89c7839a1ded";
        String buList = "be27be6911304fd1a265dfcf8d5cc80f";
        assertNotNull(cCapabilityService.viewCCapability(blockId, buList));
    }

}
