package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;

/**@�ļ���: RoleInfoDao.java
 * @�๦��˵��: 
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��7������1:49:54
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��7������1:49:54</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface RoleInfoDao {

	public List<RoleInfo> findAllRoleInfoForUser();
	
	public List<Integer> findUserOwerRolesByUId(int user_id);
	
	public List<RoleInfo> findAllRoleInfo(Map<String,Object> map);
	
	public int findAllRoleInfoCount(Map<String,Object> map);
}
