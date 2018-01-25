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

import com.spidernet.dashboard.entity.TrainPlan;
import com.spidernet.dashboard.entity.TrainPlanContainId;
import com.spidernet.dashboard.service.TrainPlanService;

@Controller
@RequestMapping("/TrainingPlan")
public class TrainPlanController {

    private static Logger logger = LoggerFactory.getLogger(TrainPlanController.class);

    @Resource
    TrainPlanService trainPlanService;

    @RequestMapping("/queryTrainPlan")
    @ResponseBody
    public Object queryAll(final HttpServletRequest request, final HttpServletResponse response) {
        logger.info("TrainPlan : test");

        String tcId = request.getParameter("trainCourceId");
        List<TrainPlanContainId> listTrainPlanContainId = trainPlanService.queryTrainPlanByTrainCourseId(tcId);
        if (listTrainPlanContainId.isEmpty()) {
            return listTrainPlanContainId;
        } else {
            return listTrainPlanContainId;
        }
    }

    @RequestMapping("/addTrainPlan")
    @ResponseBody
    public boolean addTrainPlan(final HttpServletRequest request, final HttpServletResponse response) {
        logger.info("trainPlan : test");
        String parentTrainingName = request.getParameter("parentTrainingName");
        String childTrainName = request.getParameter("childTrainingName");
        String trainTime = request.getParameter("trainningTime");
        String trainRoom = request.getParameter("trainingRoom");
        int participants = Integer.parseInt(request.getParameter("participantsNumber"));
        String active = "Y";
        String trainCourceId = request.getParameter("trainingCourceId");
        TrainPlan trainPlan = new TrainPlan();
        trainPlan.setParentTrainingName(parentTrainingName);
        trainPlan.setChildTrainName(childTrainName);
        trainPlan.setTrainTime(trainTime);
        trainPlan.setTrainRoom(trainRoom);
        trainPlan.setParticipants(participants);
        trainPlan.setActive(active);
        trainPlan.setTrainCourseId(trainCourceId);

        return trainPlanService.addTrainPlan(trainPlan);
    }

    @RequestMapping("/updateTrainPlan")
    @ResponseBody
    public boolean updateTrainPlan(final HttpServletRequest request, final HttpServletResponse response) {

        String parentTrainingName = request.getParameter("parentTrainingName");
        String childTrainName = request.getParameter("childTrainingName");
        String trainTime = request.getParameter("trainningTime");
        String trainRoom = request.getParameter("trainingRoom");
        int participants = Integer.parseInt(request.getParameter("participantsNumber"));
        String trainCourceId = request.getParameter("trainingCourceId");
        TrainPlan trainPlan = new TrainPlan();
        trainPlan.setParentTrainingName(parentTrainingName);
        trainPlan.setChildTrainName(childTrainName);
        trainPlan.setTrainTime(trainTime);
        trainPlan.setTrainRoom(trainRoom);
        trainPlan.setParticipants(participants);
        trainPlan.setTrainCourseId(trainCourceId);

        return trainPlanService.updateTrainPlanByParentTrainName(trainPlan);
    }

    @RequestMapping("/queryTrainPlanByAllocationId")
    @ResponseBody
    public Object queryAllByAllocationId(final HttpServletRequest request, final HttpServletResponse response) {
        logger.info("TrainPlan : test");
        String apId = request.getParameter("allocationPlanId");
        TrainPlan TrainPlan = trainPlanService.queryTrainPlanByAllocationPlanId(apId);
        return TrainPlan;

    }

    @RequestMapping("/deleteTrainPlanByAllocationId")
    @ResponseBody
    public boolean deleteByAllocationId(final HttpServletRequest request, final HttpServletResponse response) {
        logger.info("TrainPlan : test");
        int apId = Integer.parseInt(request.getParameter("allocationPlanId"));
        return trainPlanService.deleteByAllocationPlanId(apId);

    }

}
