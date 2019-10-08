package com.tx652.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.sys.service.RoleService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.ResultObj;
import com.tx652.sys.vo.RoleVo;

/**
 * 
 * 角色管理控制器
 * @author 高鑫杰
 *
 */

@RestController
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	
	
	@RequestMapping("loadAllRole")
	public DataGridView loadAllRole(RoleVo roleVo) {
		return this.roleService.queryAllrole(roleVo);
	}
	/**
	 * 
	 * 添加角色
	 */
	@RequestMapping("addRole")
	public ResultObj addRole(RoleVo roleVo) {
		
		try {
			this.roleService.addRole(roleVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * 
	 * 修改
	 */
	
	@RequestMapping("updateRole")
	public ResultObj updateRole(RoleVo roleVo) {
		
		try {
			this.roleService.updateRole(roleVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.UPDATE_ERROR;
		}
	}
	
	/**
	 * 
	 * 删除角色
	 */
	
	@RequestMapping("deleteRole")
	public ResultObj delete(RoleVo roleVo) {
		
		try {
			this.roleService.deleteRole(roleVo.getRoleid());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/**
	 * 
	 * 批量删除角色
	 */
	
	@RequestMapping("deleteBatchRole")
	public ResultObj deleteBatchRole(RoleVo roleVo) {
		
		try {
			this.roleService.deleteBatchRole(roleVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/***
	 * 加载角色管里分配菜单的json
	 * initRoleMenuTreeJson
	 */
	@RequestMapping("initRoleMenuTreeJson")
	public DataGridView initRoleMenuTreeJson(Integer roleid){
		return this.roleService.initRoleMenuTreeJson(roleid);
	}
	
	/**
	 * 
	 * 保存角色和菜单的关系saveRoleMenu
	 */
	@RequestMapping("saveRoleMenu")
	public ResultObj saveRoleMenu(RoleVo roleVo) {
		try {
			
			this.roleService.saveRoleMenu(roleVo);
			return ResultObj.DISPATCH_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DISPATCH_ERROR;
		}
	}
}
