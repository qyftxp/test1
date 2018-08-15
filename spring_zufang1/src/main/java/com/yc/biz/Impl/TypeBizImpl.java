package com.yc.biz.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.yc.bean.HouseType;
import com.yc.biz.HouseTypeBiz;
import com.yc.dao.BaseDao;

@Service
public class TypeBizImpl implements HouseTypeBiz {
	
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao baseDao;
	
	@Override
	public List<HouseType> getTypeList() {
		List<HouseType> types=null;
		types=baseDao.findAll(HouseType.class, "getAllHouseType");
		return types;
	}

}
