package com.yc.web.listeners;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.District;
import com.yc.bean.HouseType;
import com.yc.biz.DistrictBiz;
import com.yc.biz.HouseTypeBiz;

//ServletContextListener     ->监听容器的启动
/**
 * 当servlet容器一启动就会加载这个类
 * @author Administrator
 *
 */
public class InitListener implements ServletContextListener{
	 ApplicationContext ac;
	
	public InitListener(){
		
	}
	
	public void contextDestroyed(ServletContextEvent arg0){
		
	}
	
	public void contextInitialized(ServletContextEvent arg0){
		ServletContext application =arg0.getServletContext();
		//通过WebApplicationContextUtils得到Spring容器的实例
		 ac=WebApplicationContextUtils.getWebApplicationContext(application);
		//从spring容器中取tagBizImpl
		HouseTypeBiz  typeBiz=(HouseTypeBiz) ac.getBean("typeBizImpl");
	    List<HouseType> houseTypeList=typeBiz.getTypeList();
	    application.setAttribute("houseTypeList", houseTypeList);
	    DistrictBiz districtBiz=(DistrictBiz) ac.getBean("districtBizImpl");
	    List<District> districtList=districtBiz.getDistrictList();
	    application.setAttribute("districtList", districtList);
	}
}
