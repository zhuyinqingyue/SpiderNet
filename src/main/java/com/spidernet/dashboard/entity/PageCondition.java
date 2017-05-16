package com.spidernet.dashboard.entity;

public class PageCondition
{
    
    private String er;
    
    private String buId;
    
    private String projectId;
    
    private String currentPage;
    
    private String pageCount;


    public String getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(String currentPage)
    {
        this.currentPage = currentPage;
    }

    public String getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(String pageCount)
    {
        this.pageCount = pageCount;
    }


    
    
}
