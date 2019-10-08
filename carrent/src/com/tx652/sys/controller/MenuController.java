package com.tx652.sys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.sys.constast.SysConstast;
import com.tx652.sys.domain.Menu;
import com.tx652.sys.domain.User;
import com.tx652.sys.service.MenuService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.ResultObj;
import com.tx652.sys.utils.TreeNode;
import com.tx652.sys.utils.TreeNodeBuilder;
import com.tx652.sys.utils.WebUtils;
import com.tx652.sys.vo.MenuVo;

/**
 * 
 * 菜单管理控制器
 * @author 高鑫杰
 *
 */

@RestController
@RequestMapping("menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	
	
	@RequestMapping("/loadIndexLeftMenuJson")
	public List<TreeNode> loadIndexLeftMenuJson(MenuVo menuVo){
		//得到当前登陆的用户对象		
		User user = (User) WebUtils.getHttpSession().getAttribute("user");
		List<Menu> list = null;
		menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
		if(user.getType()==SysConstast.USER_TYPE_SUPER) {//如果用户是超级用户
			list = menuService.queryAllMenuForList(menuVo);
				menuVo.setAvailable(SysConstast.AVAILABLE_TRUE);//只查询可用的
		}else {//如果不是超级用户就是按照用户的id去查询
			list= menuService.queryMenuByUserIdForList(menuVo, user.getUserid());
		}
		//把list里边的数据放到nodes里边
		List<TreeNode> nodes = new ArrayList<>();
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid=menu.getPid();
			String title= menu.getTitle();
			String icon= menu.getIcon();
			String href= menu.getHref();
			Boolean spread= menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			String target= menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		
		Integer topPid=1;
		return TreeNodeBuilder.builder(nodes, topPid);
	}

	
	@RequestMapping("loadMenuManagerLeftTreeJson")
	public DataGridView loadMenuManagerLeftTreeJson(MenuVo menuVo){
		List<Menu> list=this.menuService.queryAllMenuForList(menuVo);
		List<TreeNode> nodes = new ArrayList<>();
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid=menu.getPid();
			String title= menu.getTitle();
			String icon= menu.getIcon();
			String href= menu.getHref();
			Boolean spread= menu.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			String target= menu.getTarget();
			nodes.add(new TreeNode(id, pid, title, icon, href, spread, target));
		}
		return new DataGridView(nodes);
	}
	
	@RequestMapping("loadAllMenu")
	public DataGridView loadAllMenu(MenuVo menuVo) {
		return this.menuService.queryAllmenu(menuVo);
	}
	/**
	 * 
	 * 添加菜单
	 */
	@RequestMapping("addMenu")
	public ResultObj addMenu(MenuVo menuVo) {
		
		try {
			this.menuService.addMenu(menuVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * 
	 * 修改
	 */
	
	@RequestMapping("updateMenu")
	public ResultObj updateMenu(MenuVo menuVo) {
		
		try {
			this.menuService.updateMenu(menuVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.UPDATE_ERROR;
		}
	}
	
	/**
	 * 
	 * 根据当前id判断当前菜单有没有子节点
	 * 有返回code>=0 没有返回code<0
	 */
	@RequestMapping("checkMenuHasChildren")
	public ResultObj checkMenuHasChildren(MenuVo menuVo){
		//跟据我们的pid去查询菜单条数
		Integer count=this.menuService.queryMneuByPid(menuVo.getId());
		if(count>0) {
			return ResultObj.STASTUS_TRUE;
			
		}else {
			return ResultObj.STASTUS_ERROR;
		}
		
	}
	
	/**
	 * 
	 * 删除
	 */
	
	@RequestMapping("deleteMenu")
	public ResultObj delete(MenuVo menuVo) {
		
		try {
			this.menuService.deleteMenu(menuVo);
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
	
	
}
