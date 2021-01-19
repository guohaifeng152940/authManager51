package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.UserInfo;

/**@�ļ���: UserInfoDao.java
 * @�๦��˵��: �û��־ò�dao�ӿ�
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��4������9:55:08
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��4������9:55:08</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface UserInfoDao {

	/**
	 * @������: login
	 * @����˵��: �û��־ò��¼�ӿ�
	 * @����: GuoHaiFeng
	 * @���䣺1191619897@qq.com
	 * @����: 2021��1��4������10:01:56
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
