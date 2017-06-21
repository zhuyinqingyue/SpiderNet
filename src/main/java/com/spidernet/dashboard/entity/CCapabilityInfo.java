package com.spidernet.dashboard.entity;

public class CCapabilityInfo
{
    
    private String commonCapabilityId;
    
    private String commonCapabilityName;
    
    private String blockName;

    public String getCommonCapabilityId()
    {
        return commonCapabilityId;
    }

    public void setCommonCapabilityId(String commonCapabilityId)
    {
        this.commonCapabilityId = commonCapabilityId;
    }

    public String getCommonCapabilityName()
    {
        return commonCapabilityName;
    }

    public void setCommonCapabilityName(String commonCapabilityName)
    {
        this.commonCapabilityName = commonCapabilityName;
    }

    public String getBlockName()
    {
        return blockName;
    }

    public void setBlockName(String blockName)
    {
        this.blockName = blockName;
    }

    public CCapabilityInfo()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public CCapabilityInfo(String commonCapabilityId,
            String commonCapabilityName, String blockName)
    {
        super();
        this.commonCapabilityId = commonCapabilityId;
        this.commonCapabilityName = commonCapabilityName;
        this.blockName = blockName;
    }

    @Override
    public String toString()
    {
        return "CCapabilityInfo [commonCapabilityId=" + commonCapabilityId
                + ", commonCapabilityName=" + commonCapabilityName
                + ", blockName=" + blockName + "]";
    }
    
    

}
