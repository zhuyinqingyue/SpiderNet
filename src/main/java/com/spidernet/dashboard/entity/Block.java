package com.spidernet.dashboard.entity;

public class Block
{
    private String blockId;
    
    private String blockName;
    
    private String description;
    
    private String sort;
    
    private String blockType;

    public String getBlockId()
    {
        return blockId;
    }

    public void setBlockId(String blockId)
    {
        this.blockId = blockId;
    }

    public String getBlockName()
    {
        return blockName;
    }

    public void setBlockName(String blockName)
    {
        this.blockName = blockName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public String getBlockType()
    {
        return blockType;
    }

    public void setBlockType(String blockType)
    {
        this.blockType = blockType;
    }

    public Block()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public Block(String blockId, String blockName, String description,
            String sort, String blockType)
    {
        super();
        this.blockId = blockId;
        this.blockName = blockName;
        this.description = description;
        this.sort = sort;
        this.blockType = blockType;
    }

    @Override
    public String toString()
    {
        return "Block [blockId=" + blockId + ", blockName=" + blockName
                + ", description=" + description + ", sort=" + sort
                + ", blockType=" + blockType + "]";
    }
    
    
}
