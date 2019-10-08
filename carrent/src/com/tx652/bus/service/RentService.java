package com.tx652.bus.service;


import com.tx652.bus.domain.Rent;
import com.tx652.bus.vo.RentVo;
import com.tx652.sys.utils.DataGridView;

public interface RentService {
	/**
	 * 保存出租单信息
	 * @param rentVo
	 */
	void addRent(RentVo rentVo);
	/***
	 * 查询所有的出租车单
	 * @param rentVo
	 */
	DataGridView queryAllRent(RentVo rentVo);
	/**
	 * 
	 * 删除出租单
	 * @param rentid
	 */
	
	void deleteRent(String rentid);
	/**
	 * 
	 * 修改出租单
	 * @param rentVo
	 */
	void updateRent(RentVo rentVo);
	/**
	 * 根据出租单号查询出租单信息
	 * 
	 * @param rentid
	 * @return
	 */
	Rent queryRentByRentId(String rentid);
	
	
}
