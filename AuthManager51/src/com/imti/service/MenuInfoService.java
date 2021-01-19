package com.imti.service;

import java.util.List;

import com.imti.model.MenuInfo;

import net.sf.json.JSONArray;

/**@�ļ���: MenuInfoService.java
 * @�๦��˵��: 
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��5������9:57:37
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��5������9:57:37</li> 
 *	 <li>����: </li>
 * </pre>
 */
public interface MenuInfoService {

	public JSONArray findMenuInfoByParentId(int parentId,List<String> meunIds);
	
	public List<String> getCurrentUserOwerMenus(int user_id);
	
	public JSONArray findAllMeunInfoByRoleId(int parentId,int role_id);
	
	public int saveRoleAndMenu(int role_id,String menuIds);
	
	public List<MenuInfo> findAllMenuInfo(int parentId);
	
	public int addMenuInfo(MenuInfo menuInfo);
}
