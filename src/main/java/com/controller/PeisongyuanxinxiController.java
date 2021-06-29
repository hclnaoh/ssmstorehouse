package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Peisongyuanxinxi;
import com.service.PeisongyuanxinxiServer;
import com.util.PageBean;

import java.sql.SQLException;
import java.sql.*;
@Controller
public class PeisongyuanxinxiController {
	@Resource
	private PeisongyuanxinxiServer peisongyuanxinxiService;


   
	@RequestMapping("addPeisongyuanxinxi.do")
	public String addPeisongyuanxinxi(HttpServletRequest request,Peisongyuanxinxi peisongyuanxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		peisongyuanxinxi.setAddtime(time.toString().substring(0, 19));
		peisongyuanxinxiService.add(peisongyuanxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "peisongyuanxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:peisongyuanxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdatePeisongyuanxinxi.do")
	public String doUpdatePeisongyuanxinxi(int id,ModelMap map,Peisongyuanxinxi peisongyuanxinxi){
		peisongyuanxinxi=peisongyuanxinxiService.getById(id);
		map.put("peisongyuanxinxi", peisongyuanxinxi);
		return "peisongyuanxinxi_updt";
	}
	
	@RequestMapping("doUpdatePeisongyuanxinxi2.do")
	public String doUpdatePeisongyuanxinxi2(ModelMap map,Peisongyuanxinxi peisongyuanxinxi,HttpServletRequest request){
		peisongyuanxinxi=peisongyuanxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("peisongyuanxinxi", peisongyuanxinxi);
		return "peisongyuanxinxi_updt2";
	}
	
@RequestMapping("updatePeisongyuanxinxi2.do")
	public String updatePeisongyuanxinxi2(int id,ModelMap map,Peisongyuanxinxi peisongyuanxinxi){
		peisongyuanxinxiService.update(peisongyuanxinxi);
		return "redirect:doUpdatePeisongyuanxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("peisongyuanxinxiDetail.do")
	public String peisongyuanxinxiDetail(int id,ModelMap map,Peisongyuanxinxi peisongyuanxinxi){
		peisongyuanxinxi=peisongyuanxinxiService.getById(id);
		map.put("peisongyuanxinxi", peisongyuanxinxi);
		return "peisongyuanxinxi_detail";
	}
//	前台详细
	@RequestMapping("psyxxDetail.do")
	public String psyxxDetail(int id,ModelMap map,Peisongyuanxinxi peisongyuanxinxi){
		peisongyuanxinxi=peisongyuanxinxiService.getById(id);
		map.put("peisongyuanxinxi", peisongyuanxinxi);
		return "peisongyuanxinxidetail";
	}
//	
	@RequestMapping("updatePeisongyuanxinxi.do")
	public String updatePeisongyuanxinxi(int id,ModelMap map,Peisongyuanxinxi peisongyuanxinxi,HttpServletRequest request,HttpSession session){
		peisongyuanxinxiService.update(peisongyuanxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:peisongyuanxinxiList.do";
	}

//	分页查询
	@RequestMapping("peisongyuanxinxiList.do")
	public String peisongyuanxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongyuanxinxi peisongyuanxinxi, String gonghao, String mima, String peisongyuanxingming, String xingbie, String nianling1,String nianling2, String lianxidianhua, String shenfenzheng, String zhuangtai, String zhaopian, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}
		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=peisongyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongyuanxinxi> list=peisongyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongyuanxinxi_list";
	}
	
	@RequestMapping("peisongyuanxinxi_yanben1.do")
	public String peisongyuanxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongyuanxinxi peisongyuanxinxi, String gonghao, String mima, String peisongyuanxingming, String xingbie, String nianling1,String nianling2, String lianxidianhua, String shenfenzheng, String zhuangtai, String zhaopian, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}
		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=peisongyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongyuanxinxi> list=peisongyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongyuanxinxi_yanben1";
	}
	@RequestMapping("peisongyuanxinxi_yanben2.do")
	public String peisongyuanxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongyuanxinxi peisongyuanxinxi, String gonghao, String mima, String peisongyuanxingming, String xingbie, String nianling1,String nianling2, String lianxidianhua, String shenfenzheng, String zhuangtai, String zhaopian, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}
		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=peisongyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongyuanxinxi> list=peisongyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongyuanxinxi_yanben2";
	}
	@RequestMapping("peisongyuanxinxi_yanben3.do")
	public String peisongyuanxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongyuanxinxi peisongyuanxinxi, String gonghao, String mima, String peisongyuanxingming, String xingbie, String nianling1,String nianling2, String lianxidianhua, String shenfenzheng, String zhuangtai, String zhaopian, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}
		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=peisongyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongyuanxinxi> list=peisongyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongyuanxinxi_yanben3";
	}
	@RequestMapping("peisongyuanxinxi_yanben4.do")
	public String peisongyuanxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongyuanxinxi peisongyuanxinxi, String gonghao, String mima, String peisongyuanxingming, String xingbie, String nianling1,String nianling2, String lianxidianhua, String shenfenzheng, String zhuangtai, String zhaopian, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}
		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=peisongyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongyuanxinxi> list=peisongyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongyuanxinxi_yanben4";
	}
	@RequestMapping("peisongyuanxinxi_yanben5.do")
	public String peisongyuanxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongyuanxinxi peisongyuanxinxi, String gonghao, String mima, String peisongyuanxingming, String xingbie, String nianling1,String nianling2, String lianxidianhua, String shenfenzheng, String zhuangtai, String zhaopian, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}
		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=peisongyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongyuanxinxi> list=peisongyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongyuanxinxi_yanben5";
	}
	
	
	
	@RequestMapping("psyxxList.do")
	public String psyxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongyuanxinxi peisongyuanxinxi, String gonghao, String mima, String peisongyuanxingming, String xingbie, String nianling1,String nianling2, String lianxidianhua, String shenfenzheng, String zhuangtai, String zhaopian, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}
		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=peisongyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongyuanxinxi> list=peisongyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongyuanxinxilist";
	}
	@RequestMapping("psyxxListtp.do")
	public String psyxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Peisongyuanxinxi peisongyuanxinxi, String gonghao, String mima, String peisongyuanxingming, String xingbie, String nianling1,String nianling2, String lianxidianhua, String shenfenzheng, String zhuangtai, String zhaopian, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(nianling1==null||nianling1.equals("")){pmap.put("nianling1", null);}else{pmap.put("nianling1", nianling1);}
		if(nianling2==null||nianling2.equals("")){pmap.put("nianling2", null);}else{pmap.put("nianling2", nianling2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}
		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=peisongyuanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Peisongyuanxinxi> list=peisongyuanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "peisongyuanxinxilisttp";
	}
	
	@RequestMapping("deletePeisongyuanxinxi.do")
	public String deletePeisongyuanxinxi(int id,HttpServletRequest request){
		peisongyuanxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:peisongyuanxinxiList.do";
	}
	
	@RequestMapping("quchongPeisongyuanxinxi.do")
	public void quchongPeisongyuanxinxi(Peisongyuanxinxi peisongyuanxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gonghao", peisongyuanxinxi.getGonghao());
		   System.out.println("gonghao==="+peisongyuanxinxi.getGonghao());
		   System.out.println("gonghao222==="+peisongyuanxinxiService.quchongPeisongyuanxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(peisongyuanxinxiService.quchongPeisongyuanxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "工号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
