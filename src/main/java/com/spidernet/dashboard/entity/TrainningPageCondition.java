package com.spidernet.dashboard.entity;

public class TrainningPageCondition extends PageCondition
{

    private String trainningName;

    public String getTrainningName()
    {
        return trainningName;
    }

    public void setTrainningName(String trainningName)
    {
        this.trainningName = trainningName;
    }

    public TrainningPageCondition()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public TrainningPageCondition(String trainningName)
    {
        super();
        this.trainningName = trainningName;
    }

    @Override
    public String toString()
    {
        return "TrainningPageCondition [trainningName=" + trainningName + "]";
    }

}
