package com.tx652.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tx652.sys.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 
     * 登陆
     */
	User login(User user);
	
	/**
	 * 
	 * 查询用户
	 */
	List<User> queryAllUser(User user);

	/**
	 * 保存用户和角色的关系
	 * @param userid
	 * @param rid
	 */
	void insetUserRole(@Param("uid")Integer userid, @Param("rid")Integer rid);
}