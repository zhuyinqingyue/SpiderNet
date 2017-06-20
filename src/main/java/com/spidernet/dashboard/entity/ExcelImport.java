package com.spidernet.dashboard.entity;

public class ExcelImport
{
    
    private String name;
    
    private String er;
    
    private String score;
    
    private String passingMark;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEr()
    {
        return er;
    }

    public void setEr(String er)
    {
        this.er = er;
    }

    public String getScore()
    {
        return score;
    }

    public void setScore(String score)
    {
        this.score = score;
    }

    public String getPassingMark()
    {
        return passingMark;
    }

    public void setPassingMark(String passingMark)
    {
        this.passingMark = passingMark;
    }

    public ExcelImport(String name, String er, String score, String passingMark)
    {
        super();
        this.name = name;
        this.er = er;
        this.score = score;
        this.passingMark = passingMark;
    }

    public ExcelImport()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString()
    {
        return "ExcelImport [name=" + name + ", er=" + er + ", score=" + score
                + ", passingMark=" + passingMark + "]";
    }
    
    

}
