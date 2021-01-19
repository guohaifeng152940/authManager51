package com.imti.service;

import java.util.List;
import java.util.Map;

import com.imti.model.RoleInfo;

import net.sf.json.JSONArray;

/**@文件名: RoleInfoService.java
 * @类功能说明: 
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月7日下午1:55:30
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月7日下午1:55:30</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface RoleInfoService {

	public JSONArray findAllRoleInfoForUser(int user_id);
	
	public List<RoleInfo> findAllRoleInfo(Map<String,Object> map);
	
	public int findAllRoleInfoCount(Map<String,Object> map);
	
	
}
