package com.spidernet.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UtilsTest
{
    
    @Test
    public void testUtils(){
        
        Utils utils = new Utils();
        
        assertNotNull(utils.getUUID());
        
    }

}
