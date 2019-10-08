package com.tx652.bus.service;

import java.util.Map;

import com.tx652.bus.vo.CheckVo;
import com.tx652.sys.utils.DataGridView;

/**
 * 检查单管理的服务
 * @author 高鑫杰
 *
 */
public interface CheckService {

	/**
	 * 
	 * 根据出租单号加载检查单的表单数据
	 * @param rentid
	 * @return
	 */
	Map<String, Object> initCheckFormData(String rentid);
	/**
	 * 保存检查单数据
	 * @param checkVo
	 */
	void addCheck(CheckVo checkVo);
	/**
	 * 查询所有检查单
	 */
	DataGridView queryAllCheck(CheckVo checkVo);
	/**
	 * 修改检查单
	 * @param checkVo
	 */
	void updateCheck(CheckVo checkVo);
}
