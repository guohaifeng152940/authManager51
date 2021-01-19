package com.imti.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imti.dao.MenuInfoDao;
import com.imti.model.MenuInfo;
import com.imti.service.MenuInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: MenuInfoServiceImpl.java
 * @类功能说明: 
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月5日上午9:58:08
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月5日上午9:58:08</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService {
	
	@Autowired
	private MenuInfoDao menuInfoDao;

	@Override
	public JSONArray findMenuInfoByParentId(int parentId,List<String> meunIds) {
		JSONArray jsonArray=this.getMenuInfoByParentId(parentId,meunIds);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("state"))) {
				continue;
			}else {
				jsonObject.put("children", findMenuInfoByParentId(jsonObject.getInt("id"),meunIds));
			}
		}
		return jsonArray;
	}
	
	public JSONArray getMenuInfoByParentId(int parentId,List<String> meunIds) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("parentId", parentId);
		map.put("meunIds", meunIds);
		List<MenuInfo> meunList=menuInfoDao.findMenuInfoByParentId(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<meunList.size();i++) {
			MenuInfo menuInfo=meunList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", menuInfo.getMenu_id());
			jsonObject.put("text", menuInfo.getMenu_name());
			jsonObject.put("state", menuInfo.getMenu_state());
			jsonObject.put("iconCls", menuInfo.getMenu_icon());
			JSONObject jsonObject1=new JSONObject();
			jsonObject1.put("url", menuInfo.getMenu_url());
			jsonObject.put("attributes", jsonObject1);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public List<String> getCurrentUserOwerMenus(int user_id) {
		return menuInfoDao.getCurrentUserOwerMenus(user_id);
	}

	@Override
	public JSONArray findAllMeunInfoByRoleId(int parentId,int role_id) {
		JSONArray jsonArray=this.getAllMeunInfoByRoleId(parentId,role_id);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("state"))) {
				continue;
			}else {
				jsonObject.put("children", findAllMeunInfoByRoleId(jsonObject.getInt("id"),role_id));
			}
		}
		return jsonArray;
	}
	
	public JSONArray getAllMeunInfoByRoleId(int parentId,int role_id) {
		List<Integer> role_menuIds=menuInfoDao.findRoleOwnerMenuByRoleId(role_id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("parentId", parentId);
		List<MenuInfo> meunList=menuInfoDao.findAllMeunInfoByRoleId(map);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<meunList.size();i++) {
			MenuInfo menuInfo=meunList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", menuInfo.getMenu_id());
			if(role_menuIds.contains(jsonObject.getInt("id"))) {
				jsonObject.put("checked", true);
			}
			jsonObject.put("text", menuInfo.getMenu_name());
			jsonObject.put("state", menuInfo.getMenu_state());
			jsonObject.put("iconCls", menuInfo.getMenu_icon());
			JSONObject jsonObject1=new JSONObject();
			jsonObject1.put("url", menuInfo.getMenu_url());
			jsonObject.put("attributes", jsonObject1);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public int saveRoleAndMenu(int role_id, String menuIds) {
		menuInfoDao.deleteRoleOldMeunByRoleId(role_id);
		String strs[]=menuIds.split(",");
		int result=0;
		for(int i=0;i<strs.length;i++) {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("role_id", role_id);
			map.put("menu_id", strs[i]);
			result+=menuInfoDao.addRoleAndMenu(map);
		}
		return result;
	}

	@Override
	public JSONArray findAllMenuInfo(int parentId) {
		JSONArray jsonArray=this.getAllMenuInfo(parentId);
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject=jsonArray.getJSONObject(i);
			if("open".equals(jsonObject.getString("menu_state"))) {
				continue;
			}else {
				jsonObject.put("children", findAllMenuInfo(jsonObject.getInt("menu_id")));
			}
		}
		return jsonArray;
	}
	
	public JSONArray getAllMenuInfo(int parentId){
		List<MenuInfo> menuList=menuInfoDao.findAllMenuInfo(parentId);
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<menuList.size();i++) {
			MenuInfo menuInfo=menuList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("menu_id", menuInfo.getMenu_id());
			jsonObject.put("parentId", menuInfo.getParentId());
			jsonObject.put("menu_name", menuInfo.getMenu_name());
			jsonObject.put("menu_state", menuInfo.getMenu_state());
			jsonObject.put("menu_url", menuInfo.getMenu_url());
			jsonObject.put("menu_icon", menuInfo.getMenu_icon());
			jsonObject.put("createTime", menuInfo.getCreateTime());
			jsonObject.put("menu_remark", menuInfo.getMenu_remark());
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public int addMenuInfo(MenuInfo menuInfo) {
		menuInfo.setMenu_state("open");
		return menuInfoDao.addMenuInfo(menuInfo);
	}

}
