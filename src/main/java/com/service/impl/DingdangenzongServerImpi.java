package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.service.DingdangenzongServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DingdangenzongMapper;
import com.entity.Dingdangenzong;

@Service
public class DingdangenzongServerImpi implements DingdangenzongServer {
   @Autowired
   private DingdangenzongMapper gdao;
	@Override
	public int add(Dingdangenzong po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Dingdangenzong po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Dingdangenzong po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Dingdangenzong> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Dingdangenzong> getsydingdangenzong1(Map<String, Object> map) {
		return gdao.getsydingdangenzong1(map);
	}
	public List<Dingdangenzong> getsydingdangenzong2(Map<String, Object> map) {
		return gdao.getsydingdangenzong2(map);
	}
	public List<Dingdangenzong> getsydingdangenzong3(Map<String, Object> map) {
		return gdao.getsydingdangenzong3(map);
	}
	
	@Override
	public Dingdangenzong quchongDingdangenzong(Map<String, Object> account) {
		return gdao.quchongDingdangenzong(account);
	}

	@Override
	public List<Dingdangenzong> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Dingdangenzong> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Dingdangenzong getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

