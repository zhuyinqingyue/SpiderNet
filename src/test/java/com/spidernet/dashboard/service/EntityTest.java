package com.spidernet.dashboard.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spidernet.dashboard.entity.Bu;
import com.spidernet.dashboard.entity.CCapability;
import com.spidernet.dashboard.entity.CapabilityB;
import com.spidernet.dashboard.entity.CapabilityExam;
import com.spidernet.dashboard.entity.CapabilityTraining;
import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.entity.EmployeeDetl;
import com.spidernet.dashboard.entity.Exam;
import com.spidernet.dashboard.entity.ExamCapability;
import com.spidernet.dashboard.entity.Level;
import com.spidernet.dashboard.entity.PersonalExam;
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.entity.PersonalTrainning;
import com.spidernet.dashboard.entity.ProCapability;
import com.spidernet.dashboard.entity.Project;
import com.spidernet.dashboard.entity.Trainning;
import com.spidernet.dashboard.entity.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:conf/spring-mybatis.xml" })
public class EntityTest
{
    
    EntityTest entityTest;
    
    public static Map<String, String> getFieldValueMap(Object bean) {  
        Class<?> cls = bean.getClass();  
        Map<String, String> valueMap = new HashMap<String, String>();  
        Method[] methods = cls.getDeclaredMethods();  
        Field[] fields = cls.getDeclaredFields();  
        for (Field field : fields) {  
            try {  
                String fieldType = field.getType().getSimpleName();  
                String fieldGetName = parGetName(field.getName());  
                if (!checkGetMet(methods, fieldGetName)) {  
                    continue;  
                }  
                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});  
                Object fieldVal = fieldGetMet.invoke(bean, new Object[] {});  
                String result = null;  
                if ("Date".equals(fieldType)) {  
                    result = fmtDate((Date) fieldVal);  
                } else {  
                    if (null != fieldVal) {  
                        result = String.valueOf(fieldVal);  
                    }  
                }  
//              String fieldKeyName = parKeyName(field.getName());  
                valueMap.put(field.getName(), result);  
            } catch (Exception e) {  
                continue;  
            }  
        }  
        return valueMap;  
    }  
  
    
    public static void setFieldValue(Object bean, Map<String, String> valMap) {  
        Class<?> cls = bean.getClass();  
        Method[] methods = cls.getDeclaredMethods();  
        Field[] fields = cls.getDeclaredFields();  
  
        for (Field field : fields) {  
            try {  
                String fieldSetName = parSetName(field.getName());  
                if (!checkSetMet(methods, fieldSetName)) {  
                    continue;  
                }  
                Method fieldSetMet = cls.getMethod(fieldSetName,  
                        field.getType());  
//              String fieldKeyName = parKeyName(field.getName());  
                String  fieldKeyName = field.getName();  
                String value = valMap.get(fieldKeyName);  
                if (null != value && !"".equals(value)) {  
                    String fieldType = field.getType().getSimpleName();  
                    if ("String".equals(fieldType)) {  
                        fieldSetMet.invoke(bean, value);  
                    } else if ("Date".equals(fieldType)) {  
                        Date temp = parseDate(value);  
                        fieldSetMet.invoke(bean, temp);  
                    } else if ("Integer".equals(fieldType)  
                            || "int".equals(fieldType)) {  
                        Integer intval = Integer.parseInt(value);  
                        fieldSetMet.invoke(bean, intval);  
                    } else if ("Long".equalsIgnoreCase(fieldType)) {  
                        Long temp = Long.parseLong(value);  
                        fieldSetMet.invoke(bean, temp);  
                    } else if ("Double".equalsIgnoreCase(fieldType)) {  
                        Double temp = Double.parseDouble(value);  
                        fieldSetMet.invoke(bean, temp);  
                    } else if ("Boolean".equalsIgnoreCase(fieldType)) {  
                        Boolean temp = Boolean.parseBoolean(value);  
                        fieldSetMet.invoke(bean, temp);  
                    } else {  
                        System.out.println("not supper type" + fieldType);  
                    }  
                }  
            } catch (Exception e) {  
                continue;  
            }  
        }  
    }
    


    public static Date parseDate(String datestr) {  
        if (null == datestr || "".equals(datestr)) {  
            return null;  
        }  
        try {  
            String fmtstr = null;  
            if (datestr.indexOf(':') > 0) {  
                fmtstr = "yyyy-MM-dd HH:mm:ss";  
            } else {  
                fmtstr = "yyyy-MM-dd";  
            }  
            SimpleDateFormat sdf = new SimpleDateFormat(fmtstr, Locale.UK);  
            return sdf.parse(datestr);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  


    public static String fmtDate(Date date) {  
        if (null == date) {  
            return null;  
        }  
        try {  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",  
                    Locale.US);  
            return sdf.format(date);  
        } catch (Exception e) {  
            return null;  
        }  
    }  
  

  
    public static boolean checkSetMet(Method[] methods, String fieldSetMet) {  
        for (Method met : methods) {  
            if (fieldSetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false;  
    }  
  


    
    public static boolean checkGetMet(Method[] methods, String fieldGetMet) {  
        for (Method met : methods) {  
            if (fieldGetMet.equals(met.getName())) {  
                return true;  
            }  
        }  
        return false;  
    }  


    
    
    public static String parGetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        int startIndex = 0;  
        if (fieldName.charAt(0) == '_')  
            startIndex = 1;  
        return "get"  
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()  
                + fieldName.substring(startIndex + 1);  
    }  
  


    
    public static String parSetName(String fieldName) {  
        if (null == fieldName || "".equals(fieldName)) {  
            return null;  
        }  
        int startIndex = 0;  
        if (fieldName.charAt(0) == '_')  
            startIndex = 1;  
        return "set"  
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()  
                + fieldName.substring(startIndex + 1);  
    }  
  


    
    public static String parKeyName(String fieldName) {  
        String fieldGetName = parGetName(fieldName);  
        if (fieldGetName != null && fieldGetName.trim() != ""  
                && fieldGetName.length() > 3) {  
            return fieldGetName.substring(3);  
        }  
        return fieldGetName;  
    }  
    
    @Test
    public void testEntityBu(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("buId","1111111111");  
        map.put("buName","234252165");
        map.put("description","joe");  
        map.put("sort","1");
        map.put("contactNumber","ewqtrasd");  
        map.put("mangerName","123qer456");
        Bu bu = new Bu();
        entityTest.setFieldValue(bu, map);  
        Map<String, String> valueMap = entityTest.getFieldValueMap(bu);  
        
    }
    
    @Test
    public void testEntityCapabilityB(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("blockId","1111111111");  
        map.put("name","234252165");
        map.put("descipion","234");  
        map.put("sort","1");
        map.put("blockType","1");
        CapabilityB capabilityB = new CapabilityB();
        
        entityTest.setFieldValue(capabilityB, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(capabilityB);
        
    }
    
    
    
    @Test
    public void testEntityCapabilityExam(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("capabilityId","1111111111");  
        map.put("examId","234252165");
        CapabilityExam capabilityExam = new CapabilityExam();
        
        entityTest.setFieldValue(capabilityExam, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(capabilityExam);
        
    }
    
    @Test
    public void testEntityCapabilityTraining(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("capabilityId","1111111111");  
        map.put("trainingId","234252165");
        CapabilityTraining capabilityTraining = new CapabilityTraining();
        
        entityTest.setFieldValue(capabilityTraining, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(capabilityTraining);
        
    }
    
    @Test
    public void testEntityCCapability(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("commCapabilityId","1111111111");  
        map.put("blockId","234252165");
        map.put("name","1111111111");  
        map.put("description","234252165");
        map.put("sort","2");  
        map.put("url","234252165");
        map.put("parentId","1111111111");  
        map.put("buList","234252165");
        map.put("isExam","true");  
        map.put("isTraining","true");
        map.put("status","1111111111");  
        map.put("trainingStatus","234252165");
        CCapability cCapability = new CCapability();
        
        entityTest.setFieldValue(cCapability, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(cCapability);
        
    }
    
    
    @Test
    public void testEntityEmployee(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("employeeId","1111111111");  
        map.put("buId","234252165");
        map.put("projectId","1111111111");  
        map.put("empTypeId","234252165");
        map.put("empLevelId","1111111111");  
        map.put("erNumber","234252165");
        map.put("hrNumber","1111111111");  
        map.put("name","234252165");
        map.put("eName","1111111111");  
        map.put("password","234252165");
        map.put("wechatOpenId","1111111111");  
        Employee employee = new Employee();
        
        entityTest.setFieldValue(employee, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(employee);
        
    }
    
    @Test
    public void testEntityEmployeeDetl(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("empId","1111111111");  
        map.put("empName","234252165");
        map.put("buName","1111111111");  
        map.put("projectName","234252165");
        map.put("levelName","1111111111");  
        map.put("typeName","234252165");
        EmployeeDetl employeeDetl = new EmployeeDetl();
        
        entityTest.setFieldValue(employeeDetl, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(employeeDetl);
        
    }
    
    
    @Test
    public void testEntityExam(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("examId","1111111111");  
        map.put("buId","234252165");
        map.put("projetId","1111111111");  
        map.put("name","234252165");
        map.put("startTime","1111111111");  
        map.put("endTime","234252165");
        map.put("description","1111111111");  
        map.put("examTime","234252165");
        map.put("validPeriod","1");  
        map.put("status","234252165");
        map.put("knowledgeList","1111111111");  
        Exam exam = new Exam();
        
        entityTest.setFieldValue(exam, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(exam);
        
    }
    
    @Test
    public void testEntityExamCapability(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("examId","1111111111");  
        map.put("buName","234252165");
        map.put("projectName","1111111111");  
        map.put("examName","234252165");
        map.put("startTime","1111111111");  
        map.put("endTime","234252165");
        map.put("examTime","1111111111");  
        map.put("validPeriod","234252165");
        map.put("status","1");  
        ExamCapability examCapability = new ExamCapability();
        
        entityTest.setFieldValue(examCapability, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(examCapability);
        
    }
    
    @Test
    public void testEntityLevel(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("empLevelId","1111111111");  
        map.put("levelName","234252165");
        map.put("description","1111111111");  
        map.put("sort","234252165");
        Level level = new Level();
        
        entityTest.setFieldValue(level, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(level);
        
    }
    
    
    
    @Test
    public void testEntityPersonalExam(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("examId","1111111111");  
        map.put("employeeId","234252165");
        map.put("personalExam","1111111111");  
        map.put("status","234252165");
        map.put("registerTime","1111111111");  
        map.put("updateTime","234252165");
        PersonalExam personalExam = new PersonalExam();
        
        entityTest.setFieldValue(personalExam, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(personalExam);
        
    }
    
    
    @Test
    public void testEntityPersonalMap(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("personalMapId","1111111111");  
        map.put("proCapabilityId","234252165");
        map.put("commCapabilityId","1111111111");  
        map.put("employeeId","234252165");
        map.put("empTypeId","1111111111");  
        map.put("empLevelId","234252165");
        map.put("buId","234252165");
        map.put("projectId","1111111111");  
        map.put("detail","234252165");
        map.put("status","1111111111");  
        map.put("statusFlag","2");
        PersonalMap personalMap = new PersonalMap();
        
        entityTest.setFieldValue(personalMap, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(personalMap);
        
    }
    
    @Test
    public void testEntityPersonalTrainning(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("trainningId","1111111111");  
        map.put("employeeId","234252165");
        map.put("status","1111111111");  
        PersonalTrainning personalTrainning = new PersonalTrainning();
        
        entityTest.setFieldValue(personalTrainning, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(personalTrainning);
        
    }
    
    
    @Test
    public void testEntityProCapability(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("proCapabilityId","1111111111");  
        map.put("blockId","234252165");
        map.put("buId","1111111111");  
        map.put("projectId","234252165");
        map.put("empLevelId","1111111111");  
        map.put("name","234252165");
        map.put("description","234252165");
        map.put("sort","2");  
        map.put("url","234252165");
        map.put("empTypeId","1111111111");  
        map.put("isExam","true");
        map.put("isTraining","true");
        map.put("status","1111111111");  
        map.put("trainingStatus","234252165");
        ProCapability proCapability = new ProCapability();
        
        entityTest.setFieldValue(proCapability, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(proCapability);
        
    }
    
    
    @Test
    public void testEntityProject(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("projectId","1111111111");  
        map.put("buId","234252165");
        map.put("projectName","1111111111");  
        map.put("description","234252165");
        map.put("contactNumber","1111111111");  
        map.put("mangerName","234252165");
        map.put("projectStatus","234252165");
        Project project = new Project();
        
        entityTest.setFieldValue(project, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(project);
        
    }
    
    
    @Test
    public void testEntityTrainning(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("trainningId","1111111111");  
        map.put("courseName","234252165");
        map.put("time","1111111111");  
        map.put("location","234252165");
        map.put("teacher","1111111111");  
        map.put("url","234252165");
        map.put("status","234252165");
        Trainning trainning = new Trainning();
        
        entityTest.setFieldValue(trainning, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(trainning);
        
    }
    
    
    @Test
    public void testEntityType(){
        
        Map<String,String> map = new HashMap<String, String>();  
        map.put("empTypeId","1111111111");  
        map.put("typeName","234252165");
        map.put("sort","1111111111");  
        map.put("description","234252165");
        Type type = new Type();
        
        entityTest.setFieldValue(type, map);
        Map<String, String> valueMap = entityTest.getFieldValueMap(type);
        
    }
    

}
