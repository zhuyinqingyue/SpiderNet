package com.spidernet.dashboard.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spidernet.dashboard.entity.PersonalTrainning;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PersonalTrainningServiceTest
{

    @Resource
    PersonalTrainningService personalTrainningService;
    
    @Test
    @Rollback(true)
    public void testAddPersonalTrainning()
    {
        List<PersonalTrainning> personalTrainningList = new ArrayList<PersonalTrainning>();
        PersonalTrainning personalTrainning1 = new PersonalTrainning();
        PersonalTrainning personalTrainning2 = new PersonalTrainning();

        personalTrainning1.setEmployeeId("e5b4d2d0792f4b88950c4fe2383b8068");
        personalTrainning1.setStatus("0");
        personalTrainning1.setTrainningId("5721b3b036f74b6c9542724e9f2bc079");

        personalTrainning2.setEmployeeId("e5b4d2d0792f4b88950c4fe2383b8069");
        personalTrainning2.setStatus("0");
        personalTrainning2.setTrainningId("5721b3b036f74b6c9542724e9f2bc079");

        personalTrainningList.add(personalTrainning1);
        personalTrainningList.add(personalTrainning2);
        assertTrue(personalTrainningService.addPersonalTrainning(personalTrainningList));
    }

    @Test
    public void testCheckPersonalTrainningExists()
    {
        PersonalTrainning personalTrainning = new PersonalTrainning();
        personalTrainning.setEmployeeId("9a5069a636f04df194c4998a4167d87e");
        personalTrainning.setTrainningId("5721b3b036f74b6c9541724e9f2bc069");
        assertTrue(personalTrainningService.checkPersonalTrainningExists(personalTrainning));
    }

}
