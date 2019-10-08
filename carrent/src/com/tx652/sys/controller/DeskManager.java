package com.tx652.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 工作台的控制器
 * @author 高鑫杰
 *
 */

@Controller
@RequestMapping("desk")
public class DeskManager {

	/*
	 * 
	 * 跳转到工作台页面
	 */
	@RequestMapping("/toDeskManager")
	public String toDeskManager() {
			
		return "system/main/deskManager";
	}
	
	
}
