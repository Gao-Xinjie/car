package com.tx652.sys.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tx652.sys.constast.SysConstast;
import com.tx652.sys.domain.User;
import com.tx652.sys.service.LogInfoService;
import com.tx652.sys.service.UserService;
import com.tx652.sys.utils.WebUtils;
import com.tx652.sys.vo.LogInfoVo;
import com.tx652.sys.vo.UserVo;


/*
 * 
 * 用户登陆控制器
 *
 */

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private LogInfoService logInfoService;
	/**
	 * 
	 * 跳转到登陆页面
	 */
	
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		
		return "/system/main/login";
	}
	
	/**
	 * 跳转到登陆页面
	 * 
	 */
	@RequestMapping("login")
	public String login(UserVo userVo,Model model) {
		User user = this.userService.login(userVo);
		if(null != user ) {
			//放到session
			WebUtils.getHttpSession().setAttribute("user", user);
			//记录登陆日志 向sys_login_log里面插入数据
			LogInfoVo logInfoVo = new LogInfoVo();
			logInfoVo.setLogintime(new Date());
			logInfoVo.setLoginname(user.getRealname()+"-"+user.getLoginname());
			logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());//自己的ip地址
			logInfoService.addLogInfo(logInfoVo);
			return "/system/main/index";
			
		}else {
			model.addAttribute("error", SysConstast.USER_LOGIN_REEOR_MSG);
			return "/system/main/login";
		}
	}
	
}
