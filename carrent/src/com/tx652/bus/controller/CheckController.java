package com.tx652.bus.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.bus.domain.Rent;
import com.tx652.bus.service.CheckService;
import com.tx652.bus.service.RentService;
import com.tx652.bus.vo.CheckVo;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.ResultObj;

/**
 * 检查单管理的控制器
 * @author 高鑫杰
 *
 */
@RestController
@RequestMapping("check")
public class CheckController {
	
	@Autowired
	private CheckService checkService;
	@Autowired
	private RentService rentService;
	/**
	 * 检查出租单号是否存在，两种情况，1存在，2不存在。
	 */
	@RequestMapping("checkRentExist")
	public Rent checkRentExist(String rentid) {
		Rent rent = rentService.queryRentByRentId(rentid);//null或者对象
		return rent;
	}
	/***
	 * 根据出租单号加载检查单的表单数据
	 */
	@RequestMapping("initCheckFormData")
	public Map<String,Object> initCheckFormData(String rentid){
		return this.checkService.initCheckFormData(rentid);
	}
	/**
	 * 保存检查单数据
	 */
	@RequestMapping("saveCheck")
	public ResultObj saveCheck(CheckVo checkVo) {
		try {
			checkVo.setCreatetime(new Date());
			this.checkService.addCheck(checkVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	/***********检查单管理*************/
	/***
	 * 加载所有的检查单
	 */
	@RequestMapping("loadAllCheck")
	public DataGridView loadAllCheck(CheckVo checkVo) {
		return this.checkService.queryAllCheck(checkVo);
	}
	/***
	 * 修改检查单
	 */
	@RequestMapping("updateCheck")
	public ResultObj updateCheck(CheckVo checkVo) {
		try {
			this.checkService.updateCheck(checkVo);
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_ERROR;
		}
	}
	
}
