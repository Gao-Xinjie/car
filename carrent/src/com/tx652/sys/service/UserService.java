package com.tx652.sys.service;

import com.tx652.sys.domain.User;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.vo.UserVo;

/**
 * 
 * 用户服务接口
 * @author 高鑫杰
 *
 */
public interface UserService {

	User login(UserVo userVo);
	
	/**
	 * 
	 * 查询所有用户
	 * @param userVo
	 * @return
	 */
	public DataGridView queryAlluser(UserVo userVo);
	/**
	 * 
	 * 添加用户
	 * @param userVo
	 */
	public void addUser(UserVo userVo);

	/**
	 * 修改用户
	 * @param userVo
	 */
	public void updateUser(UserVo userVo);

	/**
	 * 
	 * 根据id删除用户
	 * @param userid
	 */
	public void deleteUser(Integer userid);
	
	/**
	 * 批量删除用户
	 * 
	 */
	public void deleteBatchUser(Integer [] ids);
	/**
	 * 
	 * 用户重置密码
	 * @param userid
	 */
	public void resetUserPwd(Integer userid);
	/**
	 * 
	 * 加载用户管理的分配角色
	 * @param userid
	 * @return
	 */
	DataGridView queryUserRole(Integer userid);
	/**
	 * 
	 * 保存用户和角色的关系
	 * @param userVo
	 */
	void saveUserRole(UserVo userVo);
}
