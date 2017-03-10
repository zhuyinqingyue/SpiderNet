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

import com.spidernet.dashboard.entity.Level;
import com.spidernet.dashboard.service.LevelService;
/**
 * load employee level
 * @author nick
 *
 */
@Controller
@RequestMapping("/level")
public class LevelController
{
    private static Logger logger = LoggerFactory
            .getLogger(LevelController.class);

    @Resource
    LevelService levelService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public Object queryAll(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.debug("query level list begin");

        List<Level> listL = levelService.queryLevel();

        return listL;
    }
}
