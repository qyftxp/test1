package com.yc.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
	/**
	 * @param t:要保存的数据对象
	 * @param sqlId:
	 * 				mapper中的方法名
	 * 				“com.yc.bean.”+类名+“Mapper.”+sqlId
	 */
	public void save(T t,String sqlId);
	
	
	public void save(Class<T> clazz, String sqlId,Map<String,Object> parameterMap);
	
	public void save(Class<T> clazz, String sqlId,List<T> list);
	
	/**
	 * 更新对象<br/>
	 * @param t:带有参数的待更新对象
	 * @param sqlId:mapper中的方法名
	 */
	public void update(T t,String sqlId);
	
	public void update(Class<T> clazz, String sqlId);
	
	/**
	 * 只根据id删除一条数据<br/>
	 * @param clazz:对象的反射实例,用于确认mapper文件的位置
	 * @param id:要删除的数据的编号
	 * @param sqlId:mapper中的方法名
	 */
	public  void del(Class<T> clazz,String sqlId,String id);
	
	public void del(T t, String sqlId);
	
	public void del(Class<T> clazz,String sqlId,Map<String,Object> parameterMap);
	/**
	 * 根据ids删除多条数据<br />
	 * @param clazz:对象的反射实例,用于确认mapper文件的位置
	 * @param ids:要删除的数据的编号,它是一个集合,多个编号
	 * @param sqlId:mapper中的方法名
	 */
	public void del(Class<T> clazz, String sqlId,List<Object> ids);
	
	/**
	 * 删除数据<br/>
	 * @param clazz:对象的反射实例,用于确认mapper文件的位置
	 * @param sqlId:mapper中的方法名
	 */
	public void del(Class<T> clazz,String sqlId);
	
	/**
	 * 查集合,没有条件属性
	 * @param clazz:对象的反射实例,用于确认mapper文件的位置
	 * @param sqlId:mapper中的方法名
	 * @return 集合
	 */
	public List<T> findAll(Class<T> clazz,String sqlId,Map<String,Object> map);
	
	
	/**
	 * 查集合,条件查询
	 * @param t	条件对象,用于确认mapper文件的位置及条件值
	 * @param sqlId    mapper中的方法名
	 * @return	集合
	 */
	public List<T> findAll(T t,String sqlId);
	public List<T> findAll(Class<T> clazz, String sqlId);
	/**
	 * 条件查询,查一条数据<br/>
	 * @param t:条件对象,用于确认mapper文件的位置及条件值
	 * @param sqlId:mapper中的方法名
	 * @return 对象
	 */
	/*public T find(T t,String sqlId);*/

	public T findOne(T t,String sqlId);
	public T findOne(Class<T> clazz,String sqlId);
	public T findOne(Class<T> clazz,String sqlId,Map<String,Object> map);
	/**
	 * 根据条件分页查询<br/>
	 * @param clazz:用于确认mapper文件位置
	 * @param map:参数   键为字段名 值参数值 
	 * @param sqlId:mapper中的方法名
	 * @param offset:从第几条数据开始查
	 * @param sizePage:每页几条
	 * @return
	 */
	public List<T> findList(Class<T> clazz,Map<String,Object> map,String sqlId,int offset,int sizePage);


	/**
	 * 聚合查询<br/>
	 * @param clazz:用于确认mapper文件位置
	 * @param sqlId:mapper中的方法名
	 * @return
	 */
	public int getCount(Class<T> clazz,String sqlId);
	public int getCount(T t, String sqlId);
	
	/**
	 * 聚合查询<br/>
	* @param clazz:用于确认mapper文件位置
	 * @param sqlId:mapper中的方法名
	 * @return
	 */
	public int getFunc(Class<T> clazz,String sqlId);
	public int getFunc(T t, String sqlId);
	public int getFunc(Class<T> clazz, String sqlId,Map<String, Object> parameterMap);
	/**
	 * 根据条件聚合查询
	* @param clazz:用于确认mapper文件位置
	 * @param sqlId:mapper中的方法名
	 * @return
	 */
	public int getCount(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);
}
