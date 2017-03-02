package com.spidernet.dashboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spidernet.dashboard.entity.Type;
import com.spidernet.dashboard.service.TypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/spring-mvc.xml", "classpath:conf/spring-mybatis.xml" })
public class TypeServiceTest
{

    @Resource
    TypeService typeService;
    @Test
    public void testTypeList(){

        List<Type> listT = typeService.queryType();

        for(Type s : listT){
            System.out.print(s);
           }
    }

}
