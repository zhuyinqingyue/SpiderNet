package com.spidernet.dashboard.entity;

public class PersonalExam
{
    
    private String examId;
    
    private String employeeId;
    
    private String personalExam;
    
    private String status;
    
    private String registerTime;
    
    private String updateTime;

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

    public PersonalExam()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString()
    {
        return "PersonalExam [examId=" + examId + ", employeeId=" + employeeId
                + ", personalExam=" + personalExam + ", status=" + status
                + ", registerTime=" + registerTime + ", updateTime="
                + updateTime + "]";
    }
    
    

}
