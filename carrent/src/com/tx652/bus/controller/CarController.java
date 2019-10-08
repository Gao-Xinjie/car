package com.tx652.bus.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tx652.bus.domain.Car;
import com.tx652.bus.service.CarService;
import com.tx652.sys.constast.SysConstast;
import com.tx652.sys.utils.AppFileUtils;
import com.tx652.sys.utils.DataGridView;
import com.tx652.sys.utils.ResultObj;
import com.tx652.bus.vo.CarVo;

/**
 * 
 * 车辆管理控制器
 * @author 高鑫杰
 *
 */

@RestController
@RequestMapping("car")
public class CarController {
	@Autowired
	private CarService carService;
	
	
	
	@RequestMapping("loadAllCar")
	public DataGridView loadAllCar(CarVo carVo) {
		return this.carService.queryAllcar(carVo);
	}
	/**
	 * 
	 * 添加车辆
	 */
	@RequestMapping("addCar")
	public ResultObj addCar(CarVo carVo) {
		
		try {
			carVo.setCreatetime(new Date());
			//如果不是默认图片就去掉图片的_temp的后缀
			if(!carVo.getCarimg().equals(SysConstast.DEFULT_CAR_IMG)) {
				String filePath=AppFileUtils.updateFileName(carVo.getCarimg(),SysConstast.FILE_UPLOAD_TEMP_TEMP);
				carVo.setCarimg(filePath);
			}
			this.carService.addCar(carVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}
	
	/**
	 * 
	 * 修改车辆
	 */
	@RequestMapping("updateCar")
	public ResultObj updateCar(CarVo carVo) {
		
		try {
			String carimg = carVo.getCarimg();
			//是以_temp结尾的
			if(carimg.endsWith(SysConstast.FILE_UPLOAD_TEMP_TEMP)) {
				String filePath=AppFileUtils.updateFileName(carVo.getCarimg(),SysConstast.FILE_UPLOAD_TEMP_TEMP);
				carVo.setCarimg(filePath);
				
				//把原来的图片删除
				Car car=this.carService.queryCarByCarNumer(carVo.getCarnumber());
				AppFileUtils.removeFileByPath(car.getCarimg());
			}
			this.carService.updateCar(carVo);
			return ResultObj.ADD_SUCCESS;
		} catch (Exception e) {
			return ResultObj.ADD_ERROR;
		}
	}	

	
	/**
	 * 
	 * 删除车辆
	 */
	
	@RequestMapping("deleteCar")
	public ResultObj delete(CarVo carVo) {
		
		try {
			this.carService.deleteCar(carVo.getCarnumber());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}

	
	/**
	 * 
	 * 批量删除车辆
	 */
	
	@RequestMapping("deleteBatchCar")
	public ResultObj deleteBatchCar(CarVo carVo) {
		
		try {
			this.carService.deleteBatchCar(carVo.getIds());
			return ResultObj.DELETE_SUCCESS;
		} catch (Exception e) {
			return ResultObj.DELETE_ERROR;
		}
	}
}
