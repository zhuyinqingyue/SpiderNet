package com.spidernet.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Object")
@XmlType(propOrder = { "id", "name", "listChild", "currentDay", "doubleData" })
public class XmlObject implements Serializable
{
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    @XmlElementWrapper(name = "listChild")
    @XmlElement(name = "child")
    private List<XmlObjectChild> listChild;
    private Date currentDay;
    private double doubleData;

    @Override
    public String toString()
    {
        String childStr = "";
        for (XmlObjectChild ch : listChild)
        {
            childStr += ch.getId() + ":" + ch.getName() + ";";
        }
        return "XmlObject [id=" + id + ", name=" + name + ", currentDay="
                + currentDay + ", doubleData=" + doubleData + ", listChild="
                + childStr + "]";
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getCurrentDay()
    {
        return currentDay;
    }

    public void setCurrentDay(Date currentDay)
    {
        this.currentDay = currentDay;
    }

    public double getDoubleData()
    {
        return doubleData;
    }

    public void setDoubleData(double doubleData)
    {
        this.doubleData = doubleData;
    }

    public List<XmlObjectChild> getListChild()
    {
        return listChild;
    }

    public void setListChild(List<XmlObjectChild> listChild)
    {
        this.listChild = listChild;
    }

}
