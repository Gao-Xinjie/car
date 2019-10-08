package com.tx652.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tx652.sys.domain.LogInfo;
import com.tx652.sys.mapper.LogInfoMapper;
import com.tx652.sys.service.LogInfoService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.vo.LogInfoVo;

@Service
public class LogInfoServiceImp implements LogInfoService {
	
	@Autowired
	LogInfoMapper logInfoMapper;
	
	@Override
	public DataGridView queryAlllogInfo(LogInfoVo logInfoVo) {
		Page<Object> page = PageHelper.startPage(logInfoVo.getPage(), logInfoVo.getLimit());
		List<LogInfo> data = this.logInfoMapper.queryAllLogInfo(logInfoVo);
		
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addLogInfo(LogInfoVo logInfoVo) {
		this.logInfoMapper.insertSelective(logInfoVo);
	}

	@Override
	public void deleteLogInfo(Integer logInfoid) {
		this.logInfoMapper.deleteByPrimaryKey(logInfoid);
	}

	@Override
	public void deleteBatchLogInfo(Integer[] ids) {
		for (Integer id : ids) {
			this.deleteLogInfo(id);
		}
	}

}
