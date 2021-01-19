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

/**@文件名: UserInfoServiceImpl.java
 * @类功能说明: 用户处理层实现类
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月4日上午10:02:59
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月4日上午10:02:59</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoDao userInfoDao;	//将dao接口引入service实现类
	
	/**
	 * 用户处理层登录接口的实现
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
