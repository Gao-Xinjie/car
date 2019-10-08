package com.tx652.stat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tx652.stat.domain.BaseEntity;
import com.tx652.stat.service.StatService;

/**
 * 统计分析
 * @author 高鑫杰
 *
 */
@RequestMapping("stat")
@Controller
public class StatController {
	
	@Autowired
	private StatService statService;
	/**
	 * 跳转到客户地区统计页面
	 */
	@RequestMapping("toCustomerStat")
	public String toCustomerAreaStat() {
		return "stat/customerAreaStat";
	}
	/**
	 * 加载客户地区数据
	 */
	@RequestMapping("loadCustomerAreaStatJosn")
	@ResponseBody
	public List<BaseEntity> loadCustomerAreaStatJosn(){
		return this.statService.loadCustomerAreaStatList();
	}
	
	
	/**
	 * 跳转到业务员年度统计页面
	 */
	@RequestMapping("toOpernameYearGradeStat")
	public String toOpernameYearGradeStat() {
		return "stat/opernameYearGradeStat";
	}
	
	/**
	 * 加载业务员年度统计数据
	 */
	@RequestMapping("loadOpernameYearGradeStat")
	@ResponseBody
	public Map<String,Object> opernameYearGradeStat(String year){
		List<BaseEntity> entities=this.statService.loadOpernameYearGradeStatList(year);
		Map<String,Object> map=new HashMap<String, Object>();
		List<String> names=new ArrayList<String>();
		List<Double> values=new ArrayList<Double>();
		for (BaseEntity baseEntity : entities) {
			names.add(baseEntity.getName());
			values.add(baseEntity.getValue());
		}
		map.put("name", names);
		map.put("value", values);
		return map;
	}
	
	
	/**
	 * 跳转到公司年度统计页面
	 */
	@RequestMapping("toCompanyYearGradeStat")
	public String toCompanyYearGradeStat() {
		return "stat/companyYearGradeStat";
	}
	
	/**
	 * 加载业务员年度统计数据
	 */
	@RequestMapping("loadCompanyYearGradeStat")
	@ResponseBody
	public List<Double> loadCompanyYearGradeStat(String year){
		List<Double> entities=this.statService.loadCompanyYearGradeStatList(year);
		for (int i = 0; i < entities.size(); i++) {
			if(null==entities.get(i)) {
				entities.set(i, 0.0);
			}
		}
		return entities;
	}

}
