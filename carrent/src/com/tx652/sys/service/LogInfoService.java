package com.tx652.sys.service;


import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.vo.LogInfoVo;

/**
 * 
 * 日志管理的服务接口
 * @author 高鑫杰
 *
 */


public interface LogInfoService {

	/**
	 * 
	 * 查询所有日志
	 * @param logInfoVo
	 * @return
	 */
	public DataGridView queryAlllogInfo(LogInfoVo logInfoVo);
	/**
	 * 
	 * 添加日志
	 * @param logInfoVo
	 */
	public void addLogInfo(LogInfoVo logInfoVo);

	/**
	 * 
	 * 根据id删除日志
	 * @param logInfoid
	 */
	public void deleteLogInfo(Integer logInfoid);
	
	/**
	 * 批量删除日志
	 * 
	 */
	public void deleteBatchLogInfo(Integer [] ids);
	
}
