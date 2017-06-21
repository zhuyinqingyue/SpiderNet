package com.spidernet.dashboard.entity;

public class ExamPageCondition extends PageCondition
{
    
    private String examId;
    
    private String examName;
    
    private String buId;
    
    private String projectId;

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

    public String getBuId()
    {
        return buId;
    }

    public void setBuId(String buId)
    {
        this.buId = buId;
    }

    public String getProjectId()
    {
        return projectId;
    }

    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public ExamPageCondition()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public ExamPageCondition(String examId, String examName, String buId,
            String projectId)
    {
        super();
        this.examId = examId;
        this.examName = examName;
        this.buId = buId;
        this.projectId = projectId;
    }

    @Override
    public String toString()
    {
        return "ExamPageCondition [examId=" + examId + ", examName=" + examName
                + ", buId=" + buId + ", projectId=" + projectId + "]";
    }
    
}
