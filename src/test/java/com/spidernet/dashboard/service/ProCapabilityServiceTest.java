package com.spidernet.dashboard.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spidernet.dashboard.entity.ProCapability;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class ProCapabilityServiceTest
{

    @Resource
    ProCapabilityService proCapabilityService;

    @Test
    public void testViewProCapability()
    {
        Boolean proValue = false;
        String blockId = "4952b0b50f5548aeb8d3e83e3de6c03e";
        String buId = "be27be6911304fd1a265dfcf8d5cc80f";
        String projectId = "083c3e88219542739ed202bbc38a56ea";
        String empLevelId = "e5b4d2d0792f4b88950c4fe2383b8068";
        String empTypeId = "a6b8fd9eb5e547da907c7a004810d0a1";
        List<ProCapability> proList = proCapabilityService.viewProCapability(blockId, buId, projectId, empLevelId, empTypeId);

        if (proList.size() > 0)
        {
            proValue = true;
        }

        assertTrue(proValue);
    }

    @Test
    public void testFetchProCapabilityByCapabilityId()
    {
        String capabilityId = "0db87337c495498bbcea32eaebf9922f";
        assertNotNull(proCapabilityService.fetchProCapabilityByCapabilityId(capabilityId));
    }

   /* @Test
    public void testUpdateProCapability()
    {
        fail("Not yet implemented");
    }*/

}
