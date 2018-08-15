package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.House;
import com.yc.web.model.JsonModel;

public interface HouseBiz {
	/**
	 * 根据id查某个房子的信息
	 * @param hb
	 * @return
	 */
	public House getHouseBean(House hb);
	
	public boolean addHouse(House house);
	
	public boolean updateHouse(House house);
	
	public boolean delHouse(int id);
	
	public boolean delHouse(List<Integer> ids);
	
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public JsonModel<House> serachHouse(Map<String,Object> map);
	
	/*public HouseBean serachHouse(Map<String,Object> map);*/
}
