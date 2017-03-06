package com.spidernet.dashboard.entity;

public class Exam
{
    private String examId;
    private String buId;
    private String projetId;
    private String name;
    private String startTime;
    private String endTime;
    private String description;
    private String examTime;
    private int validPeriod;
    private String status;
    private String knowledgeList;

    public String getExamId()
    {
        return examId;
    }
    public void setExamId(String examId)
    {
        this.examId = examId;
    }
    public String getBuId()
    {
        return buId;
    }
    public void setBuId(String buId)
    {
        this.buId = buId;
    }
    public String getProjetId()
    {
        return projetId;
    }
    public void setProjetId(String projetId)
    {
        this.projetId = projetId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getStartTime()
    {
        return startTime;
    }
    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }
    public String getEndTime()
    {
        return endTime;
    }
    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getExamTime()
    {
        return examTime;
    }
    public void setExamTime(String examTime)
    {
        this.examTime = examTime;
    }
    public int getValidPeriod()
    {
        return validPeriod;
    }
    public void setValidPeriod(int validPeriod)
    {
        this.validPeriod = validPeriod;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public String getKnowledgeList()
    {
        return knowledgeList;
    }
    public void setKnowledgeList(String knowledgeList)
    {
        this.knowledgeList = knowledgeList;
    }
}
