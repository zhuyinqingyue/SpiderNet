package com.spidernet.dashboard.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.entity.Project;
import com.spidernet.dashboard.service.ProjectService;

/**
 * 
 * @author nick
 *
 */
@Controller
@RequestMapping("/project")
public class ProjectController
{

    private static Logger logger = LoggerFactory
            .getLogger(LevelController.class);

    @Resource
    ProjectService projectService;

    @RequestMapping("/queryProjectName")
    @ResponseBody
    public Object queryProjectName(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.info("debug------test----");

        HttpSession session = request.getSession();

        Employee employee = new Employee();

        employee = (Employee) session.getAttribute("employee");

        String projectId = employee.getProjectId();

        Project project = projectService.findProjectName(projectId);
        
        return project;
    }
    
    
    @RequestMapping("/queryAll")
    @ResponseBody
    public Object queryAll(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.info("debug------test----");
        
        String buId = request.getParameter("buId");
        
        List<Project> listP = projectService.queryProject(buId);
        
        return listP;
    }

}
