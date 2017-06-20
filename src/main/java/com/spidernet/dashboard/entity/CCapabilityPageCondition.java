package com.spidernet.dashboard.entity;

public class CCapabilityPageCondition extends PageCondition
{
    
    private String blockId;
    
    private String cCapabilityName;

    public String getBlockId()
    {
        return blockId;
    }

    public void setBlockId(String blockId)
    {
        this.blockId = blockId;
    }

    public String getcCapabilityName()
    {
        return cCapabilityName;
    }

    public void setcCapabilityName(String cCapabilityName)
    {
        this.cCapabilityName = cCapabilityName;
    }

    public CCapabilityPageCondition()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public CCapabilityPageCondition(String blockId, String cCapabilityName)
    {
        super();
        this.blockId = blockId;
        this.cCapabilityName = cCapabilityName;
    }

    @Override
    public String toString()
    {
        return "CCapabilityPageCondition [blockId=" + blockId
                + ", cCapabilityName=" + cCapabilityName + "]";
    }
    
    

}
