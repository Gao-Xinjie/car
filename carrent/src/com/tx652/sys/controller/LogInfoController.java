package com.tx652.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.sys.service.LogInfoService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.ResultObj;
import com.tx652.sys.vo.LogInfoVo;

/**
 * 
 * 日志管理控制器
 * @author 高鑫杰
 *
 */

@RestController
@RequestMapping("logInfo")
public class LogInfoController {
	@Autowired
	private LogInfoService logInfoService;
	
	
	/**
	 * 加载日志
	 * @param logInfoVo
	 * @return
	 */
	@RequestMapping("loadAllLogInfo")
	public DataGridView loadAllLogInfo(LogInfoVo logInfoVo) {
		return this.logInfoService.queryAlllogInfo(logInfoVo);
	}

	
	/**
	 * 
	 * 删除日志
	 */
	
	@RequestMapping("deleteLogInfo")
	public ResultObj delete(LogInfoVo logInfoVo) {
		
		try {
			this.logInfoService.deleteLogInfo(logInfoVo.getId());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
	
	/**
	 * 
	 * 批量删除日志
	 */
	
	@RequestMapping("deleteBatchLogInfo")
	public ResultObj deleteBatchLogInfo(LogInfoVo logInfoVo) {
		
		try {
			this.logInfoService.deleteBatchLogInfo(logInfoVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
	

	

}
