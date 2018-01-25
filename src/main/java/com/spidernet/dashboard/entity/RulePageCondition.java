package com.spidernet.dashboard.entity;
/**
 * rule
 * @author Lulu
 *
 */

public class RulePageCondition extends PageCondition
{

    private String ruleName;
   
    public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public RulePageCondition()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public RulePageCondition(String ruleName)
    {
        super();
        this.ruleName = ruleName;
    }

    @Override
    public String toString()
    {
        return "RulePageCondition [ruleName=" + ruleName + "]";
    }

}
