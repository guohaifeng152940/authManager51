package com.imti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.model.PageBean;
import com.imti.model.UserInfo;
import com.imti.service.UserInfoService;

import net.sf.json.JSONObject;

/**@�ļ���: UserInfoController.java
 * @�๦��˵��: �û�������Ʋ�
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��4������10:06:28
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��4������10:06:28</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Controller
@RequestMapping("userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;	//����service�ӿ�
	
	/**
	 * @������: login
	 * @����˵��: �û�������Ʋ��¼ʵ��
	 * @����: GuoHaiFeng
	 * @���䣺1191619897@qq.com
	 * @����: 2021��1��4������10:09:55
	 * @param userInfo
	 * @param request
	 * @return: String
	 */
	@RequestMapping(value="/login")
	public String login(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		//String sessionIdSession=session.getId();
		//String sessionIdRequest=request.getRequestedSessionId();
		String rands=request.getParameter("yzm");
		String sessionRands=(String)session.getAttribute("sRand");
		UserInfo sessionUserInfo=(UserInfo)session.getAttribute("currentUserInfo");
		if(sessionUserInfo!=null) {
			return "main";
		}else{
			if(sessionRands==null) {
				return "redirect:../login.jsp";
			}else {
				if(sessionRands.equals(rands)) {
					UserInfo resultUserInfo=userInfoService.login(userInfo);
					if(resultUserInfo!=null) {
						session.setAttribute("currentUserInfo", resultUserInfo);
						return "main";
					}else {
						return "redirect:../login.jsp?error=1&user_name="+userInfo.getUser_name()+"&user_pwd="+userInfo.getUser_pwd()+"&yzm="+rands;
					}
				}else {
					return "redirect:../login.jsp?error=2&user_name="+userInfo.getUser_name()+"&user_pwd="+userInfo.getUser_pwd()+"&yzm="+rands;
				}
			}
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUserInfo");
		return "redirect:../login.jsp";
	}
	
	@RequestMapping("/clearSession")
	@ResponseBody
	public void clearSession(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUserInfo");
	}
	
	@RequestMapping("/findAllUserInfo")
	@ResponseBody
	public Map<String,Object> findAllUserInfo(int rows,int page,String s_userName){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("s_userName", s_userName);
		PageBean pageBean=new PageBean(page,rows);
		map.put("pageBean", pageBean);
		List<UserInfo> userList=userInfoService.findAllUserInfo(map);
		int total=userInfoService.findAllUserInfoCount(map);
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("total", total);
		resultMap.put("rows", userList);
		return resultMap;
	}
	
	@RequestMapping("/findUserNameIsExist")
	@ResponseBody
	public JSONObject findUserNameIsExist(String userName) {
		JSONObject jsonObject=new JSONObject();
		int count=userInfoService.findUserNameIsExist(userName);
		if(count>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/addUserInfo")
	@ResponseBody
	public JSONObject addUserInfo(UserInfo userInfo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		UserInfo sessionUserInfo=(UserInfo) session.getAttribute("currentUserInfo");
		userInfo.setOpt_id(sessionUserInfo.getUser_id());
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.addUserInfo(userInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/updateUserInfo")
	@ResponseBody
	public JSONObject updateUserInfo(UserInfo userInfo,HttpServletRequest request) {
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.updateUserInfo(userInfo);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/deleteUserInfo")
	@ResponseBody
	public JSONObject deleteUserInfo(String userIds,HttpServletRequest request) {
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.deleteUserInfo(userIds);
		if(result>0) {
			jsonObject.put("msg", true);
			jsonObject.put("count", result);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/insertUserAndRole")
	@ResponseBody
	public JSONObject insertUserAndRole(int userId,String roleIds) {
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.insertUserAndRole(userId,roleIds);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
	
	@RequestMapping("/deleteUserOwerRole")
	@ResponseBody
	public JSONObject deleteUserOwerRole(int userId) {
		JSONObject jsonObject=new JSONObject();
		int result=userInfoService.deleteUserOwerRole(userId);
		if(result>0) {
			jsonObject.put("msg", true);
		}else {
			jsonObject.put("msg", false);
		}
		return jsonObject;
	}
}
