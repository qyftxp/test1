package com.yc.web.controllors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.House;
import com.yc.bean.User;
import com.yc.biz.HouseBiz;
import com.yc.web.model.JsonModel;

@Controller
public class HouseController {
		@Resource(name="houseBizImpl")
		private HouseBiz houseBiz;
	
		@RequestMapping("house_list.action")
		public String houseList(HttpServletRequest request,
								HttpSession session,
								@RequestParam(name="pages") Integer pages,
								@RequestParam(name="pagesize")Integer pagesize){
			Map<String,Object> map=new HashMap<String,Object>();
			Integer start=(pages-1)*pagesize;
			map.put("pages", pages);
			map.put("pagesize", pagesize);
			map.put("start", start);
			JsonModel jsonModel=houseBiz.serachHouse(map);
			request.setAttribute("jsonModel", jsonModel);
			session.setAttribute("list", jsonModel.getRows());
			return "showList";
		}
		
		@RequestMapping("/user/house_toAdd.action")
		public String houseToAdd(){
			return "add";
			/*request.setAttribute("TOKEN", 1);
			return "add";*/
		}
		
		
		@RequestMapping("/user/house_doAdd.action")
		public String houseDoAdd(House house,HttpSession session){
			User user=(User) session.getAttribute("user");
			house.setUser_id(user.getId());
			boolean result=houseBiz.addHouse(house);
			
			//TODO:要利用重定向防止用户重复提交,但重定向不能定向到/WEB-INF/下面
			return "list";
			/*if(request.getAttribute("TOKEN") !=null){
			User user=(User) session.getAttribute("user");
			house.setUser_id(user.getId());
			boolean result=houseBiz.addHouse(house);
			session.setAttribute("TOKEN", null);
			session.removeAttribute("TOKEN");
		}*/
			
		}
		
		
		@RequestMapping("/user/house_toUpdate.action")
		public String houseToUpdate(@RequestParam Integer id,HttpSession session,HttpServletRequest request){
			//查出id代表的House对象
			List<House> list=(List<House>) session.getAttribute("list");
			for(House h:list){
				if(h.getId().intValue()==id.intValue()){
					session.setAttribute("house", h);
					break;
				}
			}
			return "update";
		}
		
		
		@RequestMapping("/user/house_doUpdate.action")
		public String houseDoUpdate(House house,HttpSession session){
			User user=(User) session.getAttribute("user");
			house.setUser_id(user.getId());
			boolean result=houseBiz.updateHouse(house);
			
			return "list";
		}
		
		
		
		@RequestMapping("/user/house_del.action")
		public @ResponseBody JsonModel houseDel(@RequestParam Integer id){
			JsonModel jsonModel=new JsonModel();
			boolean r=houseBiz.delHouse(id);
			
			if(r){
				jsonModel.setCode(1);
			}else{
				jsonModel.setCode(0);
			}
			return jsonModel;
		}
}
