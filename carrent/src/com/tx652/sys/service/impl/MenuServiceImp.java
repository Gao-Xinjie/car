package com.tx652.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tx652.sys.domain.Menu;
import com.tx652.sys.mapper.MenuMapper;
import com.tx652.sys.service.MenuService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.vo.MenuVo;


@Service
public class MenuServiceImp implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	
	@Override
	public List<Menu> queryAllMenuForList(MenuVo menuVo) {
		
		
		return menuMapper.queryAllMenu(menuVo);
	}

	
	/**
	 * 根据用户id查询菜单
	 */
	@Override
	public List<Menu> queryMenuByUserIdForList(MenuVo menuVo, Integer userId) {
		return menuMapper.queryMenuByUid(menuVo.getAvailable(),userId);
	}


	@Override
	public DataGridView queryAllmenu(MenuVo menuVo) {
		Page<Object> page = PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
		List<Menu> data = this.menuMapper.queryAllMenu(menuVo);
		
		return new DataGridView(page.getTotal(),data);
	}


	@Override
	public void addMenu(MenuVo menuVo) {
		
		this.menuMapper.insertSelective(menuVo);
	}


	@Override
	public void updateMenu(MenuVo menuVo) {
		this.menuMapper.updateByPrimaryKey(menuVo);
	}


	@Override
	public Integer queryMneuByPid(Integer pid) {
		
		return this.menuMapper.queryMenuByPid(pid);
	}


	@Override
	public void deleteMenu(MenuVo menuVo) {
		//删除菜单表的数据
		this.menuMapper.deleteByPrimaryKey(menuVo.getId());
		//根据菜单id删除sys_role_menu里面的数据
		this.menuMapper.deleteRoleMenuByMid(menuVo.getId());
	}

}
