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

import com.entity.Chukudingdan;
import com.service.ChukudingdanServer;
import com.util.PageBean;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ChukudingdanController {
	@Resource
	private ChukudingdanServer chukudingdanService;


   
	@RequestMapping("addChukudingdan.do")
	public String addChukudingdan(HttpServletRequest request,Chukudingdan chukudingdan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		chukudingdan.setAddtime(time.toString().substring(0, 19));
		chukudingdanService.add(chukudingdan);
		db dbo = new db();dbo.hsgexecute("update huowuxinxi set kucun=kucun-"+chukudingdan.getGoumaishuliang()+" where huowumingcheng='"+chukudingdan.getHuowumingcheng()+"'");
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "chukudingdanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:chukudingdanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateChukudingdan.do")
	public String doUpdateChukudingdan(int id,ModelMap map,Chukudingdan chukudingdan){
		chukudingdan=chukudingdanService.getById(id);
		map.put("chukudingdan", chukudingdan);
		return "chukudingdan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("chukudingdanDetail.do")
	public String chukudingdanDetail(int id,ModelMap map,Chukudingdan chukudingdan){
		chukudingdan=chukudingdanService.getById(id);
		map.put("chukudingdan", chukudingdan);
		return "chukudingdan_detail";
	}
//	前台详细
	@RequestMapping("ckddDetail.do")
	public String ckddDetail(int id,ModelMap map,Chukudingdan chukudingdan){
		chukudingdan=chukudingdanService.getById(id);
		map.put("chukudingdan", chukudingdan);
		return "chukudingdandetail";
	}
//	
	@RequestMapping("updateChukudingdan.do")
	public String updateChukudingdan(int id,ModelMap map,Chukudingdan chukudingdan,HttpServletRequest request,HttpSession session){
		chukudingdanService.update(chukudingdan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:chukudingdanList.do";
	}

//	分页查询
	@RequestMapping("chukudingdanList.do")
	public String chukudingdanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdan_list";
	}
	
	@RequestMapping("chukudingdan_yanben1.do")
	public String chukudingdan_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdan_yanben1";
	}
	@RequestMapping("chukudingdan_yanben2.do")
	public String chukudingdan_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdan_yanben2";
	}
	@RequestMapping("chukudingdan_yanben3.do")
	public String chukudingdan_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdan_yanben3";
	}
	@RequestMapping("chukudingdan_yanben4.do")
	public String chukudingdan_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdan_yanben4";
	}
	@RequestMapping("chukudingdan_yanben5.do")
	public String chukudingdan_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdan_yanben5";
	}
	
	@RequestMapping("chukudingdanList2.do")
	public String chukudingdanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen,HttpServletRequest request){
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
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdan_list2";
	}
	
	
	@RequestMapping("ckddList.do")
	public String ckddList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdanlist";
	}
	@RequestMapping("ckddListtp.do")
	public String ckddListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Chukudingdan chukudingdan, String dingdanbianhao, String huowumingcheng, String huowuleixing, String kucun, String jiage, String goumaishuliang1,String goumaishuliang2, String jine, String goumairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanbianhao==null||dingdanbianhao.equals("")){pmap.put("dingdanbianhao", null);}else{pmap.put("dingdanbianhao", dingdanbianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(goumaishuliang1==null||goumaishuliang1.equals("")){pmap.put("goumaishuliang1", null);}else{pmap.put("goumaishuliang1", goumaishuliang1);}
		if(goumaishuliang2==null||goumaishuliang2.equals("")){pmap.put("goumaishuliang2", null);}else{pmap.put("goumaishuliang2", goumaishuliang2);}
		if(jine==null||jine.equals("")){pmap.put("jine", null);}else{pmap.put("jine", jine);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=chukudingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Chukudingdan> list=chukudingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "chukudingdanlisttp";
	}
	
	@RequestMapping("deleteChukudingdan.do")
	public String deleteChukudingdan(int id,HttpServletRequest request){
		chukudingdanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:chukudingdanList.do";
	}
	
	
}
