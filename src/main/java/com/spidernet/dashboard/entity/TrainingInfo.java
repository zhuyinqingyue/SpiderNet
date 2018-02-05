package com.spidernet.dashboard.entity;

public class TrainingInfo
{
    
    private String er;
    private String hr;
    private String name;
    private String eName;
    private String buName;
    private String projectName;
    private String trainingName;
    private String knowledgePoint;
    private String subKnowledgePoint;
    
    public String getSubKnowledgePoint() {
		return subKnowledgePoint;
	}
	public void setSubKnowledgePoint(String subKnowledgePoint) {
		this.subKnowledgePoint = subKnowledgePoint;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
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
	public TrainingInfo(String er, String hr, String name, String eName,
            String buName, String projectName, String trainingName, String knowledgePoint, String subKnowledgePoint)
    {
        super();
        this.er = er;
        this.hr = hr;
        this.name = name;
        this.eName=eName;
        this.buName = buName;
        this.projectName=projectName;
        this.trainingName=trainingName;
        this.knowledgePoint=knowledgePoint;
        this.subKnowledgePoint=subKnowledgePoint;
        
    }
    public String getKnowledgePoint() {
		return knowledgePoint;
	}
	public void setKnowledgePoint(String knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}
	public TrainingInfo()
    {
        super();
    }
    
    
    
}
