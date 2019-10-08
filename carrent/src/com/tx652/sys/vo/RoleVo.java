package com.tx652.sys.vo;

import com.tx652.sys.domain.Role;

public class RoleVo extends Role {
	
	
	//接受多个角色的id
	private Integer [] Ids;
	//分页数据
	private Integer page;
	private Integer limit;
	
	
	
	
	public Integer[] getIds() {
		return Ids;
	}
	public void setIds(Integer[] Ids) {
		this.Ids = Ids;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
}
