package com.spidernet.dashboard.entity;

/**
 * 能力领域表
 *
 * @author Hurricane
 *
 */
public class CapabilityB
{
    private String blockId;
    private String name;
    private String descipion;
    private int sort;
    private int blockType;

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

    public String getDescipion()
    {
        return descipion;
    }

    public void setDescipion(String descipion)
    {
        this.descipion = descipion;
    }

    public int getSort()
    {
        return sort;
    }

    public void setSort(int sort)
    {
        this.sort = sort;
    }

    public int getBlockType()
    {
        return blockType;
    }

    public void setBlockType(int blockType)
    {
        this.blockType = blockType;
    }
}
