package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.service.HuowuxinxiServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HuowuxinxiMapper;
import com.entity.Huowuxinxi;

@Service
public class HuowuxinxiServerImpi implements HuowuxinxiServer {
   @Autowired
   private HuowuxinxiMapper gdao;
	@Override
	public int add(Huowuxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Huowuxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Huowuxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Huowuxinxi> getsyhuowuxinxi1(Map<String, Object> map) {
		return gdao.getsyhuowuxinxi1(map);
	}
	public List<Huowuxinxi> getsyhuowuxinxi2(Map<String, Object> map) {
		return gdao.getsyhuowuxinxi2(map);
	}
	public List<Huowuxinxi> getsyhuowuxinxi3(Map<String, Object> map) {
		return gdao.getsyhuowuxinxi3(map);
	}
	
	@Override
	public Huowuxinxi quchongHuowuxinxi(Map<String, Object> account) {
		return gdao.quchongHuowuxinxi(account);
	}

	@Override
	public List<Huowuxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Huowuxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Huowuxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

