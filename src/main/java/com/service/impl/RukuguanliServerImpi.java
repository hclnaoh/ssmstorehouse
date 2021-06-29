package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.service.RukuguanliServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RukuguanliMapper;
import com.entity.Rukuguanli;

@Service
public class RukuguanliServerImpi implements RukuguanliServer {
   @Autowired
   private RukuguanliMapper gdao;
	@Override
	public int add(Rukuguanli po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Rukuguanli po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Rukuguanli> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Rukuguanli> getsyrukuguanli1(Map<String, Object> map) {
		return gdao.getsyrukuguanli1(map);
	}
	public List<Rukuguanli> getsyrukuguanli2(Map<String, Object> map) {
		return gdao.getsyrukuguanli2(map);
	}
	public List<Rukuguanli> getsyrukuguanli3(Map<String, Object> map) {
		return gdao.getsyrukuguanli3(map);
	}
	
	@Override
	public Rukuguanli quchongRukuguanli(Map<String, Object> account) {
		return gdao.quchongRukuguanli(account);
	}

	@Override
	public List<Rukuguanli> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Rukuguanli> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Rukuguanli getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

