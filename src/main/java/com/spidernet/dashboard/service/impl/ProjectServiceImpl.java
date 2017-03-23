package com.spidernet.dashboard.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spidernet.dashboard.dao.ProjectMapper;
import com.spidernet.dashboard.entity.Project;
import com.spidernet.dashboard.service.ProjectService;
/**
 * 
 * @author nick
 *
 */
@Service
public class ProjectServiceImpl implements ProjectService
{

    @Resource
    private ProjectMapper projectMapper;
    
    @Override
    public Project findProjectName(String projectId)
    {
        Project project = projectMapper.findProjectName(projectId);
        
        return project;
    }

    @Override
    public List<Project> queryProject(String buId)
    {
        List<Project> listP = projectMapper.queryProject(buId);
        
        return listP;
    }

}
