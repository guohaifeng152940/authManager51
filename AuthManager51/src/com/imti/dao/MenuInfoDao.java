package com.imti.dao;

import java.util.List;
import java.util.Map;

import com.imti.model.MenuInfo;

/**@�ļ���: MenuInfoDao.java
 * @�๦��˵��: 
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��5������9:48:32
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��5������9:48:32</li> 
 *	 <li>����: </li>
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
