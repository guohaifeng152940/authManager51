package com.imti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.model.MenuInfo;
import com.imti.model.UserInfo;
import com.imti.service.MenuInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**@文件名: MenuInfoController.java
 * @类功能说明: 
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月5日上午10:14:24
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月5日上午10:14:24</li> 
 *	 <li>内容: </li>
 * </pre>
 */
@Controller
@RequestMapping("menuInfo")
public class MenuInfoController {

	@Autowired
	private MenuInfoService menuInfoService;
	
	@RequestMapping("findMenuInfoByParentId")
	@ResponseBody
	public JSONArray findMenuInfoByParentId(HttpServletRequest request) {
		int parentId=-1;
		HttpSession session=request.getSession();
		UserInfo userInfoSession=(UserInfo) session.getAttribute("currentUserInfo");
		List<String> meunIds=menuInfoService.getCurrentUserOwerMenus(userInfoSession.getUser_id());
		return menuInfoService.findMenuInfoByParentId(parentId,meunIds);
	}
	
	@RequestMapping("/findAllMeunInfoByRoleId")
	@ResponseBody
	public JSONArray findAllMeunInfoByRoleId(int roleId) {
		int parentId=-1;
		return menuInfoService.findAllMeunInfoByRoleId(parentId,roleId);
	}
	
	@RequestMapping("/saveRoleAndMenu")
	@ResponseBody
	public JSONObject saveRoleAndMenu(int role_id,String menuIds) {
		JSONObject jsonObject=new JSONObject();
		int result=menuInfoService.saveRoleAndMenu(role_id,menuIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/findAllMenuInfo")
	@ResponseBody
	public List<MenuInfo> findAllMenuInfo(){
		int parentId=-1;
		return menuInfoService.findAllMenuInfo(parentId);
	}
	
	@RequestMapping("/addMenuInfo")
	@ResponseBody
	public JSONObject addMenuInfo(MenuInfo menuInfo,HttpServletRequest request) {
		JSONObject jsonObject=new JSONObject();
		HttpSession session=request.getSession();
		UserInfo userInfo=(UserInfo) session.getAttribute("currentUserInfo");
		menuInfo.setOpt_id(userInfo.getUser_id());
		int result=menuInfoService.addMenuInfo(menuInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
}
