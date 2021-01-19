package com.imti.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imti.dao.RoleInfoDao;
import com.imti.model.RoleInfo;
import com.imti.service.RoleInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**@�ļ���: RoleInfoServiceImpl.java
 * @�๦��˵��: 
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��7������1:55:50
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��7������1:55:50</li> 
 *	 <li>����: </li>
 * </pre>
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

	@Autowired
	private RoleInfoDao roleInfoDao;
	
	@Override
	public JSONArray findAllRoleInfoForUser(int user_id) {
		List<Integer> role_ids=roleInfoDao.findUserOwerRolesByUId(user_id);
		List<RoleInfo> roleList=roleInfoDao.findAllRoleInfoForUser();
		JSONArray jsonArray=new JSONArray();
		
		for(int i=0;i<roleList.size();i++) {
			RoleInfo roleInfo=roleList.get(i);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("role_id", roleInfo.getRole_id());
			jsonObject.put("role_name", roleInfo.getRole_name());
			jsonObject.put("role_code", roleInfo.getRole_code());
			jsonObject.put("role_state", roleInfo.getRole_state());
			jsonObject.put("role_delflag", roleInfo.getRole_delflag());
			jsonObject.put("opt_id", roleInfo.getOpt_id());
			jsonObject.put("createTime", roleInfo.getCreateTime());
			jsonObject.put("role_remark", roleInfo.getRole_remark());
			if(role_ids.contains(roleInfo.getRole_id())) {
				jsonObject.put("checked", true);
			}
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public int findAllRoleInfoCount(Map<String, Object> map) {
		return roleInfoDao.findAllRoleInfoCount(map);
	}

	@Override
	public List<RoleInfo> findAllRoleInfo(Map<String, Object> map) {
		return roleInfoDao.findAllRoleInfo(map);
	}

}
