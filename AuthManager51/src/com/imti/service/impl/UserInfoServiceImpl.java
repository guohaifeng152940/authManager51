package com.imti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imti.dao.UserInfoDao;
import com.imti.model.UserInfo;
import com.imti.service.UserInfoService;
import com.imti.util.Md5;
import com.imti.util.UUIDUtil;

/**@�ļ���: UserInfoServiceImpl.java
 * @�๦��˵��: �û������ʵ����
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��4������10:02:59
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��4������10:02:59</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;	//��dao�ӿ�����serviceʵ����
	
	/**
	 * �û�������¼�ӿڵ�ʵ��
	 */
	@Override
	public UserInfo login(UserInfo userInfo) {
		return userInfoDao.login(userInfo);
	}

	@Override
	public List<UserInfo> findAllUserInfo(Map<String,Object> map) {
		return userInfoDao.findAllUserInfo(map);
	}

	@Override
	public int findAllUserInfoCount(Map<String, Object> map) {
		return userInfoDao.findAllUserInfoCount(map);
	}

	@Override
	public int findUserNameIsExist(String userName) {
		return userInfoDao.findUserNameIsExist(userName);
	}

	@Override
	public int addUserInfo(UserInfo userInfo) {
		userInfo.setUser_code(UUIDUtil.getUUID());
		return userInfoDao.addUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(UserInfo userInfo) {
		String user_pwd=userInfoDao.findPasswordByUserId(userInfo.getUser_id());
		if(!user_pwd.equals(userInfo.getUser_pwd())) {
			userInfo.setUser_pwd(Md5.MD5(Md5.MD5(userInfo.getUser_pwd())+userInfo.getUser_name()));
		}
		return userInfoDao.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String userIds) {
		String strs[]=userIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			result+=userInfoDao.deleteUserInfo(Integer.parseInt(strs[i]));
		}
		return result;
	}

	@Override
	public int insertUserAndRole(int user_id, String roleIds) {
		userInfoDao.deleteUserOwerRoleByUid(user_id);
		String strs[]=roleIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("user_id", user_id);
			map.put("role_id", Integer.parseInt(strs[i]));
			result+=userInfoDao.insertUserAndRole(map);
		}
		return result;
	}

	@Override
	public int deleteUserOwerRole(int user_id) {
		return userInfoDao.deleteUserOwerRoleByUid(user_id);
	}

}
