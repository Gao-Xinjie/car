package com.tx652.bus.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.bus.service.CustomerService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.ResultObj;
import com.tx652.bus.vo.CustomerVo;

/**
 * 
 * 客户管理控制器
 * @author 高鑫杰
 *
 */

@RestController
@RequestMapping("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	
	@RequestMapping("loadAllCustomer")
	public DataGridView loadAllCustomer(CustomerVo customerVo) {
		return this.customerService.queryAllcustomer(customerVo);
	}
	/**
	 * 
	 * 添加客户
	 */
	@RequestMapping("addCustomer")
	public ResultObj addCustomer(CustomerVo customerVo) {
		
		try {
			customerVo.setCreatetime(new Date());
			this.customerService.addCustomer(customerVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * 
	 * 修改客户
	 */
	@RequestMapping("updateCustomer")
	public ResultObj updateCustomer(CustomerVo customerVo) {
		
		try {
			this.customerService.updateCustomer(customerVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}	

	
	/**
	 * 
	 * 删除客户
	 */
	
	@RequestMapping("deleteCustomer")
	public ResultObj delete(CustomerVo customerVo) {
		
		try {
			this.customerService.deleteCustomer(customerVo.getIdentity());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}

	
	/**
	 * 
	 * 批量删除客户
	 */
	
	@RequestMapping("deleteBatchCustomer")
	public ResultObj deleteBatchCustomer(CustomerVo customerVo) {
		
		try {
			this.customerService.deleteBatchCustomer(customerVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
}
