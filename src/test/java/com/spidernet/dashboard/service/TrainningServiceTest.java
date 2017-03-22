package com.spidernet.dashboard.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spidernet.dashboard.entity.Trainning;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class TrainningServiceTest
{
    @Resource
    TrainningService trainningService;

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testFetchAllTrainning()
    {
        List<Trainning> trainningList = new ArrayList<Trainning>();
        String capabilityId = "8c5cbd091caf49c09832b8f31df5ac36";
        String employeeId = "9a5069a636f04df194c4998a4167d87e";
        trainningList = trainningService.fetchAllTrainning(capabilityId, employeeId);

        assertNotNull(trainningList);
    }

}
