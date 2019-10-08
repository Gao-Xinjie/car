package com.tx652.sys.constast;
/**
 * 
 * 常量接口
 * @author ���ν�
 *
 */
public interface SysConstast {

	Object USER_LOGIN_REEOR_MSG = "用户或密码不正确";
	/**
	 * 
	 * 可用状态
	 */
	Integer AVAILABLE_TRUE = 1;
	Integer AVAILABLE_FALSE = 0;
	/*
	 * 
	 * 用户类型
	 */
	Integer USER_TYPE_SUPER = 1;
	Integer USER_TYPE_NORMAL = 2;
	/*
	 * 
	 * 是否展开
	 */
	Integer SPREAD_TRUE = 1;
	Integer SPREAD_FALSE = 0;
	
	/**
	 * 操作状态
	 * 
	 */
	//添加
	String ADD_SUCCESS = "添加成功";
	String ADD_ERROR   = "添加失败";
	
	//修改
	String UPDATE_SUCCESS = "更新成功";
	String UPDATE_ERROR   = "更新失败";
	
	//删除
	String DELETE_SUCCESS = "删除成功";
	String DELETE_ERROR   = "删除失败";
	
	//重置
	String RESET_SUCCESS = "重置成功";
	String RESET_ERROR   = "重置失败";
	
	//分配
	String DISPATCH_SUCCESS = "分配成功";
	String DISPATCH_ERROR   = "分配失败";
	
	Integer CODE_SUCCESS=0;  //操作成功
	Integer CODE_ERROR  = -1;//操作失败
	/**
	 * 公用常量
	 * 
	 */
	Integer CODE_ZERO = 0;
	Integer CODE_ONE = 1;
	Integer CODE_TWO = 2;
	Integer CODE_THREE = 3;
	/**
	 * 
	 * 默认密码配置
	 */
	String USER_DEFAULT_PWD = "123456";
	/**
	 * 
	 * 临时文件后缀
	 */
	String FILE_UPLOAD_TEMP_TEMP = "_temp";
	/***
	 * 
	 * 默认图片地址
	 */
	Object DEFULT_CAR_IMG = "images/defaultcarimage.jpg";
	/**
	 * 出租单号的前缀
	 */
	String CAR_ORDER_CZ = "CZ";
	/**
	 * 检查单的前缀
	 */
	String CAR_ORDER_JC = "JC";
	/**
	 * 设置归还状态
	 */
	Integer RENT_BACK_FALSE = 0;
	Integer RENT_BACK_TRUE = 1;
	/**
	 * 设置汽车的出租状态
	 */
	Integer RENT_CAR_TRUE = 1;
	Integer RENT_CAR_FALSE = 0;
}
