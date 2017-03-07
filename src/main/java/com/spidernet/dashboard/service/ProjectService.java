package com.spidernet.dashboard.service;

import java.util.List;

import com.spidernet.dashboard.entity.Project;

/**
 * 
 * @author nick
 *
 */
public interface ProjectService
{
    Project findProjectName(String projectId);
    
    List<Project> queryProject(String buId);
}
