package com.spidernet.dashboard.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Public Capability Area
 * 
 * @author Hurricane
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "commCapabilityId", "blockId", "name", "description", "sort", "url", "parentId", "buList", "isExam", "isTraining", "status" })
public class CCapability
{

    private String commCapabilityId;
    private String blockId;
    private String name;
    private String description;
    private int sort;
    private String url;
    private String parentId;
    private String buList;
    private Boolean isExam;   
    private Boolean isTraining;
    private String status;

    public String getCommCapabilityId()
    {
        return commCapabilityId;
    }

    public void setCommCapabilityId(String commCapabilityId)
    {
        this.commCapabilityId = commCapabilityId;
    }

    public String getBlockId()
    {
        return blockId;
    }

    public void setBlockId(String blockId)
    {
        this.blockId = blockId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getBuList()
    {
        return buList;
    }

    public void setBuList(String buList)
    {
        this.buList = buList;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
