package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Huowuxinxi;

public interface HuowuxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huowuxinxi record);

    int insertSelective(Huowuxinxi record);

    Huowuxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huowuxinxi record);
	
    int updateByPrimaryKey(Huowuxinxi record);
	public Huowuxinxi quchongHuowuxinxi(Map<String, Object> huowubianhao);
	public List<Huowuxinxi> getAll(Map<String, Object> map);
	public List<Huowuxinxi> getsyhuowuxinxi1(Map<String, Object> map);
	public List<Huowuxinxi> getsyhuowuxinxi3(Map<String, Object> map);
	public List<Huowuxinxi> getsyhuowuxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Huowuxinxi> getByPage(Map<String, Object> map);
	public List<Huowuxinxi> select(Map<String, Object> map);
//	所有List
}

