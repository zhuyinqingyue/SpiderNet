package com.spidernet.dashboard.dao;

import java.util.List;

import com.spidernet.dashboard.entity.Project;

public interface ProjectMapper
{
    Project findProjectName(String projectId);
    
    List<Project> queryProject(String buId);
    
}
