package com.tx652.bus.service;



import com.tx652.bus.domain.Car;
import com.tx652.bus.vo.CarVo;
import com.tx652.sys.utils.DataGridView;

/**
 * 
 *车辆管理的服务接口
 * @author 高鑫杰
 *
 */


public interface CarService {

	/**
	 * 
	 * 查询所有客户
	 * @param carVo
	 * @return
	 */
	public DataGridView queryAllcar(CarVo carVo);
	/**
	 * 
	 * 添加客户
	 * @param carVo
	 */
	public void addCar(CarVo carVo);
	/**
	 * 
	 * 修改客户
	 * @param carVo
	 */
	public void updateCar(CarVo carVo);

	/**
	 * 
	 * 根据id删除客户
	 * @param carid
	 */
	public void deleteCar(String carnumber);
	
	/**
	 * 批量删除客户
	 * 
	 */
	public void deleteBatchCar(String [] carnumbers);
	
	/**
	 * 
	 * 根据车牌号查询
	 * @param carnumber
	 * @return
	 */
	public Car queryCarByCarNumer(String carnumber);
	
}
