package com.tx652.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.sys.service.UserService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.ResultObj;
import com.tx652.sys.vo.UserVo;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	/**
	 * 加载用户列表
	 * @param userVo
	 * @return
	 */
	@RequestMapping("loadAllUser")
	public DataGridView loadAllUser(UserVo userVo) {
		return this.userService.queryAlluser(userVo);
	}
	/**
	 * 
	 * 添加用户
	 */
	@RequestMapping("addUser")
	public ResultObj addUser(UserVo userVo) {
		
		try {
			this.userService.addUser(userVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * 
	 * 修改
	 */
	
	@RequestMapping("updateUser")
	public ResultObj updateUser(UserVo userVo) {
		
		try {
			this.userService.updateUser(userVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.UPDATE_ERROR;
		}
	}
	
	/**
	 * 
	 * 删除用户
	 */
	
	@RequestMapping("deleteUser")
	public ResultObj delete(UserVo userVo) {
		
		try {
			this.userService.deleteUser(userVo.getUserid());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/**
	 * 
	 * 批量删除用户
	 */
	
	@RequestMapping("deleteBatchUser")
	public ResultObj deleteBatchUser(UserVo userVo) {
		
		try {
			this.userService.deleteBatchUser(userVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
	/**
	 * 
	 * 重置用户密码用户
	 */
	
	@RequestMapping("resetUserPwd")
	public ResultObj resetUserPwd(UserVo userVo) {
		
		try {
			this.userService.resetUserPwd(userVo.getUserid());
			return ResultObj.RESET_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.RESET_ERROR;
		}
	}
	
	/**
	 * 加载用户管理的分配角色的数据
	 * 
	 */
	@RequestMapping("initUserRole")
	public DataGridView initUserRole(UserVo userVo) {
		
		
		return this.userService.queryUserRole(userVo.getUserid());
	}
	/**
	 * 
	 * 保存用户和角色的关系
	 */
	@RequestMapping("saveUserRole")
	public ResultObj saveUserRole(UserVo userVo) {
		try {
			this.userService.saveUserRole(userVo);
			return ResultObj.DISPATCH_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DISPATCH_ERROR;
		}
		
	}
	
	
	
	
	
}
