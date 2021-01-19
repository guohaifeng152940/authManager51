package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;

import net.sf.json.JSONArray;

/**@�ļ���: RoleInfoService.java
 * @�๦��˵��: 
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��7������1:55:30
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��7������1:55:30</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface RoleInfoService {

	public JSONArray findAllRoleInfoForUser(int user_id);
	
	public List<RoleInfo> findAllRoleInfo(Map<String,Object> map);
	
	public int findAllRoleInfoCount(Map<String,Object> map);
	
	
}
