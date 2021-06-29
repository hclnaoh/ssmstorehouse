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

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Dingdangenzong;
import com.service.DingdangenzongServer;
import com.util.PageBean;


import java.sql.SQLException;
import java.sql.*;
@Controller
public class DingdangenzongController {
	@Resource
	private DingdangenzongServer dingdangenzongService;


   
	@RequestMapping("addDingdangenzong.do")
	public String addDingdangenzong(HttpServletRequest request,Dingdangenzong dingdangenzong,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		dingdangenzong.setAddtime(time.toString().substring(0, 19));
		dingdangenzongService.add(dingdangenzong);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "dingdangenzongList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:dingdangenzongList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDingdangenzong.do")
	public String doUpdateDingdangenzong(int id,ModelMap map,Dingdangenzong dingdangenzong){
		dingdangenzong=dingdangenzongService.getById(id);
		map.put("dingdangenzong", dingdangenzong);
		return "dingdangenzong_updt";
	}
	
	
	
	@RequestMapping("doUpdateDingdangenzonglb.do")
	public String doUpdateDingdangenzonglb(int id,ModelMap map,Dingdangenzong dingdangenzong){
		dingdangenzong=dingdangenzongService.getById(id);
		map.put("dingdangenzong", dingdangenzong);
		return "dingdangenzong_updtlb";
	}
	
@RequestMapping("updateDingdangenzonglb.do")
	public String updateDingdangenzonglb(int id,ModelMap map,Dingdangenzong dingdangenzong){
		dingdangenzongService.updatelb(dingdangenzong);
		return "redirect:dingdangenzongList.do";
	}
	
//	后台详细
	@RequestMapping("dingdangenzongDetail.do")
	public String dingdangenzongDetail(int id,ModelMap map,Dingdangenzong dingdangenzong){
		dingdangenzong=dingdangenzongService.getById(id);
		map.put("dingdangenzong", dingdangenzong);
		return "dingdangenzong_detail";
	}
//	前台详细
	@RequestMapping("ddgzDetail.do")
	public String ddgzDetail(int id,ModelMap map,Dingdangenzong dingdangenzong){
		dingdangenzong=dingdangenzongService.getById(id);
		map.put("dingdangenzong", dingdangenzong);
		return "dingdangenzongdetail";
	}
//	
	@RequestMapping("updateDingdangenzong.do")
	public String updateDingdangenzong(int id,ModelMap map,Dingdangenzong dingdangenzong,HttpServletRequest request,HttpSession session){
		dingdangenzongService.update(dingdangenzong);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:dingdangenzongList.do";
	}

//	分页查询
	@RequestMapping("dingdangenzongList.do")
	public String dingdangenzongList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzong_list";
	}
	
	@RequestMapping("dingdangenzong_yanben1.do")
	public String dingdangenzong_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzong_yanben1";
	}
	@RequestMapping("dingdangenzong_yanben2.do")
	public String dingdangenzong_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzong_yanben2";
	}
	@RequestMapping("dingdangenzong_yanben3.do")
	public String dingdangenzong_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzong_yanben3";
	}
	@RequestMapping("dingdangenzong_yanben4.do")
	public String dingdangenzong_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzong_yanben4";
	}
	@RequestMapping("dingdangenzong_yanben5.do")
	public String dingdangenzong_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzong_yanben5";
	}
	
	@RequestMapping("dingdangenzongList3.do")
	public String dingdangenzongList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("goumairen", (String)request.getSession().getAttribute("username"));
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzong_list3";
	}
	@RequestMapping("dingdangenzongList2.do")
	public String dingdangenzongList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzong_list2";
	}
	
	
	@RequestMapping("ddgzList.do")
	public String ddgzList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzonglist";
	}
	@RequestMapping("ddgzListtp.do")
	public String ddgzListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdangenzong dingdangenzong, String dingdanbianhao, String huowumingcheng, String goumaishuliang, String goumairen, String chepaihao, String gonghao, String peisongyuanxingming, String lianxidianhua, String dingdanzhuangtai){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(goumaishuliang==null||goumaishuliang.equals("")){pmap.put("goumaishuliang", null);}else{pmap.put("goumaishuliang", goumaishuliang);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(peisongyuanxingming==null||peisongyuanxingming.equals("")){pmap.put("peisongyuanxingming", null);}else{pmap.put("peisongyuanxingming", peisongyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		
		int total=dingdangenzongService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdangenzong> list=dingdangenzongService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdangenzonglisttp";
	}
	
	@RequestMapping("deleteDingdangenzong.do")
	public String deleteDingdangenzong(int id,HttpServletRequest request){
		dingdangenzongService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:dingdangenzongList.do";
	}
	
	
}
