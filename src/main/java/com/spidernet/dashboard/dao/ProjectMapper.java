package com.spidernet.dashboard.dao;

import com.spidernet.dashboard.entity.Project;

public interface ProjectMapper
{
    Project findProjectName(String projectId);
}
