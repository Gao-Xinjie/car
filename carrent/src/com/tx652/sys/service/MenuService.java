package com.tx652.sys.service;

import java.util.List;

import com.tx652.sys.domain.Menu;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.vo.MenuVo;

/**
 * 
 * 菜单管理的服务接口
 * @author 高鑫杰
 *
 */


public interface MenuService {

	/**
	 * 查询所有菜单
	 * 返回list<Menu>
	 */
	
	public List<Menu> queryAllMenuForList(MenuVo menuVo);
	
	/**
	 * 
	 * 根据用户的idc查询用户的可用菜单
	 */
	
	public  List<Menu> queryMenuByUserIdForList(MenuVo menuVo,	Integer userId);
	
	
	/**
	 * 
	 * 查询所有菜单
	 * @param menuVo
	 * @return
	 */
	public DataGridView queryAllmenu(MenuVo menuVo);
	/**
	 * 
	 * 添加菜单
	 * @param menuVo
	 */
	public void addMenu(MenuVo menuVo);

	/**
	 * 修改菜单
	 * @param menuVo
	 */
	public void updateMenu(MenuVo menuVo);
	/**
	 * 根据Pid查询菜单数量
	 * @param menuVo
	 */

	public Integer queryMneuByPid(Integer pid);
	/**
	 * 
	 * 根据id删除菜单
	 * @param menuVo
	 */
	public void deleteMenu(MenuVo menuVo);
	
	
}
