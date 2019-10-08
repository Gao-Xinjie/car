package com.tx652.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tx652.sys.domain.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    /**
     * 
     * 查询角色
     * @param role
     * @return
     */
    List<Role> queryAllRole(Role role);
	/**
	 * 
	 * 根据角色删除sys_role role里边的数据
	 * @param roleid
	 */
	void deleteRoleMenuByRid(Integer roleid);
	/**
	 * 
	 * 
	 * @param roleid
	 */
	void deleteRoleUserByRid(Integer roleid);

	/**
	 * 
	 * 保存橘色和菜单的关系 sys_role_menu
	 * @param rid
	 * @param mid
	 */
	void insertRoleMenu(@Param("rid")Integer rid,@Param("mid")Integer mid);
	/**
	 * 
	 * 根据用户id删除sys_role_user里面的数据
	 * @param userid
	 */
	public void deleteRoleUserByUid(Integer userid);

	/**
	 * 根据用户id查询当前用户可用的角色
	 * 
	 * @param availableTrue
	 * @param userid
	 * @return
	 */
	List<Role> queryRoleByUid(@Param("available")Integer available, @Param("uid")Integer userid);
}