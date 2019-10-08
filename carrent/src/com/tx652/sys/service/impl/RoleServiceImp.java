package com.tx652.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tx652.sys.constast.SysConstast;
import com.tx652.sys.domain.Menu;
import com.tx652.sys.domain.Role;
import com.tx652.sys.mapper.MenuMapper;
import com.tx652.sys.mapper.RoleMapper;
import com.tx652.sys.service.RoleService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.TreeNode;
import com.tx652.sys.vo.RoleVo;


@Service
public class RoleServiceImp implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private MenuMapper menuMapper;
	
	
	
	@Override
	public List<Role> queryAllRoleForList(RoleVo roleVo) {
		
		
		return roleMapper.queryAllRole(roleVo);
	}

	
	/**
	 * 后期权限管理完成之后再来改
	 */
	@Override
	public List<Role> queryRoleByUserIdForList(RoleVo roleVo, Integer userId) {
		return roleMapper.queryAllRole(roleVo);
	}


	@Override
	public DataGridView queryAllrole(RoleVo roleVo) {
		Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
		List<Role> data = this.roleMapper.queryAllRole(roleVo);
		
		return new DataGridView(page.getTotal(),data);
	}


	@Override
	public void addRole(RoleVo roleVo) {
		
		this.roleMapper.insertSelective(roleVo);
	}


	@Override
	public void updateRole(RoleVo roleVo) {
		this.roleMapper.updateByPrimaryKey(roleVo);
	}


	@Override
	public void deleteRole(Integer roleid) {
		//删除角色表的数据
		this.roleMapper.deleteByPrimaryKey(roleid);
		//根据角色id删除sys_role_menu里面的数据
		this.roleMapper.deleteRoleMenuByRid(roleid);
		//根据角色id删除sys_role_user里面的数据
		this.roleMapper.deleteRoleUserByRid(roleid);
	}

	@Override
	public void deleteBatchRole(Integer[] ids) {
		for (Integer rid : ids) {
			deleteRole(rid);
		}
		
	}


	@Override
	public DataGridView initRoleMenuTreeJson(Integer roleid) {
		//查询所有的可用菜单
		Menu menu =new Menu();
		menu.setAvailable(SysConstast.AVAILABLE_TRUE);
		//查询所有的菜单
		List<Menu> allMenu = menuMapper.queryAllMenu(menu);
		//根据角色Id查询当前角色拥有的菜单
		List<Menu> roleMenu = menuMapper.queryMenuByRoleId(SysConstast.AVAILABLE_TRUE,roleid);
		List<TreeNode> data = new ArrayList<>();
		for (Menu m1 : allMenu) {
			String checkArr = SysConstast.CODE_ZERO+"";
			for (Menu m2 : roleMenu) {
				if(m1.getId() == m2.getId()) {
					checkArr = SysConstast.CODE_ONE+"";
					break;
				}
			}
			Integer id = m1.getId();
			Integer pid=m1.getPid();
			String title= m1.getTitle();
			Boolean spread= m1.getSpread()==SysConstast.SPREAD_TRUE?true:false;
			data.add(new TreeNode(id, pid, title, spread, checkArr));
		}

		return new DataGridView(data);
	}


	@Override
	public void saveRoleMenu(RoleVo roleVo) {
		
		
		Integer rid = roleVo.getRoleid();
		Integer [] mids = roleVo.getIds();
		//先根据rid将已分配的菜单删除然后在进行插入
		this.roleMapper.deleteRoleMenuByRid(rid);
		//保存角色和菜单的关系
		for (Integer mid : mids) {
			this.roleMapper.insertRoleMenu(rid,mid);
		}
	}

}
