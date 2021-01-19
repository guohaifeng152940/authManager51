package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@文件名: UserInfoService.java
 * @类功能说明: 用户处理层Service接口
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月4日上午10:00:30
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月4日上午10:00:30</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface UserInfoService {

	/**
	 * @方法名: login
	 * @方法说明: 用户处理层登录接口
	 * @作者: GuoHaiFeng
	 * @邮箱：1191619897@qq.com
	 * @日期: 2021年1月4日上午10:02:26
	 * @param userInfo
	 * @return: UserInfo
	 */
	public UserInfo login(UserInfo userInfo);
	
	public List<UserInfo> findAllUserInfo(Map<String,Object> map);
	
	public int findAllUserInfoCount(Map<String,Object> map);
	
	public int findUserNameIsExist(String userName);
	
	public int addUserInfo(UserInfo userInfo);
	
	public int updateUserInfo(UserInfo userInfo);
	
	public int deleteUserInfo(String userIds);
	
	public int insertUserAndRole(int user_id,String roleIds);
	
	public int deleteUserOwerRole(int user_id);
}
