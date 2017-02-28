package com.spidernet.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * xml and object : convert
 *
 * @author Fred Mao
 *
 */
public class XmlUtil
{

    private static Logger logger = LoggerFactory.getLogger(XmlUtil.class);

    /**
     * convert object to xml string.
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj)
    {
        StringWriter sw = new StringWriter();
        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.marshal(obj, sw);
        }
        catch (JAXBException e)
        {
            logger.error(
                    "[XmlUtil.convertToXml(Object obj) convert object to xml String error.pls check.]",
                    e);
        }
        return sw.toString();
    }

    /**
     * convert object to xml file.
     *
     * @param obj
     * @param path
     */
    public static void convertToXml(Object obj, String path)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            FileWriter fw = null;
            fw = new FileWriter(path);
            marshaller.marshal(obj, fw);
        }
        catch (Exception e)
        {
            logger.error(
                    "[XmlUtil.convertToXml(Object obj, String path) convert object to xml file error. pls check.]",
                    e);
        }
    }

    @SuppressWarnings("unchecked")
    /**
     * convert str xml to object.
     *
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object convertXmlStrToObject(Class clazz, String xmlStr)
    {
        Object xmlObject = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        }
        catch (JAXBException e)
        {
            logger.error(
                    "[XmlUtil.convertXmlStrToObject(Class clazz, String xmlStr) convert xml file to object error. pls check.]",
                    e);
        }
        return xmlObject;
    }

    @SuppressWarnings("unchecked")
    /**
     * convert file xml to object.
     *
     * @param clazz
     * @param xmlPath
     * @return
     */
    public static Object convertXmlFileToObject(Class clazz, String xmlPath)
    {
        Object xmlObject = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            fr = new FileReader(xmlPath);
            xmlObject = unmarshaller.unmarshal(fr);
        }
        catch (Exception e)
        {
            logger.error(
                    "[XmlUtil.convertXmlFileToObject(Class clazz, String xmlPath) convert object to xml file error. pls check.]",
                    e);
        }
        return xmlObject;
    }

    public static void main(String[] args)
    {
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
        String str = convertToXml(xmlObject);
        System.out.println(str);
        XmlObject xmlString = (XmlObject) convertXmlStrToObject(XmlObject.class,
                str);
        System.out.println(xmlString);
    }
}