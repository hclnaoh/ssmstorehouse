package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Rukuguanli;

public interface RukuguanliServer {

  public int add(Rukuguanli po);

  public int update(Rukuguanli po);
  
  
  
  public int delete(int id);

  public List<Rukuguanli> getAll(Map<String, Object> map);
  public List<Rukuguanli> getsyrukuguanli1(Map<String, Object> map);
  public List<Rukuguanli> getsyrukuguanli2(Map<String, Object> map);
  public List<Rukuguanli> getsyrukuguanli3(Map<String, Object> map);
  public Rukuguanli quchongRukuguanli(Map<String, Object> acount);

  public Rukuguanli getById(int id);

  public List<Rukuguanli> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Rukuguanli> select(Map<String, Object> map);
}
//	所有List
