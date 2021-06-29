package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Huowuxinxi;

public interface HuowuxinxiServer {

  public int add(Huowuxinxi po);

  public int update(Huowuxinxi po);
  
  
  
  public int delete(int id);

  public List<Huowuxinxi> getAll(Map<String, Object> map);
  public List<Huowuxinxi> getsyhuowuxinxi1(Map<String, Object> map);
  public List<Huowuxinxi> getsyhuowuxinxi2(Map<String, Object> map);
  public List<Huowuxinxi> getsyhuowuxinxi3(Map<String, Object> map);
  public Huowuxinxi quchongHuowuxinxi(Map<String, Object> acount);

  public Huowuxinxi getById(int id);

  public List<Huowuxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Huowuxinxi> select(Map<String, Object> map);
}
//	所有List
