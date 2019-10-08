package com.tx652.sys.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.tx652.sys.domain.News;

public class NewsVo extends News {

	    //接受多个id
		private Integer [] Ids;
		//分页数据
		private Integer page;
		private Integer limit;
		//扩展时间参数
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date startTime;
		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private Date endTime;
		
		
		
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
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
