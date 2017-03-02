package com.spidernet.dashboard.entity;
/**
 * emp_level
 * @author nick
 *
 */
public class Level
{
    private String empLevelId;

    private String levelName;

    private String description;

    private String sort;

    public String getEmpLevelId()
    {
        return empLevelId;
    }

    public void setEmpLevelId(String empLevelId)
    {
        this.empLevelId = empLevelId;
    }

    public String getLevelName()
    {
        return levelName;
    }

    public void setLevelName(String levelName)
    {
        this.levelName = levelName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public Level()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString()
    {
        return "Level [empLevelId=" + empLevelId + ", levelName=" + levelName
                + ", description=" + description + ", sort=" + sort + "]";
    }





}
