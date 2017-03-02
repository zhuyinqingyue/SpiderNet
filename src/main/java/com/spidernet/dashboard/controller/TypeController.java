package com.spidernet.dashboard.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spidernet.dashboard.entity.Type;
import com.spidernet.dashboard.service.TypeService;
/**
 * load employee type
 * @author nick
 *
 */
@Controller
@RequestMapping("/type")
public class TypeController
{
    private static Logger logger = LoggerFactory
            .getLogger(TypeController.class);
    
    @Resource
    TypeService typeService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public Object querytype(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.info("debug------test----");
        
        List<Type> listT = typeService.queryType();

        return listT;
    }
}
