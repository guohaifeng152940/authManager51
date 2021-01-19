package com.imti.model;
/**@文件名: RoleInfo.java
 * @类功能说明: 
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月7日下午1:47:43
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月7日下午1:47:43</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class RoleInfo {

	private Integer role_id;
	private String role_name;
	private String role_code;
	private int role_state;
	private int role_delflag;
	private int opt_id;
	private String createTime;
	private String role_remark;
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_code() {
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	public int getRole_state() {
		return role_state;
	}
	public void setRole_state(int role_state) {
		this.role_state = role_state;
	}
	public int getRole_delflag() {
		return role_delflag;
	}
	public void setRole_delflag(int role_delflag) {
		this.role_delflag = role_delflag;
	}
	public int getOpt_id() {
		return opt_id;
	}
	public void setOpt_id(int opt_id) {
		this.opt_id = opt_id;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getRole_remark() {
		return role_remark;
	}
	public void setRole_remark(String role_remark) {
		this.role_remark = role_remark;
	}
}
