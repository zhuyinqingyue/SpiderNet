package com.spidernet.dashboard.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Private Capability Area
 * 
 * @author Hurricane
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "proCapabilityId", "blockId", "buId", "projectId", "empLevelId", "name", "description", "sort", "url", "empTypeId", "isExam", "isTraining", "status" })
public class ProCapability
{

    private String proCapabilityId;
    private String blockId;
    private String buId;
    private String projectId;
    private String empLevelId;
    private String name;
    private String description;
    private int sort;
    private String url;
    private String empTypeId;
    private Boolean isExam;   
    private Boolean isTraining;
    private String status;
    
    public String getProCapabilityId()
    {
        return proCapabilityId;
    }

    public void setProCapabilityId(String proCapabilityId)
    {
        this.proCapabilityId = proCapabilityId;
    }

    public String getBlockId()
    {
        return blockId;
    }

    public void setBlockId(String blockId)
    {
        this.blockId = blockId;
    }

    public String getBuId()
    {
        return buId;
    }

    public void setBuId(String buId)
    {
        this.buId = buId;
    }

    public String getProjectId()
    {
        return projectId;
    }

    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public String getEmpLevelId()
    {
        return empLevelId;
    }

    public void setEmpLevelId(String empLevelId)
    {
        this.empLevelId = empLevelId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getSort()
    {
        return sort;
    }

    public void setSort(int sort)
    {
        this.sort = sort;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getEmpTypeId()
    {
        return empTypeId;
    }

    public void setEmpTypeId(String empTypeId)
    {
        this.empTypeId = empTypeId;
    }

    public Boolean getIsExam()
    {
        return isExam;
    }

    public void setIsExam(Boolean isExam)
    {
        this.isExam = isExam;
    }

    public Boolean getIsTraining()
    {
        return isTraining;
    }

    public void setIsTraining(Boolean isTraining)
    {
        this.isTraining = isTraining;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}
