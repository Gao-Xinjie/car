package com.tx652.stat.mapper;

import java.util.List;

import com.tx652.stat.domain.BaseEntity;

public interface StatMapper {

	/**
	 * 查询客户地区的数据
	 * @return
	 */
	List<BaseEntity> queryCustomerAreaStat();

	/**
	 * 查询业务员年度业绩
	 * @param year
	 * @return
	 */
	List<BaseEntity> queryOpernameYearGradeStat(String year);

	/**
	 * 加载公司年度统计数据
	 * @param year
	 * @return
	 */
	List<Double> queryCompanyYearGradeStat(String year);

}
