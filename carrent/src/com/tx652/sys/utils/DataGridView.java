package com.tx652.sys.utils;
/**
 * 封装layui数据表格的数据对象
 * @author 高鑫杰
 *
 */
public class DataGridView {

	private Integer code=0;
	private String msg="";
	private Long count;
	private Object data;
	
	
	public DataGridView(Object data) {
		super();
		this.data = data;
	}
	
	public DataGridView(Long count, Object data) {
		super();
		this.count = count;
		this.data = data;
	}

	public DataGridView() {
		super();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
