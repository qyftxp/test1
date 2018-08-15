package com.yc.biz.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yc.bean.District;
import com.yc.bean.Street;
import com.yc.biz.DistrictBiz;
import com.yc.dao.BaseDao;
@Service
public class DistrictBizImpl implements DistrictBiz {
	
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao baseDao;

	@Override
	public List<District> getDistrictList() {
		List<District> districts=null;
		districts=baseDao.findAll(District.class, "findAllDistrict");
		return districts;
	}

	@Override
	public List<Street> getStreetByDistrictId(Integer did) {
		List<Street> streets=null;
		Map<String,String> map=new HashMap<String,String>();
		map.put("did", did+"");
		streets=baseDao.findAll(Street.class,"getStreetByDistrict",map);
		return streets;
	}

}
