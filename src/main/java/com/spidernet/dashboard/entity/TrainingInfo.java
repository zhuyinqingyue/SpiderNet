package com.spidernet.dashboard.entity;

public class TrainingInfo
{
    
    private String er;
    private String hr;
    private String name;
    private String buName;
    
	public String getEr() {
		return er;
	}
	public void setEr(String er) {
		this.er = er;
	}
	public String getHr() {
		return hr;
	}
	public void setHr(String hr) {
		this.hr = hr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBuName() {
		return buName;
	}
	public void setBuName(String buName) {
		this.buName = buName;
	}
	public TrainingInfo(String er, String hr, String name,
            String buName)
    {
        super();
        this.er = er;
        this.hr = hr;
        this.name = name;
        this.buName = buName;
    }
    public TrainingInfo()
    {
        super();
    }
    
    
    
}
