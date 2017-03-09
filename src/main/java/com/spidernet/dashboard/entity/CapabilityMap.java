package com.spidernet.dashboard.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * view capability map
 * 
 * @author Hurricane
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Object")
@XmlType(propOrder = { "capabilityMap"})
public class CapabilityMap
{
    @XmlElementWrapper(name = "capabilityMap")
    @XmlElement(name = "capability")
    private List<CapabilityB> capabilityMap = new ArrayList<CapabilityB>();
    
    public List<CapabilityB> getCapabilityMap()
    {
        return capabilityMap;
    }

    public void setCapabilityMap(List<CapabilityB> capabilityMap)
    {
        this.capabilityMap = capabilityMap;
    }
}
