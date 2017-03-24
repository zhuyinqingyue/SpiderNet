package com.spidernet.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

public class XmlUtilTest
{
    
    @Resource
    XmlUtil xmlUtil;
    
    @Test
    public void testXmlUtil(){
        XmlObject xmlObject = new XmlObject();
        xmlObject.setId(1);
        xmlObject.setCurrentDay(new Date());
        xmlObject.setName("name");
        xmlObject.setDoubleData(0.23);
        XmlObjectChild child1 = new XmlObjectChild();
        child1.setId("id1");
        child1.setName("name1");
        XmlObjectChild child2 = new XmlObjectChild();
        child2.setId("id2");
        child2.setName("name2");
        List<XmlObjectChild> listChild = new ArrayList<XmlObjectChild>();
        listChild.add(child2);
        listChild.add(child1);
        xmlObject.setListChild(listChild);
        String str = xmlUtil.convertToXml(xmlObject);
        System.out.println(str);
        XmlObject xmlString = (XmlObject) xmlUtil.convertXmlStrToObject(XmlObject.class,
                str);
        System.out.println(xmlString);
    }

}
