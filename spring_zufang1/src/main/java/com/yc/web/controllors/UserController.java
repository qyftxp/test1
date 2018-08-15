package com.yc.web.controllors;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.web.model.JsonModel;

@RestController    //类注解同时使用@Controller 和@ResponseBody
public class UserController {
	@Resource(name="useBizImpl")
	private UserBiz userBiz;
	
	@RequestMapping("/user_register.action")
	public JsonModel register(User user){
		JsonModel jm=new JsonModel();
		boolean result=userBiz.register(user);
		if(result){
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		return jm;
	}
	
	@RequestMapping("user/user_logout.action")
	public void logout(HttpSession session,HttpServletResponse response){
		//ModelAndView mav=new ModelAndView();
		session.removeAttribute("user");
		/*mav.setViewName("login");
		return mav;*/
		//退出方式改为重定向
		try {
			response.sendRedirect("../index.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/user_login.action")
	//因为登录后是要直接到list.jsp页做显示,且login.jsp页是通过submit提交的,即不支持ajax,不用回送json数据,而应回送是一个页面名字,
	//这样springmvc的视图解析器就可以运行了
	public ModelAndView login(User user,HttpServletRequest request,HttpSession session){
		//为什么有三个参数?因为name,password是User对象中有的,但zccode是在类中没有的饿,所以要通过request获取
		//另外,sRand是存在session中的,所以还需要HttpSession
		ModelAndView mav=new ModelAndView();
		String zccode=request.getParameter("zccode");
		String sRand=session.getAttribute("sRand").toString();
		if(! sRand.equals(zccode)){
			request.setAttribute("errormsg", "验证码错误");
		}else{
			user=userBiz.login(user);
			if(user!=null){
				session.setAttribute("user", user);
				mav.setViewName("list");
				return mav;
			}else{
				request.setAttribute("errormsg","用户名或密码错误");
			}
		}
		mav.setViewName("login");
		return mav;
	}
	
}
