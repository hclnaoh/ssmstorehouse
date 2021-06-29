package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.service.LiuyanbanServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LiuyanbanMapper;
import com.entity.Liuyanban;

@Service
public class LiuyanbanServerImpi implements LiuyanbanServer {
   @Autowired
   private LiuyanbanMapper gdao;
	@Override
	public int add(Liuyanban po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Liuyanban po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Liuyanban po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Liuyanban> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Liuyanban> getsyliuyanban1(Map<String, Object> map) {
		return gdao.getsyliuyanban1(map);
	}
	public List<Liuyanban> getsyliuyanban2(Map<String, Object> map) {
		return gdao.getsyliuyanban2(map);
	}
	public List<Liuyanban> getsyliuyanban3(Map<String, Object> map) {
		return gdao.getsyliuyanban3(map);
	}
	
	@Override
	public Liuyanban quchongLiuyanban(Map<String, Object> account) {
		return null;
	}

	@Override
	public List<Liuyanban> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Liuyanban> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Liuyanban getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

