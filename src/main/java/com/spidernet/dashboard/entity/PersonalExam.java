package com.spidernet.dashboard.entity;

public class PersonalExam
{
    
    private String examId;
    
    private String employeeId;
    
    private String personalExam;
    
    private String status;
    
    private String registerTime;
    
    private String updateTime;
    
    private String score;

    public String getExamId()
    {
        return examId;
    }

    public void setExamId(String examId)
    {
        this.examId = examId;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getPersonalExam()
    {
        return personalExam;
    }

    public void setPersonalExam(String personalExam)
    {
        this.personalExam = personalExam;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getRegisterTime()
    {
        return registerTime;
    }

    public void setRegisterTime(String registerTime)
    {
        this.registerTime = registerTime;
    }

    public String getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }

    public String getScore()
    {
        return score;
    }

    public void setScore(String score)
    {
        this.score = score;
    }

    public PersonalExam()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public PersonalExam(String examId, String employeeId, String personalExam,
            String status, String registerTime, String updateTime, String score)
    {
        super();
        this.examId = examId;
        this.employeeId = employeeId;
        this.personalExam = personalExam;
        this.status = status;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
        this.score = score;
    }

    @Override
    public String toString()
    {
        return "PersonalExam [examId=" + examId + ", employeeId=" + employeeId
                + ", personalExam=" + personalExam + ", status=" + status
                + ", registerTime=" + registerTime + ", updateTime="
                + updateTime + ", score=" + score + "]";
    }

    
    

}
