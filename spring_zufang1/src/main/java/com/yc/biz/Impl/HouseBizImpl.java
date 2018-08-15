package com.yc.biz.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.House;
import com.yc.biz.HouseBiz;
import com.yc.dao.BaseDao;
import com.yc.web.model.JsonModel;

@Service
public class HouseBizImpl implements HouseBiz {
	
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao baseDao;

	@Override
	public House getHouseBean(House hb) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("id", hb.getId()+"");
		List<House> list=(List<House>)this.baseDao.findOne(hb,"findHouseCondition");
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public boolean addHouse(House house) {
			baseDao.save(house, "saveHouse");
			return true;
	}

	@Override
	public boolean updateHouse(House house) {
			baseDao.update(house, "updateHouse");
			return true;
	}

	@Override
	public boolean delHouse(int id) {
			baseDao.del(House.class, "delSingleHouse",id+"");
			return true;
	}


	
	@Override
	public boolean delHouse(List<Integer> ids) {
			baseDao.del(House.class, "delMutilHouse",ids);
		return true;
	}

	@Override
	public JsonModel<House> serachHouse(Map<String, Object> map) {
		List<House> list=baseDao.findAll(House.class, "findHouseCondition",map);
		int total=(int)baseDao.getFunc(House.class,"findHouseConditionCount",map);
		JsonModel<House> jsonModel=new JsonModel<House>();
		jsonModel.setRows(list);
		jsonModel.setTotal(total);
		jsonModel.setPages(Integer.parseInt(map.get("pages").toString()));
		jsonModel.setPageSize(Integer.parseInt(map.get("pagesize").toString()));
		return jsonModel;
	}

}
