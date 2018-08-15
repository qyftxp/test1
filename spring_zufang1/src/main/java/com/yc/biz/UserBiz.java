package com.yc.biz;

import com.yc.bean.User;

public interface UserBiz {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public boolean register(User user);
	
	/**
	 * 用户名是否存在
	 * @param user
	 * @return
	 */
	public boolean validate(User user);
	
	/**
	 * 根据id查用户
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user);
}
