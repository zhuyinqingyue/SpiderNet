package com.spidernet.dashboard.dao;

import com.spidernet.dashboard.entity.PersonalMap;

public interface PersonalMapMapper
{
    int addPersonalMap(PersonalMap personalMap);
    PersonalMap fetchByEmpId(String employeeId);
    void viewPersonalMap(PersonalMap personalMap);
    int updatePersonalMap(PersonalMap personalMap);
    String findPersonalMapIdByEmpId(String employeeId);
}
