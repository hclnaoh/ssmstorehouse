package com.service;

import java.util.List;

import java.util.Map;

import com.entity.Peisongyuanxinxi;

public interface PeisongyuanxinxiServer {

  public int add(Peisongyuanxinxi po);

  public int update(Peisongyuanxinxi po);
  
  
  
  public int delete(int id);

  public List<Peisongyuanxinxi> getAll(Map<String, Object> map);
  public List<Peisongyuanxinxi> getsypeisongyuanxinxi1(Map<String, Object> map);
  public List<Peisongyuanxinxi> getsypeisongyuanxinxi2(Map<String, Object> map);
  public List<Peisongyuanxinxi> getsypeisongyuanxinxi3(Map<String, Object> map);
  public Peisongyuanxinxi quchongPeisongyuanxinxi(Map<String, Object> acount);

  public Peisongyuanxinxi getById(int id);

  public List<Peisongyuanxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String, Object> map);

  public List<Peisongyuanxinxi> select(Map<String, Object> map);
}
//	所有List
