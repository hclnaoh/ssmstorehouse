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

import com.entity.Rukuguanli;
import com.service.RukuguanliServer;
import com.util.PageBean;

import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class RukuguanliController {
	@Resource
	private RukuguanliServer rukuguanliService;


   
	@RequestMapping("addRukuguanli.do")
	public String addRukuguanli(HttpServletRequest request,Rukuguanli rukuguanli,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		rukuguanli.setAddtime(time.toString().substring(0, 19));
		rukuguanliService.add(rukuguanli);
			db dbo = new db();dbo.hsgexecute("update huowuxinxi set kucun=kucun+"+rukuguanli.getRukushuliang()+" where huowubianhao='"+rukuguanli.getHuowubianhao()+"'");
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "rukuguanliList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:rukuguanliList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateRukuguanli.do")
	public String doUpdateRukuguanli(int id,ModelMap map,Rukuguanli rukuguanli){
		rukuguanli=rukuguanliService.getById(id);
		map.put("rukuguanli", rukuguanli);
		return "rukuguanli_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("rukuguanliDetail.do")
	public String rukuguanliDetail(int id,ModelMap map,Rukuguanli rukuguanli){
		rukuguanli=rukuguanliService.getById(id);
		map.put("rukuguanli", rukuguanli);
		return "rukuguanli_detail";
	}
//	前台详细
	@RequestMapping("rkglDetail.do")
	public String rkglDetail(int id,ModelMap map,Rukuguanli rukuguanli){
		rukuguanli=rukuguanliService.getById(id);
		map.put("rukuguanli", rukuguanli);
		return "rukuguanlidetail";
	}
//	
	@RequestMapping("updateRukuguanli.do")
	public String updateRukuguanli(int id,ModelMap map,Rukuguanli rukuguanli,HttpServletRequest request,HttpSession session){
		rukuguanliService.update(rukuguanli);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:rukuguanliList.do";
	}

//	分页查询
	@RequestMapping("rukuguanliList.do")
	public String rukuguanliList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuguanli rukuguanli, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun, String rukushuliang1,String rukushuliang2, String rukushijian1,String rukushijian2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(rukushuliang1==null||rukushuliang1.equals("")){pmap.put("rukushuliang1", null);}else{pmap.put("rukushuliang1", rukushuliang1);}
		if(rukushuliang2==null||rukushuliang2.equals("")){pmap.put("rukushuliang2", null);}else{pmap.put("rukushuliang2", rukushuliang2);}
		if(rukushijian1==null||rukushijian1.equals("")){pmap.put("rukushijian1", null);}else{pmap.put("rukushijian1", rukushijian1);}
		if(rukushijian2==null||rukushijian2.equals("")){pmap.put("rukushijian2", null);}else{pmap.put("rukushijian2", rukushijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuguanli> list=rukuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuguanli_list";
	}
	
	@RequestMapping("rukuguanli_yanben1.do")
	public String rukuguanli_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuguanli rukuguanli, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun, String rukushuliang1,String rukushuliang2, String rukushijian1,String rukushijian2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(rukushuliang1==null||rukushuliang1.equals("")){pmap.put("rukushuliang1", null);}else{pmap.put("rukushuliang1", rukushuliang1);}
		if(rukushuliang2==null||rukushuliang2.equals("")){pmap.put("rukushuliang2", null);}else{pmap.put("rukushuliang2", rukushuliang2);}
		if(rukushijian1==null||rukushijian1.equals("")){pmap.put("rukushijian1", null);}else{pmap.put("rukushijian1", rukushijian1);}
		if(rukushijian2==null||rukushijian2.equals("")){pmap.put("rukushijian2", null);}else{pmap.put("rukushijian2", rukushijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuguanli> list=rukuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuguanli_yanben1";
	}
	@RequestMapping("rukuguanli_yanben2.do")
	public String rukuguanli_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuguanli rukuguanli, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun, String rukushuliang1,String rukushuliang2, String rukushijian1,String rukushijian2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(rukushuliang1==null||rukushuliang1.equals("")){pmap.put("rukushuliang1", null);}else{pmap.put("rukushuliang1", rukushuliang1);}
		if(rukushuliang2==null||rukushuliang2.equals("")){pmap.put("rukushuliang2", null);}else{pmap.put("rukushuliang2", rukushuliang2);}
		if(rukushijian1==null||rukushijian1.equals("")){pmap.put("rukushijian1", null);}else{pmap.put("rukushijian1", rukushijian1);}
		if(rukushijian2==null||rukushijian2.equals("")){pmap.put("rukushijian2", null);}else{pmap.put("rukushijian2", rukushijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuguanli> list=rukuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuguanli_yanben2";
	}
	@RequestMapping("rukuguanli_yanben3.do")
	public String rukuguanli_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuguanli rukuguanli, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun, String rukushuliang1,String rukushuliang2, String rukushijian1,String rukushijian2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(rukushuliang1==null||rukushuliang1.equals("")){pmap.put("rukushuliang1", null);}else{pmap.put("rukushuliang1", rukushuliang1);}
		if(rukushuliang2==null||rukushuliang2.equals("")){pmap.put("rukushuliang2", null);}else{pmap.put("rukushuliang2", rukushuliang2);}
		if(rukushijian1==null||rukushijian1.equals("")){pmap.put("rukushijian1", null);}else{pmap.put("rukushijian1", rukushijian1);}
		if(rukushijian2==null||rukushijian2.equals("")){pmap.put("rukushijian2", null);}else{pmap.put("rukushijian2", rukushijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuguanli> list=rukuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuguanli_yanben3";
	}
	@RequestMapping("rukuguanli_yanben4.do")
	public String rukuguanli_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuguanli rukuguanli, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun, String rukushuliang1,String rukushuliang2, String rukushijian1,String rukushijian2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(rukushuliang1==null||rukushuliang1.equals("")){pmap.put("rukushuliang1", null);}else{pmap.put("rukushuliang1", rukushuliang1);}
		if(rukushuliang2==null||rukushuliang2.equals("")){pmap.put("rukushuliang2", null);}else{pmap.put("rukushuliang2", rukushuliang2);}
		if(rukushijian1==null||rukushijian1.equals("")){pmap.put("rukushijian1", null);}else{pmap.put("rukushijian1", rukushijian1);}
		if(rukushijian2==null||rukushijian2.equals("")){pmap.put("rukushijian2", null);}else{pmap.put("rukushijian2", rukushijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuguanli> list=rukuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuguanli_yanben4";
	}
	@RequestMapping("rukuguanli_yanben5.do")
	public String rukuguanli_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuguanli rukuguanli, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun, String rukushuliang1,String rukushuliang2, String rukushijian1,String rukushijian2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(rukushuliang1==null||rukushuliang1.equals("")){pmap.put("rukushuliang1", null);}else{pmap.put("rukushuliang1", rukushuliang1);}
		if(rukushuliang2==null||rukushuliang2.equals("")){pmap.put("rukushuliang2", null);}else{pmap.put("rukushuliang2", rukushuliang2);}
		if(rukushijian1==null||rukushijian1.equals("")){pmap.put("rukushijian1", null);}else{pmap.put("rukushijian1", rukushijian1);}
		if(rukushijian2==null||rukushijian2.equals("")){pmap.put("rukushijian2", null);}else{pmap.put("rukushijian2", rukushijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuguanli> list=rukuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuguanli_yanben5";
	}
	
	
	
	@RequestMapping("rkglList.do")
	public String rkglList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuguanli rukuguanli, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun, String rukushuliang1,String rukushuliang2, String rukushijian1,String rukushijian2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(rukushuliang1==null||rukushuliang1.equals("")){pmap.put("rukushuliang1", null);}else{pmap.put("rukushuliang1", rukushuliang1);}
		if(rukushuliang2==null||rukushuliang2.equals("")){pmap.put("rukushuliang2", null);}else{pmap.put("rukushuliang2", rukushuliang2);}
		if(rukushijian1==null||rukushijian1.equals("")){pmap.put("rukushijian1", null);}else{pmap.put("rukushijian1", rukushijian1);}
		if(rukushijian2==null||rukushijian2.equals("")){pmap.put("rukushijian2", null);}else{pmap.put("rukushijian2", rukushijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuguanli> list=rukuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuguanlilist";
	}
	@RequestMapping("rkglListtp.do")
	public String rkglListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Rukuguanli rukuguanli, String huowubianhao, String huowumingcheng, String huowuleixing, String kucun, String rukushuliang1,String rukushuliang2, String rukushijian1,String rukushijian2, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(huowubianhao==null||huowubianhao.equals("")){pmap.put("huowubianhao", null);}else{pmap.put("huowubianhao", huowubianhao);}
		if(huowumingcheng==null||huowumingcheng.equals("")){pmap.put("huowumingcheng", null);}else{pmap.put("huowumingcheng", huowumingcheng);}
		if(huowuleixing==null||huowuleixing.equals("")){pmap.put("huowuleixing", null);}else{pmap.put("huowuleixing", huowuleixing);}
		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}
		if(rukushuliang1==null||rukushuliang1.equals("")){pmap.put("rukushuliang1", null);}else{pmap.put("rukushuliang1", rukushuliang1);}
		if(rukushuliang2==null||rukushuliang2.equals("")){pmap.put("rukushuliang2", null);}else{pmap.put("rukushuliang2", rukushuliang2);}
		if(rukushijian1==null||rukushijian1.equals("")){pmap.put("rukushijian1", null);}else{pmap.put("rukushijian1", rukushijian1);}
		if(rukushijian2==null||rukushijian2.equals("")){pmap.put("rukushijian2", null);}else{pmap.put("rukushijian2", rukushijian2);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=rukuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Rukuguanli> list=rukuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "rukuguanlilisttp";
	}
	
	@RequestMapping("deleteRukuguanli.do")
	public String deleteRukuguanli(int id,HttpServletRequest request){
		rukuguanliService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:rukuguanliList.do";
	}
	
	
}
