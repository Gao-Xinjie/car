package com.tx652.bus.vo;

import com.tx652.bus.domain.Car;

public class CarVo extends  Car{

	
		//接受多个的id
		private String [] Ids;
		//分页数据
		private Integer page;
		private Integer limit;
		
		
		
		
		public String[] getIds() {
			return Ids;
		}
		public void setIds(String[] Ids) {
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
