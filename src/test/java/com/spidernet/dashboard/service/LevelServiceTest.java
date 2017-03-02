package com.spidernet.dashboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spidernet.dashboard.entity.Level;
import com.spidernet.dashboard.service.LevelService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/spring-mvc.xml", "classpath:conf/spring-mybatis.xml" })
public class LevelServiceTest
{
    @Resource
    LevelService levelService;
    @Test
    public void testLevelList(){
        List<Level> listL = levelService.queryLevel();

        for(Level s : listL){
            System.out.print(s);
           }
    }
}
