package com.spidernet.dashboard.entity;

public class PersonalTrainning
{
    private String personalTrainningId;
    private String trainningId;
    private String employeeId;
    private String status;

    public String getPersonalTrainningId()
    {
        return personalTrainningId;
    }
    public void setPersonalTrainningId(String personalTrainningId)
    {
        this.personalTrainningId = personalTrainningId;
    }
    public String getTrainningId()
    {
        return trainningId;
    }
    public void setTrainningId(String trainningId)
    {
        this.trainningId = trainningId;
    }
    public String getEmployeeId()
    {
        return employeeId;
    }
    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }
    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
}
