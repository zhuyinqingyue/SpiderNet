package com.spidernet.dashboard.entity;

public class ExamInfo
{
    
    private String examId;
    
    private String examName;
    
    private String buName;
    
    private String projectName;
    
    private String startTime;

    public String getExamId()
    {
        return examId;
    }

    public void setExamId(String examId)
    {
        this.examId = examId;
    }

    public String getExamName()
    {
        return examName;
    }

    public void setExamName(String examName)
    {
        this.examName = examName;
    }

    public String getBuName()
    {
        return buName;
    }

    public void setBuName(String buName)
    {
        this.buName = buName;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public ExamInfo(String examId, String examName, String buName,
            String projectName, String startTime)
    {
        super();
        this.examId = examId;
        this.examName = examName;
        this.buName = buName;
        this.projectName = projectName;
        this.startTime = startTime;
    }

    public ExamInfo()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString()
    {
        return "ExamInfo [examId=" + examId + ", examName=" + examName
                + ", buName=" + buName + ", projectName=" + projectName
                + ", startTime=" + startTime + "]";
    }
    
    
}
