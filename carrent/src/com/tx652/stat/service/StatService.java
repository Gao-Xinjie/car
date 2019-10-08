package com.tx652.stat.service;

import java.util.List;

import com.tx652.stat.domain.BaseEntity;

/**
 * 统计分析数据服务接口
 * @author 高鑫杰
 *
 */
public interface StatService {

	/**
	 * 查询客户地区的数据
	 * @return
	 */
	List<BaseEntity> loadCustomerAreaStatList();

	/**
	 * 业务员年度统计数据
	 * @return
	 */
	List<BaseEntity> loadOpernameYearGradeStatList(String year);

	/**
	 * 加载公司年度统计数据
	 * @param year
	 * @return
	 */
	List<Double> loadCompanyYearGradeStatList(String year);

	
}
