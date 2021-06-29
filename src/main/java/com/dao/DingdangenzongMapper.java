package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Dingdangenzong;

public interface DingdangenzongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dingdangenzong record);

    int insertSelective(Dingdangenzong record);

    Dingdangenzong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dingdangenzong record);
	int updateByPrimaryKeySelectivelb(Dingdangenzong record);
    int updateByPrimaryKey(Dingdangenzong record);
	public Dingdangenzong quchongDingdangenzong(Map<String, Object> gonghao);
	public List<Dingdangenzong> getAll(Map<String, Object> map);
	public List<Dingdangenzong> getsydingdangenzong1(Map<String, Object> map);
	public List<Dingdangenzong> getsydingdangenzong3(Map<String, Object> map);
	public List<Dingdangenzong> getsydingdangenzong2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Dingdangenzong> getByPage(Map<String, Object> map);
	public List<Dingdangenzong> select(Map<String, Object> map);
//	所有List
}

