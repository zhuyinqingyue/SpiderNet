package com.spidernet.util;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spidernet.util.Constants;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/spring-mvc.xml", "classpath:conf/spring-mybatis.xml" })
public class ConstantsTest
{
    @Test
    public void testConstants(){

        assertSame(Constants.ER_PATTERN,"^E[0-9]{9}");
        assertSame(Constants.HR_PATTERN,"^\\d{5,12}$");
        assertSame(Constants.WECHAT_PATTERN,"");
        assertSame(Constants.ONE,1);
        assertSame(Constants.TWO,2);
        assertSame(Constants.ZERO,0);
        assertSame(Constants.TRAINNING_STATUS_REGISTED,"0");
        assertSame(Constants.EXAM_STATUS_REGISTED,"2");
        
    }
}
