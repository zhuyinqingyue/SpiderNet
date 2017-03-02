package com.spidernet.dashboard.entity;
/**
 * emp_type
 * @author nick
 *
 */

public class Type
{

    private String empTypeId;

    private String typeName;

    private String sort;

    private String description;

    public String getEmpTypeId()
    {
        return empTypeId;
    }

    public void setEmpTypeId(String empTypeId)
    {
        this.empTypeId = empTypeId;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Type()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString()
    {
        return "Type [empTypeId=" + empTypeId + ", typeName=" + typeName
                + ", sort=" + sort + ", description=" + description + "]";
    }




}
