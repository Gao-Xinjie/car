package com.tx652.sys.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tx652.sys.domain.Menu;
import com.tx652.sys.mapper.MenuMapper;


/*
 * 
 * 初始化菜单数据
 */
public class InitMenuData {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		
		MenuMapper menuMapper = ctx.getBean(MenuMapper.class);
		
	}
}
