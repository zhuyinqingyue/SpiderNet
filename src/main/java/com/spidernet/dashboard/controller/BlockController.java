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

import com.spidernet.dashboard.entity.Block;
import com.spidernet.dashboard.service.BlockService;

@Controller
@RequestMapping("/block")
public class BlockController
{
    private static Logger logger = LoggerFactory
            .getLogger(BuController.class);
    
    @Resource
    BlockService blockService;
    
    @RequestMapping("/queryBlockList")
    @ResponseBody
    public Object queryBlockList(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        List<Block> blockList = blockService.queryBlockList();
        return blockList;
    }
}
