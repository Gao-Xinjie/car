package com.tx652.bus.mapper;

import java.util.List;

import com.tx652.bus.domain.Check;

public interface CheckMapper {
    int deleteByPrimaryKey(String checkid);

    int insert(Check record);

    int insertSelective(Check record);

    Check selectByPrimaryKey(String checkid);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
    
    //查询
    List<Check> queryAllCheck(Check check);
}