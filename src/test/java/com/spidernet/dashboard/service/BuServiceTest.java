package com.spidernet.dashboard.service;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class BuServiceTest
{

    @Resource
    BuService buService;
    
    @Test
    public void testFindBuName()
    {
        String buId = "be27be6911304fd1a265dfcf8d5cc80f";
        assertNotNull(buService.findBuName(buId));
    }

}
