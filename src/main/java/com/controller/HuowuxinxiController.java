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

import com.entity.Huowuxinxi;
import com.service.HuowuxinxiServer;
import com.util.PageBean;


import java.sql.SQLException;
import java.sql.*;
@Controller
public class HuowuxinxiController {
	@Resource
	private HuowuxinxiServer huowuxinxiService;


   
	@RequestMapping("addHuowuxinxi.do")
	public String addHuowuxinxi(HttpServletRequest request,Huowuxinxi huowuxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		huowuxinxi.setAddtime(time.toString().substring(0, 19));
		huowuxinxiService.add(huowuxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "huowuxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:huowuxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHuowuxinxi.do")
	public String doUpdateHuowuxinxi(int id,ModelMap map,Huowuxinxi huowuxinxi){
		huowuxinxi=huowuxinxiService.getById(id);
		map.put("huowuxinxi", huowuxinxi);
		return "huowuxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("huowuxinxiDetail.do")
	public String huowuxinxiDetail(int id,ModelMap map,Huowuxinxi huowuxinxi){
		huowuxinxi=huowuxinxiService.getById(id);
		map.put("huowuxinxi", huowuxinxi);
		return "huowuxinxi_detail";
	}
//	前台详细
	@RequestMapping("hwxxDetail.do")
	public String hwxxDetail(int id,ModelMap map,Huowuxinxi huowuxinxi){
		huowuxinxi=huowuxinxiService.getById(id);
		map.put("huowuxinxi", huowuxinxi);
		return "huowuxinxidetail";
	}
//	
	@RequestMapping("updateHuowuxinxi.do")
	public String updateHuowuxinxi(int id,ModelMap map,Huowuxinxi huowuxinxi,HttpServletRequest request,HttpSession session){
		huowuxinxiService.update(huowuxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:huowuxinxiList.do";
	}

//	分页查询
	@RequestMapping("huowuxinxiList.do")
	public String huowuxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huowuxinxi huowuxinxi, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun1,String kucun2, String jiage, String shiwutu, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shiwutu==null||shiwutu.equals("")){pmap.put("shiwutu", null);}else{pmap.put("shiwutu", shiwutu);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huowuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huowuxinxi> list=huowuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huowuxinxi_list";
	}
	
	@RequestMapping("huowuxinxi_yanben1.do")
	public String huowuxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huowuxinxi huowuxinxi, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun1,String kucun2, String jiage, String shiwutu, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shiwutu==null||shiwutu.equals("")){pmap.put("shiwutu", null);}else{pmap.put("shiwutu", shiwutu);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huowuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huowuxinxi> list=huowuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huowuxinxi_yanben1";
	}
	@RequestMapping("huowuxinxi_yanben2.do")
	public String huowuxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huowuxinxi huowuxinxi, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun1,String kucun2, String jiage, String shiwutu, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shiwutu==null||shiwutu.equals("")){pmap.put("shiwutu", null);}else{pmap.put("shiwutu", shiwutu);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huowuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huowuxinxi> list=huowuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huowuxinxi_yanben2";
	}
	@RequestMapping("huowuxinxi_yanben3.do")
	public String huowuxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huowuxinxi huowuxinxi, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun1,String kucun2, String jiage, String shiwutu, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shiwutu==null||shiwutu.equals("")){pmap.put("shiwutu", null);}else{pmap.put("shiwutu", shiwutu);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huowuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huowuxinxi> list=huowuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huowuxinxi_yanben3";
	}
	@RequestMapping("huowuxinxi_yanben4.do")
	public String huowuxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huowuxinxi huowuxinxi, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun1,String kucun2, String jiage, String shiwutu, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shiwutu==null||shiwutu.equals("")){pmap.put("shiwutu", null);}else{pmap.put("shiwutu", shiwutu);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huowuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huowuxinxi> list=huowuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huowuxinxi_yanben4";
	}
	@RequestMapping("huowuxinxi_yanben5.do")
	public String huowuxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huowuxinxi huowuxinxi, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun1,String kucun2, String jiage, String shiwutu, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shiwutu==null||shiwutu.equals("")){pmap.put("shiwutu", null);}else{pmap.put("shiwutu", shiwutu);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huowuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huowuxinxi> list=huowuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huowuxinxi_yanben5";
	}
	
	
	
	@RequestMapping("hwxxList.do")
	public String hwxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huowuxinxi huowuxinxi, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun1,String kucun2, String jiage, String shiwutu, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shiwutu==null||shiwutu.equals("")){pmap.put("shiwutu", null);}else{pmap.put("shiwutu", shiwutu);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huowuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huowuxinxi> list=huowuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huowuxinxilist";
	}
	@RequestMapping("hwxxListtp.do")
	public String hwxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Huowuxinxi huowuxinxi, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun1,String kucun2, String jiage, String shiwutu, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 8);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 8);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}
		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(shiwutu==null||shiwutu.equals("")){pmap.put("shiwutu", null);}else{pmap.put("shiwutu", shiwutu);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=huowuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Huowuxinxi> list=huowuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "huowuxinxilisttp";
	}
	
	@RequestMapping("deleteHuowuxinxi.do")
	public String deleteHuowuxinxi(int id,HttpServletRequest request){
		huowuxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:huowuxinxiList.do";
	}
	
	@RequestMapping("quchongHuowuxinxi.do")
	public void quchongHuowuxinxi(Huowuxinxi huowuxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("huowubianhao", huowuxinxi.getHuowubianhao());
		   System.out.println("huowubianhao==="+huowuxinxi.getHuowubianhao());
		   System.out.println("huowubianhao222==="+huowuxinxiService.quchongHuowuxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(huowuxinxiService.quchongHuowuxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "货物编号可以用！");
				  
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
