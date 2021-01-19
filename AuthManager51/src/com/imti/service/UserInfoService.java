package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@�ļ���: UserInfoService.java
 * @�๦��˵��: �û������Service�ӿ�
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��4������10:00:30
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��4������10:00:30</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface UserInfoService {

	/**
	 * @������: login
	 * @����˵��: �û�������¼�ӿ�
	 * @����: GuoHaiFeng
	 * @���䣺1191619897@qq.com
	 * @����: 2021��1��4������10:02:26
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
