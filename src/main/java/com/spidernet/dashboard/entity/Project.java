package com.spidernet.dashboard.entity;
/**
 * project infomation
 * @author nick
 *
 */
public class Project
{
    
    private String projectId;
    
    private String buId;
    
    private String projectName;
    
    private String description;
    
    private String contactNumber;
    
    private String mangerName;
    
    private String projectStatus;

    public String getProjectId()
    {
        return projectId;
    }

    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public String getBuId()
    {
        return buId;
    }

    public void setBuId(String buId)
    {
        this.buId = buId;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public String getMangerName()
    {
        return mangerName;
    }

    public void setMangerName(String mangerName)
    {
        this.mangerName = mangerName;
    }

    public String getProjectStatus()
    {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus)
    {
        this.projectStatus = projectStatus;
    }

    public Project()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString()
    {
        return "Project [projectId=" + projectId + ", buId=" + buId
                + ", projectName=" + projectName + ", description="
                + description + ", contactNumber=" + contactNumber
                + ", mangerName=" + mangerName + ", projectStatus="
                + projectStatus + "]";
    }

    
    

}
