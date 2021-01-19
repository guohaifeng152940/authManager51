package com.imti.service;

import java.util.List;

import com.imti.model.MenuInfo;

import net.sf.json.JSONArray;

/**@文件名: MenuInfoService.java
 * @类功能说明: 
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月5日上午9:57:37
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月5日上午9:57:37</li> 
 *	 <li>内容: </li>
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
