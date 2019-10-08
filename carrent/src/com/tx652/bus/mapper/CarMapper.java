package com.tx652.bus.mapper;

import java.util.List;

import com.tx652.bus.domain.Car;

public interface CarMapper {
    int deleteByPrimaryKey(String carnumber);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(String carnumber);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);
    
    List<Car> queryAllCar(Car car);
}