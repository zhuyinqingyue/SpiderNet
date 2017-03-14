package com.spidernet.dashboard.entity;
/**
 * employee details
 * @author nick
 *
 */
public class EmployeeDetl
{
    public String empId;
    
    public String empName;
    
    public String buName;
    
    public String projectName;
    
    public String levelName;
    
    public String typeName;

    public String getEmpId()
    {
        return empId;
    }

    public void setEmpId(String empId)
    {
        this.empId = empId;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    public String getBuName()
    {
        return buName;
    }

    public void setBuName(String buName)
    {
        this.buName = buName;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getLevelName()
    {
        return levelName;
    }

    public void setLevelName(String levelName)
    {
        this.levelName = levelName;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public EmployeeDetl()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString()
    {
        return "EmployeeDetl [empId=" + empId + ", empName=" + empName
                + ", buName=" + buName + ", projectName=" + projectName
                + ", levelName=" + levelName + ", typeName=" + typeName + "]";
    }
    
    

}
