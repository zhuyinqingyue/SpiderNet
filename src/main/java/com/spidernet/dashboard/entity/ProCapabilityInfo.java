package com.spidernet.dashboard.entity;

public class ProCapabilityInfo
{
    
    private String proCapabilityId;
    private String proCapabilityName;
    private String blockName;
    private String buName;
    private String projectName;
    private String typeName;
    private String levelName;
    public String getProCapabilityId()
    {
        return proCapabilityId;
    }
    public void setProCapabilityId(String proCapabilityId)
    {
        this.proCapabilityId = proCapabilityId;
    }
    public String getProCapabilityName()
    {
        return proCapabilityName;
    }
    public void setProCapabilityName(String proCapabilityName)
    {
        this.proCapabilityName = proCapabilityName;
    }
    public String getBlockName()
    {
        return blockName;
    }
    public void setBlockName(String blockName)
    {
        this.blockName = blockName;
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
    public String getTypeName()
    {
        return typeName;
    }
    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }
    public String getLevelName()
    {
        return levelName;
    }
    public void setLevelName(String levelName)
    {
        this.levelName = levelName;
    }
    public ProCapabilityInfo()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public ProCapabilityInfo(String proCapabilityId, String proCapabilityName,
            String blockName, String buName, String projectName,
            String typeName, String levelName)
    {
        super();
        this.proCapabilityId = proCapabilityId;
        this.proCapabilityName = proCapabilityName;
        this.blockName = blockName;
        this.buName = buName;
        this.projectName = projectName;
        this.typeName = typeName;
        this.levelName = levelName;
    }
    @Override
    public String toString()
    {
        return "ProCapabilityInfo [proCapabilityId=" + proCapabilityId
                + ", proCapabilityName=" + proCapabilityName + ", blockName="
                + blockName + ", buName=" + buName + ", projectName="
                + projectName + ", typeName=" + typeName + ", levelName="
                + levelName + "]";
    }
    
    
}
