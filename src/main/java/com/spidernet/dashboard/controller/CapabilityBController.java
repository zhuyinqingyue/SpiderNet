package com.spidernet.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spidernet.dashboard.entity.CCapability;
import com.spidernet.dashboard.entity.CapabilityB;
import com.spidernet.dashboard.entity.CapabilityMap;
import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.entity.ProCapability;
import com.spidernet.dashboard.service.CCapabilityService;
import com.spidernet.dashboard.service.CapabilityBService;
import com.spidernet.dashboard.service.EmployeeService;
import com.spidernet.dashboard.service.PersonalMapService;
import com.spidernet.dashboard.service.ProCapabilityService;
import com.spidernet.util.Constants;
import com.spidernet.util.Utils;
import com.spidernet.util.XmlUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("/capability")
@Controller
public class CapabilityBController
{
    private static Logger logger = LoggerFactory.getLogger(BuController.class);

    @Resource
    CapabilityBService capabilityBService;

    @Resource
    CCapabilityService cCapabilityService;

    @Resource
    ProCapabilityService proCapabilityService;

    @Resource
    EmployeeService userService;
    
    @Resource
    PersonalMapService personalMapService;
    
    @RequestMapping("/viewCCapability")
    @ResponseBody
    public CapabilityMap viewCCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.debug("---------viewCapabilityB is begin!----------");

        CapabilityMap capabilityMap = new CapabilityMap();
        String buId = request.getParameter("buId");
        String projectId = request.getParameter("projectId");
        String empLevelId = request.getParameter("empLevelId");
        String empTypeId = request.getParameter("empTypeId");
        List<CCapability> cCapabilityL = null;
        List<ProCapability> proCapabilityL = null;
        List<CapabilityB> capabilityBL = capabilityBService.viewCapabilityB();
        for (int i = 0; i < capabilityBL.size(); i++)
        {
            CapabilityB block = capabilityBL.get(i);
            if (Constants.ONE == capabilityBL.get(i).getBlockType())
            {
                proCapabilityL = proCapabilityService.viewProCapability(
                        capabilityBL.get(i).getBlockId(), buId, projectId,
                        empLevelId, empTypeId);

                block.setProCapabilityL(proCapabilityL);
            }

            if (Constants.TWO == capabilityBL.get(i).getBlockType())
            {
                cCapabilityL = cCapabilityService.viewCCapability(
                        capabilityBL.get(i).getBlockId(), buId);
                block.setcCapabilityL(cCapabilityL);
            }
            capabilityMap.getCapabilityMap().add(block);
        }

        return capabilityMap;
    }
    
    
    @RequestMapping("/viewComCapability")
    @ResponseBody
    public CapabilityMap viewComCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.debug("---------viewCapabilityB is begin!----------");

        CapabilityMap capabilityMap = new CapabilityMap();
        String buId = request.getParameter("buId");
        List<CCapability> cCapabilityL = null;
        List<ProCapability> proCapabilityL = null;
        List<CapabilityB> capabilityBL = capabilityBService.viewCapabilityB();
        for (int i = 0; i < capabilityBL.size(); i++)
        {
            CapabilityB block = capabilityBL.get(i);
           
            if (Constants.TWO == capabilityBL.get(i).getBlockType())
            {
                cCapabilityL = cCapabilityService.viewCCapability(
                        capabilityBL.get(i).getBlockId(), buId);
                block.setcCapabilityL(cCapabilityL);
            }
            capabilityMap.getCapabilityMap().add(block);
        }

        return capabilityMap;
    }
    

    @RequestMapping("/regCapability")
    @ResponseBody
    public Boolean regCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.debug("---------regCapability is begin!----------");
        Boolean reg = false;
        Boolean saveC = false;
        
        Employee employeeTemp = new Employee();
        PersonalMap personalMapTemp = new PersonalMap();
        String saveHtml = request.getParameter("CapabilityMap");
        String buId = request.getParameter("buId");
        String projectId = request.getParameter("projectId");
        String empLevelId = request.getParameter("empLevelId");
        String empTypeId = request.getParameter("empTypeId");
        String erId = request.getParameter("erId");
        String hrId = request.getParameter("hrId");
        String name = request.getParameter("name");
        String ename = request.getParameter("ename");
        CapabilityB cBBean = new CapabilityB();
        CCapability cCBean = new CCapability();
        ProCapability pCBean = new ProCapability();
        CapabilityMap cMBean = new CapabilityMap();
        List<CapabilityB> capabilityMap = new ArrayList<CapabilityB>();
        
        JSONArray capabilityMapJ = JSONArray.fromObject(saveHtml);


        for (Object capabilityB : capabilityMapJ)
        {
            JSONObject capabilityBJ = JSONObject.fromObject(capabilityB);

            cBBean = (CapabilityB) JSONObject.toBean(capabilityBJ,
                    CapabilityB.class);
            if (null != cBBean.getProCapabilityL()
                    && Constants.ONE == cBBean.getBlockType())
            {
                JSONArray proCapabilityLJ = JSONArray
                        .fromObject(cBBean.getProCapabilityL());
                List<ProCapability> proCapabilityL = new ArrayList<ProCapability>();
                for (Object proCapability : proCapabilityLJ)
                {
                    JSONObject proCapabilityJ = JSONObject
                            .fromObject(proCapability);
                    pCBean = (ProCapability) JSONObject.toBean(proCapabilityJ,
                            ProCapability.class);
                    if (pCBean.getBlockId().equals(cBBean.getBlockId()))
                    {
                        proCapabilityL.add(pCBean);
                    }
                }
                cBBean.setProCapabilityL(proCapabilityL);
            }

            if (null != cBBean.getcCapabilityL()
                    && Constants.TWO == cBBean.getBlockType())
            {
                JSONArray cCapabilityLJ = JSONArray
                        .fromObject(cBBean.getcCapabilityL());
                List<CCapability> cCapabilityL = new ArrayList<CCapability>();
                for (Object cCapability : cCapabilityLJ)
                {
                    JSONObject cCapabilityJ = JSONObject
                            .fromObject(cCapability);
                    cCBean = (CCapability) JSONObject.toBean(cCapabilityJ,
                            CCapability.class);
                    if (cCBean.getBlockId().equals(cCBean.getBlockId()))
                    {
                        cCapabilityL.add(cCBean);
                    }
                }
                cBBean.setcCapabilityL(cCapabilityL);
            }

            capabilityMap.add(cBBean);
        }
        cMBean.setCapabilityMap(capabilityMap);
        String capabilityStr = XmlUtil.convertToXml(cMBean);
        String uuid = Utils.getUUID();
        employeeTemp.setEmployeeId(uuid);
        employeeTemp.setErNumber(erId);
        employeeTemp.setHrNumber(hrId);
        employeeTemp.setName(name);
        employeeTemp.seteName(ename);
        employeeTemp.setEmpLevelId(empLevelId);
        employeeTemp.setEmpTypeId(empTypeId);
        employeeTemp.setBuId(buId);
        employeeTemp.setProjectId(projectId);
        
        if(!(userService.checkErExists(erId)||userService.checkHrExists(hrId))){
            return false;
        }
        reg = userService.addEmployee(employeeTemp);
        
        personalMapTemp.setPersonalMapId(uuid);
        personalMapTemp.setBuId(buId);
        personalMapTemp.setProjectId(projectId);
        personalMapTemp.setEmployeeId(employeeTemp.getEmployeeId());
        personalMapTemp.setEmpTypeId(empTypeId);
        personalMapTemp.setEmpLevelId(empLevelId);
        personalMapTemp.setDetail(capabilityStr);
        personalMapTemp.setStatusFlag(1);
        personalMapTemp.setStatus("");
        
        saveC = personalMapService.addPersonalMap(personalMapTemp);
        
        if (reg == true && saveC == true)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    
    @RequestMapping("/updCapability")
    @ResponseBody
    public Boolean updCapability(final HttpServletRequest request,
            final HttpServletResponse response)
    {
        logger.debug("---------updCapability is begin!----------");
        Boolean reg = false;
        Boolean saveC = false;
        
        Employee employeeTemp = new Employee();
        PersonalMap personalMapTemp = new PersonalMap();
        String saveHtml = request.getParameter("CapabilityMap");
        String buId = request.getParameter("buId");
        String projectId = request.getParameter("projectId");
        String empLevelId = request.getParameter("empLevelId");
        String empTypeId = request.getParameter("empTypeId");
        String erId = request.getParameter("erId");
        String hrId = request.getParameter("hrId");
        String name = request.getParameter("name");
        String ename = request.getParameter("ename");
        CapabilityB cBBean = new CapabilityB();
        CCapability cCBean = new CCapability();
        ProCapability pCBean = new ProCapability();
        CapabilityMap cMBean = new CapabilityMap();
        List<CapabilityB> capabilityMap = new ArrayList<CapabilityB>();
        
        JSONArray capabilityMapJ = JSONArray.fromObject(saveHtml);


        for (Object capabilityB : capabilityMapJ)
        {
            JSONObject capabilityBJ = JSONObject.fromObject(capabilityB);

            cBBean = (CapabilityB) JSONObject.toBean(capabilityBJ,
                    CapabilityB.class);
            if (null != cBBean.getProCapabilityL()
                    && Constants.ONE == cBBean.getBlockType())
            {
                JSONArray proCapabilityLJ = JSONArray
                        .fromObject(cBBean.getProCapabilityL());
                List<ProCapability> proCapabilityL = new ArrayList<ProCapability>();
                for (Object proCapability : proCapabilityLJ)
                {
                    JSONObject proCapabilityJ = JSONObject
                            .fromObject(proCapability);
                    pCBean = (ProCapability) JSONObject.toBean(proCapabilityJ,
                            ProCapability.class);
                    if (pCBean.getBlockId().equals(cBBean.getBlockId()))
                    {
                        proCapabilityL.add(pCBean);
                    }
                }
                cBBean.setProCapabilityL(proCapabilityL);
            }

            if (null != cBBean.getcCapabilityL()
                    && Constants.TWO == cBBean.getBlockType())
            {
                JSONArray cCapabilityLJ = JSONArray
                        .fromObject(cBBean.getcCapabilityL());
                List<CCapability> cCapabilityL = new ArrayList<CCapability>();
                for (Object cCapability : cCapabilityLJ)
                {
                    JSONObject cCapabilityJ = JSONObject
                            .fromObject(cCapability);
                    cCBean = (CCapability) JSONObject.toBean(cCapabilityJ,
                            CCapability.class);
                    if (cCBean.getBlockId().equals(cCBean.getBlockId()))
                    {
                        cCapabilityL.add(cCBean);
                    }
                }
                cBBean.setcCapabilityL(cCapabilityL);
            }

            capabilityMap.add(cBBean);
        }
        cMBean.setCapabilityMap(capabilityMap);
        String capabilityStr = XmlUtil.convertToXml(cMBean);
        
        employeeTemp.setErNumber(erId);
        employeeTemp.setName(name);
        employeeTemp.seteName(ename);
        employeeTemp.setEmpLevelId(empLevelId);
        employeeTemp.setEmpTypeId(empTypeId);
        employeeTemp.setBuId(buId);
        employeeTemp.setProjectId(projectId);
        
        
        reg = userService.updEmployee(employeeTemp);
        
        String employeeId = userService.fetchByErNumber(erId).getEmployeeId();
        
        String personalMapId = personalMapService.findPersonalMapIdByEmpId(employeeId);
        
        
        if(capabilityStr!=null&&capabilityStr!=""){
            personalMapTemp.setPersonalMapId(personalMapId);
            personalMapTemp.setBuId(buId);
            personalMapTemp.setProjectId(projectId);
            personalMapTemp.setEmpTypeId(empTypeId);
            personalMapTemp.setEmpLevelId(empLevelId);
            personalMapTemp.setDetail(capabilityStr);
            
            saveC = personalMapService.updatePersonalMap(personalMapTemp);
        
        }
        
        if (reg == true || saveC == true)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
