package com.tx652.bus.service;



import com.tx652.bus.domain.Customer;
import com.tx652.bus.vo.CustomerVo;
import com.tx652.sys.utils.DataGridView;

/**
 * 
 * 客户管理的服务接口
 * @author 高鑫杰
 *
 */


public interface CustomerService {

	/**
	 * 
	 * 查询所有客户
	 * @param customerVo
	 * @return
	 */
	public DataGridView queryAllcustomer(CustomerVo customerVo);
	/**
	 * 
	 * 添加客户
	 * @param customerVo
	 */
	public void addCustomer(CustomerVo customerVo);
	/**
	 * 
	 * 修改客户
	 * @param customerVo
	 */
	public void updateCustomer(CustomerVo customerVo);

	/**
	 * 
	 * 根据id删除客户
	 * @param customerid
	 */
	public void deleteCustomer(String identity);
	
	/**
	 * 批量删除客户
	 * 
	 */
	public void deleteBatchCustomer(String [] identitys);
	/***
	 * 根据身份证号查询客户信息
	 * @param identity
	 * @return
	 */
	public Customer queryCustomerByIdentity(String identity);
	
}
