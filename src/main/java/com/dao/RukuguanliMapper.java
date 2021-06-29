package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Rukuguanli;

public interface RukuguanliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rukuguanli record);

    int insertSelective(Rukuguanli record);

    Rukuguanli selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rukuguanli record);
	
    int updateByPrimaryKey(Rukuguanli record);
	public Rukuguanli quchongRukuguanli(Map<String, Object> huowubianhao);
	public List<Rukuguanli> getAll(Map<String, Object> map);
	public List<Rukuguanli> getsyrukuguanli1(Map<String, Object> map);
	public List<Rukuguanli> getsyrukuguanli3(Map<String, Object> map);
	public List<Rukuguanli> getsyrukuguanli2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Rukuguanli> getByPage(Map<String, Object> map);
	public List<Rukuguanli> select(Map<String, Object> map);
//	所有List
}

