package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@文件名: UserInfoDao.java
 * @类功能说明: 用户持久层dao接口
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月4日上午9:55:08
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月4日上午9:55:08</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface UserInfoDao {

	/**
	 * @方法名: login
	 * @方法说明: 用户持久层登录接口
	 * @作者: GuoHaiFeng
	 * @邮箱：1191619897@qq.com
	 * @日期: 2021年1月4日上午10:01:56
	 * @param userInfo
	 * @return: UserInfo
	 */
	public UserInfo login(UserInfo userInfo);
	
	public List<String> getCurrentUserOwerMenus(int user_id);
	
	public List<UserInfo> findAllUserInfo(Map<String,Object> map);
	
	public int findAllUserInfoCount(Map<String,Object> map);
	
	public int findUserNameIsExist(String userName);
	
	public int addUserInfo(UserInfo userInfo);
	
	public String findPasswordByUserId(int user_id);
	
	public int updateUserInfo(UserInfo userInfo);
	
	public int deleteUserInfo(int user_id);
	
	public int deleteUserOwerRoleByUid(int user_id);
	
	public int insertUserAndRole(Map<String,Object> map);
}
