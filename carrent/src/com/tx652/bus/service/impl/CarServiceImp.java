package com.tx652.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tx652.bus.domain.Car;
import com.tx652.bus.mapper.CarMapper;
import com.tx652.bus.service.CarService;
import com.tx652.sys.constast.SysConstast;
import com.tx652.sys.utils.AppFileUtils;
import com.tx652.sys.utils.DataGridView;
import com.tx652.bus.vo.CarVo;

@Service
public class CarServiceImp implements CarService {
	
	@Autowired
	CarMapper carMapper;
	
	@Override
	public DataGridView queryAllcar(CarVo carVo) {
		Page<Object> page = PageHelper.startPage(carVo.getPage(), carVo.getLimit());
		List<Car> data = this.carMapper.queryAllCar(carVo);
		
		return new DataGridView(page.getTotal(),data);
	}

	@Override
	public void addCar(CarVo carVo) {
		this.carMapper.insertSelective(carVo);
	}

	@Override
	public void deleteCar(String carnumber) {
		//先删除图片
		Car car=this.carMapper.selectByPrimaryKey(carnumber);
		//如果不是默认图片才删除
		if(!car.getCarimg().equals(SysConstast.DEFULT_CAR_IMG)){
			AppFileUtils.deleteFileUsePath(car.getCarimg());
		}
		//再删除记录
		this.carMapper.deleteByPrimaryKey(carnumber);
	}

	@Override
	public void deleteBatchCar(String[] carnumbers) {
		for (String carnumber : carnumbers) {
			this.deleteCar(carnumber);
		}
	}

	@Override
	public void updateCar(CarVo carVo) {
		this.carMapper.updateByPrimaryKeySelective(carVo);
	}

	@Override
	public Car queryCarByCarNumer(String carnumber) {
		return this.carMapper.selectByPrimaryKey(carnumber);
	}

}
