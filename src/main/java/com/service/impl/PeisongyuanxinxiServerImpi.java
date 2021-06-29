package com.service.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import com.service.PeisongyuanxinxiServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PeisongyuanxinxiMapper;
import com.entity.Peisongyuanxinxi;
@Service
public class PeisongyuanxinxiServerImpi implements PeisongyuanxinxiServer {
   @Autowired
   private PeisongyuanxinxiMapper gdao;
	@Override
	public int add(Peisongyuanxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Peisongyuanxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Peisongyuanxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Peisongyuanxinxi> getsypeisongyuanxinxi1(Map<String, Object> map) {
		return gdao.getsypeisongyuanxinxi1(map);
	}
	public List<Peisongyuanxinxi> getsypeisongyuanxinxi2(Map<String, Object> map) {
		return gdao.getsypeisongyuanxinxi2(map);
	}
	public List<Peisongyuanxinxi> getsypeisongyuanxinxi3(Map<String, Object> map) {
		return gdao.getsypeisongyuanxinxi3(map);
	}
	
	@Override
	public Peisongyuanxinxi quchongPeisongyuanxinxi(Map<String, Object> account) {
		return gdao.quchongPeisongyuanxinxi(account);
	}

	@Override
	public List<Peisongyuanxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Peisongyuanxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Peisongyuanxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

