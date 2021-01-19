package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.MenuInfo;

/**@文件名: MenuInfoDao.java
 * @类功能说明: 
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月5日上午9:48:32
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月5日上午9:48:32</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public interface MenuInfoDao {

	public List<MenuInfo> findMenuInfoByParentId(Map<String,Object> map);
	
	public List<String> getCurrentUserOwerMenus(int user_id);
	
	public List<MenuInfo> findAllMeunInfoByRoleId(Map<String,Object> map);
	
	public List<Integer> findRoleOwnerMenuByRoleId(int role_id);
	
	public int deleteRoleOldMeunByRoleId(int role_id);
	
	public int addRoleAndMenu(Map<String,Object> map);
	
	public List<MenuInfo> findAllMenuInfo(int parentId);
	
	public int addMenuInfo(MenuInfo menuInfo);
}
