package com.yc.dao.Impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.yc.dao.BaseDao;

@Repository(value="baseDaoMybatisImpl")
public class BaseDaoMybatisImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
	private final String MAPPERPATH="com.yc.bean.";
	

	
	//重写了父类的setSqlSessionTemplate方法实现注入sqlSessionTemplate
	//为什么重写？如果不重写的话,则需要到xml配置spring
	
	@Resource(name="sqlSession")
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	

	@Override
	public void save(T t, String sqlId) {
		super.getSqlSession().insert(MAPPERPATH+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}
	
	

	@Override
	public void save(Class<T> clazz, String sqlId,Map<String,Object> parameterMap) {
		super.getSqlSession().insert(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}
	
	@Override
	public void save(Class<T> clazz, String sqlId,List<T> list) {
		super.getSqlSession().insert(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,list);
	}
	
	@Override
	public void update(Class<T> clazz, String sqlId) {
		super.getSqlSession().update(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId);
	}
	
	
	@Override
	public void update(T t, String sqlId) {
		super.getSqlSession().update(MAPPERPATH+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}

	@Override
	public void del(Class<T> clazz, String sqlId, String id) {
		super.getSqlSession().delete(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,id);
	}

	
	@Override
	public void del(T t, String sqlId) {
		super.getSqlSession().delete(MAPPERPATH+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}
	
	@Override
	public void del(Class<T> clazz,String sqlId,Map<String,Object> parameterMap) {
		super.getSqlSession().delete(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}

	@Override
	public void del(Class<T> clazz, String sqlId,List<Object> ids) {
		super.getSqlSession().delete(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,ids);
	}

	@Override
	public List<T> findAll(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
		return super.getSqlSession().selectList(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}

	@Override
	public List<T> findAll(T t, String sqlId) {
		return super.getSqlSession().selectList(MAPPERPATH+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}
	
	@Override
	public List<T> findAll(Class<T> clazz, String sqlId) {
		return super.getSqlSession().selectList(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId);
	}


	@Override
	public List<T> findList(Class<T> clazz, Map<String, Object> map, String sqlId, int offset, int sizePage) {
		return super.getSqlSession().selectList(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId);
	}

	@Override
	public int getCount(Class<T> clazz, String sqlId) {
		return super.getSqlSession().selectOne(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId);
	}
	
	@Override
	public int getCount(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
		return super.getSqlSession().selectOne(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}
	
	@Override
	public int getCount(T t, String sqlId) {
		return super.getSqlSession().selectOne(MAPPERPATH+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}
	

	@Override
	public int getFunc(Class<T> clazz, String sqlId) {
		return super.getSqlSession().selectOne(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId);
	}
	
	@Override
	public int getFunc(T t, String sqlId) {
		return super.getSqlSession().selectOne(MAPPERPATH+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
	}

	@Override
	public int getFunc(Class<T> clazz, String sqlId,Map<String, Object> parameterMap) {
		return super.getSqlSession().selectOne(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
	}


	@Override
	public void del(Class<T> clazz, String sqlId) {
		super.getSqlSession().delete(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId);
	
	}

	@Override
	public T findOne(T t, String sqlId) {
		List<T> list=super.getSqlSession().selectList(MAPPERPATH+t.getClass().getSimpleName()+"Mapper."+sqlId,t);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public T findOne(Class<T> clazz, String sqlId) {
		List<T> list=super.getSqlSession().selectList(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public T findOne(Class<T> clazz, String sqlId, Map<String, Object> parameterMap) {
		List<T> list=super.getSqlSession().selectList(MAPPERPATH+clazz.getSimpleName()+"Mapper."+sqlId,parameterMap);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	
}
