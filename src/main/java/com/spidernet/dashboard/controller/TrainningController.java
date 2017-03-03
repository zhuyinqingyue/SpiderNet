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

import com.spidernet.dashboard.entity.Trainning;
import com.spidernet.dashboard.service.TrainningService;

@Controller
public class TrainningController
{
    @Resource
    TrainningService trainningService;

    private static Logger logger = LoggerFactory
            .getLogger(TrainningController.class);

    @RequestMapping("/trainningList")
    @ResponseBody
    public Object trainningList(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        String capabilityId = request.getParameter("capabilityId");

        List<Trainning> trainningList = trainningService.fetchAllTrainning(capabilityId);
/*      Trainning trainning1 = new Trainning();
        Trainning trainning2 = new Trainning();

        List<Trainning> trainningList = new ArrayList<Trainning>();

        trainningList.add(trainning1);
        trainningList.add(trainning2);
*/
        return trainningList;
    }

}
