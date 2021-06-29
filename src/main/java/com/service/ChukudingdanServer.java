package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Chukudingdan;

public interface ChukudingdanServer {

  public int add(Chukudingdan po);

  public int update(Chukudingdan po);
  
  
  
  public int delete(int id);

  public List<Chukudingdan> getAll(Map<String, Object> map);
  public List<Chukudingdan> getsychukudingdan1(Map<String, Object> map);
  public List<Chukudingdan> getsychukudingdan2(Map<String, Object> map);
  public List<Chukudingdan> getsychukudingdan3(Map<String, Object> map);
  public Chukudingdan quchongChukudingdan(Map<String, Object> acount);

  public Chukudingdan getById(int id);

  public List<Chukudingdan> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Chukudingdan> select(Map<String, Object> map);
}
//	所有List
