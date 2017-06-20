package com.spidernet.dashboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spidernet.dashboard.entity.CCapability;
import com.spidernet.dashboard.entity.CapabilityMap;
import com.spidernet.dashboard.entity.Employee;
import com.spidernet.dashboard.entity.ExcelImport;
import com.spidernet.dashboard.entity.PersonalExam;
import com.spidernet.dashboard.entity.PersonalMap;
import com.spidernet.dashboard.entity.ProCapability;
import com.spidernet.dashboard.service.CCapabilityService;
import com.spidernet.dashboard.service.CapabilityExamService;
import com.spidernet.dashboard.service.EmployeeService;
import com.spidernet.dashboard.service.PersonalExamService;
import com.spidernet.dashboard.service.PersonalMapService;
import com.spidernet.dashboard.service.ProCapabilityService;
import com.spidernet.util.Constants;
import com.spidernet.util.ExcelTool;
import com.spidernet.util.Utils;
import com.spidernet.util.XmlUtil;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/exam")
public class PersonalExamDetlController
{

    @Resource
    PersonalExamService personalExamService;

    @Resource
    CapabilityExamService capabilityExamService;

    @Resource
    CCapabilityService ccapabilityService;

    @Resource
    ProCapabilityService proCapabilityService;

    @Resource
    PersonalMapService personalMapService;
    
    @Resource
    private EmployeeService employeeService;

    private static Logger logger = LoggerFactory
            .getLogger(PersonalTrainningDetlController.class);

    @RequestMapping("/addPersonalExamDetl")
    @ResponseBody
    public Boolean addPersonalExamDetl(final HttpServletRequest request,
            final HttpServletResponse response)
    {

        logger.debug("Add the personal exam detail begin");

        ProCapability proCapability = null;
        CCapability commonCapability = null;
        PersonalMap personalMap = null;
        String capabilityId = null;
        Boolean addResultFlag = false;

        String employeeId = ((Employee) request.getSession()
                .getAttribute("employee")).getEmployeeId();
        String selectedExam = request.getParameter("selectedExamArray");

        JSONArray selectedExamArray = JSONArray.fromObject(selectedExam);

        List<PersonalExam> personalExamList = new ArrayList<PersonalExam>();

        PersonalExam personalExam = null;

        personalMap = personalMapService.fetchByEmpId(employeeId);

        String personalDetail = personalMap.getDetail();

        CapabilityMap capabilityMap = (CapabilityMap) XmlUtil
                .convertXmlStrToObject(CapabilityMap.class,
                        personalMap.getDetail());


        for (int i = 0; i < selectedExamArray.size(); i++)
        {
            personalExam = new PersonalExam();

            personalExam.setEmployeeId(employeeId);
            personalExam.setExamId(
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("examId").toString());
            personalExam.setPersonalExam(
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("examName").toString());
            personalExam.setRegisterTime(
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("startTime").toString());
            personalExam.setUpdateTime(
                    new JSONObject(selectedExamArray.get(i).toString())
                            .get("endTime").toString());
            personalExam.setStatus(
                    Constants.EXAM_STATUS_REGISTED);

            if(personalExamService.checkPersonalExamExists(personalExam)){
                return false;
            }

            personalExamList.add(personalExam);
        }

        if (personalExamList.size() > 0)
        {
            capabilityId = capabilityExamService
                    .fetchCapabilityIdByExamId(
                            personalExamList.get(0).getExamId());
        }

        commonCapability = ccapabilityService
                .fetchCommonCapabilty(capabilityId);

        proCapability = proCapabilityService
                .fetchProCapabilityByCapabilityId(capabilityId);

        for (int i = 0; i < capabilityMap.getCapabilityMap().size(); i++)
        {
            if (proCapability != null)
            {
                for (int j = 0; j < capabilityMap.getCapabilityMap().get(i)
                        .getProCapabilityL().size(); j++)
                {
                    if (proCapability.getProCapabilityId()
                            .equals(capabilityMap.getCapabilityMap().get(i)
                                    .getProCapabilityL().get(j)
                                    .getProCapabilityId()))
                    {
                        capabilityMap.getCapabilityMap().get(i)
                                .getProCapabilityL().get(j).setStatus(
                                        Constants.EXAM_STATUS_REGISTED);
                    }
                }
            }
            else if (commonCapability != null)
            {
                for (int j = 0; j < capabilityMap.getCapabilityMap().get(i)
                        .getcCapabilityL().size(); j++)
                {
                    if (commonCapability.getCommCapabilityId()
                            .equals(capabilityMap.getCapabilityMap().get(i)
                                    .getcCapabilityL().get(j)
                                    .getCommCapabilityId()))
                    {
                        capabilityMap.getCapabilityMap().get(i)
                                .getcCapabilityL().get(j).setStatus(
                                        Constants.EXAM_STATUS_REGISTED);
                    }
                }

            }
        }

        personalDetail = XmlUtil.convertToXml(capabilityMap);

        personalMap.setDetail(personalDetail);
        personalMapService.updatePersonalMap(personalMap);

        addResultFlag = personalExamService.addPersonalExam(personalExamList);

        return addResultFlag;

    }
    
    
    @RequestMapping("/importScore")
    public String importScore(final HttpServletRequest request,final HttpServletResponse response,
            @RequestParam("inputFile") MultipartFile inputFile) throws IOException
    {
        String fileName = Utils.getUUID();
        
        String filePath = "D:/Excel/"+fileName+".xls";
        
        boolean resultFlag = true;
        
        if (!inputFile.isEmpty()) {  
            File localFile = new File(filePath);  
            try {  
                inputFile.transferTo(localFile);  
            } catch (IllegalStateException e) {
                logger.error("[PersonalExamDetlController.importScore] exception",e);
            } catch (IOException e) {  
                logger.error("[PersonalExamDetlController.importScore] exception",e); 
            }
            
            String examId = request.getParameter("examDate");
            
            List<ExcelImport> excelList = ExcelTool.getAllByExcel(filePath);
            
            List<ExcelImport> excelImportList = new ArrayList();
            
            for(int i = 0;i < excelList.size()-1;i++){
                if(excelList.get(i).getEr().equals(excelList.get(i+1).getEr())){
                    if(Double.parseDouble(excelList.get(i).getScore())>Double.parseDouble(excelList.get(i+1).getScore())){
                        excelImportList.add(excelList.get(i));
                    }else{
                        excelImportList.add(excelList.get(i+1));
                    }
                    i++;
                }else{
                    excelImportList.add(excelList.get(i));
                    if(i == excelList.size()-2){
                        excelImportList.add(excelList.get(excelList.size()-1));
                    }
                }
            }
            
            PersonalExam personalExam = new PersonalExam();
            
            personalExam.setExamId(examId);
            
            
            
            for(int i = 0;i < excelImportList.size();i++){
                String employeeId = employeeService.fetchByErNumber(excelImportList.get(i).getEr()).getEmployeeId();
                
                personalExam.setEmployeeId(employeeId);
                
                if(Double.parseDouble(excelImportList.get(i).getScore()) >= Double.parseDouble(excelImportList.get(i).getPassingMark())){
                    personalExam.setStatus("0");
                }else{
                    personalExam.setStatus("1");
                }
                
                personalExam.setScore(excelImportList.get(i).getScore());
                
                resultFlag = personalExamService.updataScore(personalExam);
                if(!resultFlag){
                    break;
                }
            }   
            
            localFile.delete();
        }else{
            resultFlag = false;
        }
        
        String resultState = null;
        
        if(resultFlag){
            resultState = "1";
            request.getSession().setAttribute("resultState", resultState);
        }else{
            resultState = "2";
            request.getSession().setAttribute("resultState", resultState);
        }
        
        
        return "employee/scoreImport";
    }
    
    
    @RequestMapping("/updResultState")
    @ResponseBody
    public void updResultState(final HttpServletRequest request,final HttpServletResponse response)
    {
        String resultState = "0";
        request.getSession().setAttribute("resultState", resultState);
        System.out.println("resultState :"+request.getSession().getAttribute("resultState"));
    }

}