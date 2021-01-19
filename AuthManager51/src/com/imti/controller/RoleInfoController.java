package com.imti.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.model.PageBean;
import com.imti.model.RoleInfo;
import com.imti.service.RoleInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@文件名: RoleInfoController.java
 * @类功能说明: 
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月7日下午1:57:10
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月7日下午1:57:10</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("roleInfo")
public class RoleInfoController {

	@Autowired
	private RoleInfoService roleInfoService;
	
	@RequestMapping("/findAllRoleInfoForUser")
	@ResponseBody
	public JSONObject findAllRoleInfoForUser(int user_id) {
		JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=roleInfoService.findAllRoleInfoForUser(user_id);
		jsonObject.put("rows", jsonArray);
		return jsonObject;
	}
	
	@RequestMapping("/findAllRoleInfo")
	@ResponseBody
	public Map<String,Object> findAllRoleInfo(int page,int rows,String s_roleName) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("s_roleName", s_roleName);
		PageBean pageBean=new PageBean(page,rows);
		map.put("pageBean", pageBean);
		List<RoleInfo> roleList=roleInfoService.findAllRoleInfo(map);
		int total=roleInfoService.findAllRoleInfoCount(map);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("total", total);
		resultMap.put("rows", roleList);
		return resultMap;
	}
}
