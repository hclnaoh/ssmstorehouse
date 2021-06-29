package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Chukudingdan;

public interface ChukudingdanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chukudingdan record);

    int insertSelective(Chukudingdan record);

    Chukudingdan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chukudingdan record);
	
    int updateByPrimaryKey(Chukudingdan record);
	public Chukudingdan quchongChukudingdan(Map<String, Object> goumairen);
	public List<Chukudingdan> getAll(Map<String, Object> map);
	public List<Chukudingdan> getsychukudingdan1(Map<String, Object> map);
	public List<Chukudingdan> getsychukudingdan3(Map<String, Object> map);
	public List<Chukudingdan> getsychukudingdan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Chukudingdan> getByPage(Map<String, Object> map);
	public List<Chukudingdan> select(Map<String, Object> map);
//	所有List
}

