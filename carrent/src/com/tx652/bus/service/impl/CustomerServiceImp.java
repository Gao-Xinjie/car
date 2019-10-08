package com.tx652.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tx652.bus.domain.Customer;
import com.tx652.bus.mapper.CustomerMapper;
import com.tx652.bus.service.CustomerService;
import com.tx652.sys.utils.DataGridView;
import com.tx652.bus.vo.CustomerVo;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public DataGridView queryAllcustomer(CustomerVo customerVo) {
		Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getLimit());
		List<Customer> data = this.customerMapper.queryAllCustomer(customerVo);
		
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addCustomer(CustomerVo customerVo) {
		this.customerMapper.insertSelective(customerVo);
	}

	@Override
	public void deleteCustomer(String identity) {
		this.customerMapper.deleteByPrimaryKey(identity);
	}

	@Override
	public void deleteBatchCustomer(String[] identitys) {
		for (String identity : identitys) {
			this.deleteCustomer(identity);
		}
	}

	@Override
	public void updateCustomer(CustomerVo customerVo) {
		this.customerMapper.updateByPrimaryKeySelective(customerVo);
	}

	@Override
	public Customer queryCustomerByIdentity(String identity) {
		return this.customerMapper.selectByPrimaryKey(identity);
	}

}
