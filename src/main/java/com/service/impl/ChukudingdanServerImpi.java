package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.service.ChukudingdanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ChukudingdanMapper;
import com.entity.Chukudingdan;

@Service
public class ChukudingdanServerImpi implements ChukudingdanServer {
   @Autowired
   private ChukudingdanMapper gdao;
	@Override
	public int add(Chukudingdan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Chukudingdan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Chukudingdan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Chukudingdan> getsychukudingdan1(Map<String, Object> map) {
		return gdao.getsychukudingdan1(map);
	}
	public List<Chukudingdan> getsychukudingdan2(Map<String, Object> map) {
		return gdao.getsychukudingdan2(map);
	}
	public List<Chukudingdan> getsychukudingdan3(Map<String, Object> map) {
		return gdao.getsychukudingdan3(map);
	}
	
	@Override
	public Chukudingdan quchongChukudingdan(Map<String, Object> account) {
		return gdao.quchongChukudingdan(account);
	}

	@Override
	public List<Chukudingdan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Chukudingdan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Chukudingdan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

