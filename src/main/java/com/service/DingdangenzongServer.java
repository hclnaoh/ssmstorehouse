package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Dingdangenzong;

public interface DingdangenzongServer {

  public int add(Dingdangenzong po);

  public int update(Dingdangenzong po);
  
  public int updatelb(Dingdangenzong po);
  
  public int delete(int id);

  public List<Dingdangenzong> getAll(Map<String, Object> map);
  public List<Dingdangenzong> getsydingdangenzong1(Map<String, Object> map);
  public List<Dingdangenzong> getsydingdangenzong2(Map<String, Object> map);
  public List<Dingdangenzong> getsydingdangenzong3(Map<String, Object> map);
  public Dingdangenzong quchongDingdangenzong(Map<String, Object> acount);

  public Dingdangenzong getById(int id);

  public List<Dingdangenzong> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Dingdangenzong> select(Map<String, Object> map);
}
//	所有List
