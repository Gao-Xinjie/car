package com.tx652.sys.utils;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tx652.sys.domain.Menu;
import com.tx652.sys.mapper.MenuMapper;

/**
 * 初始化菜单数据
 * @author LJH
 *
 */
public class TestDataSource {

	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		MenuMapper menuMapper = context.getBean(MenuMapper.class);
		
		List<Menu> queryAllMenu = menuMapper.queryAllMenu(new Menu());
		System.out.println(queryAllMenu.size());
		System.out.println(menuMapper);
		System.out.println("初始化完成");
		
	}
}
