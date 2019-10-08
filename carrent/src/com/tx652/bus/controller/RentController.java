package com.tx652.bus.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.bus.domain.Customer;
import com.tx652.bus.service.CustomerService;
import com.tx652.bus.service.RentService;
import com.tx652.bus.vo.RentVo;
import com.tx652.sys.constast.SysConstast;
import com.tx652.sys.domain.User;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.RandomUtils;
import com.tx652.sys.utils.ResultObj;
import com.tx652.sys.utils.WebUtils;

/**
 * 
 * 汽车出租管理的控制器
 * @author 高鑫杰
 *
 */

@RestController
@RequestMapping("rent")
public class RentController {
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private CustomerService customerService;
	
	/**
	 * 检查身份证号是否存在
	 */
	@RequestMapping("checkCustomerExist")
	public ResultObj checkCustomerExist(RentVo rentVo) {
		Customer customer=customerService.queryCustomerByIdentity(rentVo.getIdentity());	
		if(customer !=null) {
			return ResultObj.STASTUS_TRUE;//存在
		}else {
			
			return ResultObj.STASTUS_ERROR;//不存在
		}
		
	}
	
	/**
	 * 
	 * 初始化添加出租单的表单数据
	 */
	@RequestMapping("initRentFrom")
	public RentVo initRentFrom(RentVo rentVo) {
		//生成出租单号
		rentVo.setRentid(RandomUtils.createRandomStringUseTime(SysConstast.CAR_ORDER_CZ));
		//设置起租时间
		rentVo.setBegindate(new Date());
		//设置操作员
		//从session获取
		User user = (User) WebUtils.getHttpSession().getAttribute("user");
		rentVo.setOpername(user.getRealname());
		return rentVo;
	}
	
	/**
	 * 
	 * 保存出租单信息
	 */
	@RequestMapping("saveRent")
	public ResultObj saveRent(RentVo rentVo) {
		try {
			//提交表内只有六条数据还有三个1.设置创建时间
			rentVo.setCreatetime(new Date());
			//2.设置归还状态
			rentVo.setRentflag(SysConstast.RENT_BACK_FALSE);
			//保存
			this.rentService.addRent(rentVo);
			
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.ADD_ERROR;
		}
	}
	
	
	/********************出租单管理**********************/
	/**
	 * 出租单查询
	 */
	@RequestMapping("loadAllRent")
	public DataGridView loadAllRent(RentVo rentVo) {
		return this.rentService.queryAllRent(rentVo);
	}
	/**
	 * 出租单修改
	 */
	@RequestMapping("updateRent")
	public ResultObj updateRent(RentVo rentVo) {
		try {
			this.rentService.updateRent(rentVo);
			
			return ResultObj.UPDATE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.UPDATE_SUCCESS;
		}
	}
	/**
	 * 
	 * 出租单删除
	 * @param rentVo
	 * @return
	 */
	@RequestMapping("deleteRent")
	public ResultObj deleteRent(RentVo rentVo) {
		try {
			this.rentService.deleteRent(rentVo.getRentid());
			
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ResultObj.DELETE_ERROR;
		}
	}
}
