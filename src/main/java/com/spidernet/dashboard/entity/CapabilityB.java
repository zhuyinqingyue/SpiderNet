package com.spidernet.dashboard.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * Capability Area
 * 
 * @author Hurricane
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "blockId", "name", "descipion", "sort", "blockType", "cCapabilityL", "proCapabilityL" })
public class CapabilityB
{
    private String blockId;
    private String name;
    private String descipion;
    private int sort;
    private int blockType;
    @XmlElementWrapper(name = "cCapabilityL")
    @XmlElement(name = "cCapability")
    private List<CCapability> cCapabilityL = new ArrayList<CCapability>();
    @XmlElementWrapper(name = "proCapabilityL")
    @XmlElement(name = "proCapability")
    private List<ProCapability> proCapabilityL = new ArrayList<ProCapability>();

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

    public List<CCapability> getcCapabilityL()
    {
        return cCapabilityL;
    }

    public void setcCapabilityL(List<CCapability> cCapabilityL)
    {
        this.cCapabilityL = cCapabilityL;
    }

    public List<ProCapability> getProCapabilityL()
    {
        return proCapabilityL;
    }

    public void setProCapabilityL(List<ProCapability> proCapabilityL)
    {
        this.proCapabilityL = proCapabilityL;
    }

}
