package com.spidernet.dashboard.dao;

import com.spidernet.dashboard.entity.PersonalMap;

public interface PersonalMapMapper
{
    int addPersonalMap(PersonalMap personalMap);
    PersonalMap fetchByEmpId(String employeeId);
}
