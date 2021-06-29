package com.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import com.service.AllusersServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Allusers;

@Controller
public class hsgloginController {
	@Resource
	private AllusersServer allusersServer;

	@RequestMapping("hsglogin.do")
	public String checkAllusersLogin(Allusers allusers, HttpSession session) {
		Map<String,Object> u=new HashMap<String,Object>();
		System.out.println("name===" + allusers.getUsername());
		u.put("username",allusers.getUsername());
		//u.put("utype", "用户");
		//Md5.MD5HexEncode(user.getPassword())
		u.put("pwd",allusers.getPwd());
		allusers = allusersServer.allusersLogin(u);
		if (allusers != null) {
			session.setAttribute("username", allusers);
			System.out.println("username=" + allusers);
			session.removeAttribute("suc");
			return "redirect:index.do";
		} else {
			System.out.println("usernafwfwwme=");
			session.setAttribute("suc", "登录失败！用户名或密码错误！");
			return "login";
		}

	}
}
