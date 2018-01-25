package com.spidernet.dashboard.entity;
/**
 * rule
 * @author Lulu
 *
 */

public class Rule
{

    private String id;

    private String name;

    private String sort;

    private String remark;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Rule()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString()
    {
        return "Type [id=" + id + ", name=" + name
                + ", sort=" + sort + ", remark=" + remark + "]";
    }

}
