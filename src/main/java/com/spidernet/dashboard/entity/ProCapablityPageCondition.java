package com.spidernet.dashboard.entity;

public class ProCapablityPageCondition extends PageCondition
{
    
    private String buId;
    
    private String projectId;
    
    private String typeId;
    
    private String levelId;
    
    private String blockId;
    
    private String proCapabilityName;

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

    public String getTypeId()
    {
        return typeId;
    }

    public void setTypeId(String typeId)
    {
        this.typeId = typeId;
    }

    public String getLevelId()
    {
        return levelId;
    }

    public void setLevelId(String levelId)
    {
        this.levelId = levelId;
    }

    public String getBlockId()
    {
        return blockId;
    }

    public void setBlockId(String blockId)
    {
        this.blockId = blockId;
    }

    public String getProCapabilityName()
    {
        return proCapabilityName;
    }

    public void setProCapabilityName(String proCapabilityName)
    {
        this.proCapabilityName = proCapabilityName;
    }

    public ProCapablityPageCondition()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProCapablityPageCondition(String buId, String projectId,
            String typeId, String levelId, String blockId,
            String proCapabilityName)
    {
        super();
        this.buId = buId;
        this.projectId = projectId;
        this.typeId = typeId;
        this.levelId = levelId;
        this.blockId = blockId;
        this.proCapabilityName = proCapabilityName;
    }

    @Override
    public String toString()
    {
        return "ProCapablityPageCondition [buId=" + buId + ", projectId="
                + projectId + ", typeId=" + typeId + ", levelId=" + levelId
                + ", blockId=" + blockId + ", proCapabilityName="
                + proCapabilityName + "]";
    }
    
    

}
