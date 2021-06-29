package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Peisongyuanxinxi;

public interface PeisongyuanxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Peisongyuanxinxi record);

    int insertSelective(Peisongyuanxinxi record);

    Peisongyuanxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Peisongyuanxinxi record);
	
    int updateByPrimaryKey(Peisongyuanxinxi record);
	public Peisongyuanxinxi quchongPeisongyuanxinxi(Map<String, Object> gonghao);
	public List<Peisongyuanxinxi> getAll(Map<String, Object> map);
	public List<Peisongyuanxinxi> getsypeisongyuanxinxi1(Map<String, Object> map);
	public List<Peisongyuanxinxi> getsypeisongyuanxinxi3(Map<String, Object> map);
	public List<Peisongyuanxinxi> getsypeisongyuanxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Peisongyuanxinxi> getByPage(Map<String, Object> map);
	public List<Peisongyuanxinxi> select(Map<String, Object> map);
//	所有List
}

