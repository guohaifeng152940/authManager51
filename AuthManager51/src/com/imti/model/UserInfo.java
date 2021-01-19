package com.imti.model;
/**@�ļ���: UserInfo.java
 * @�๦��˵��: �û�ʵ��
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��4������9:46:57
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��4������9:46:57</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class UserInfo {

	private Integer user_id;		//�û�����
	private String user_code;		//�û�����
	private String user_name;		//�û�����
	private String user_nickName;	//�û��ǳ�
	private String user_pwd;		//�û�����
	private int user_state;			//�û�״̬��0��ʾ�û������ã�1��ʾ�û�����
	private int user_delflag;		//ɾ����ǣ�0��ʾ�û�δɾ����1��ʾ�û���ɾ��
	private int opt_id;				//������
	private String createTime;		//����ʱ��
	private String user_remark;		//��ע
	
	public UserInfo() {}

	public UserInfo(String user_name, String user_pwd) {
		this.user_name = user_name;
		this.user_pwd = user_pwd;
	}

	public UserInfo(String user_name, String user_nickName, String user_pwd, String user_remark) {
		this.user_name = user_name;
		this.user_nickName = user_nickName;
		this.user_pwd = user_pwd;
		this.user_remark = user_remark;
	}

	public UserInfo(Integer user_id, String user_name, String user_nickName, String user_pwd, String user_remark) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_nickName = user_nickName;
		this.user_pwd = user_pwd;
		this.user_remark = user_remark;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nickName() {
		return user_nickName;
	}

	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public int getUser_state() {
		return user_state;
	}

	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}

	public int getUser_delflag() {
		return user_delflag;
	}

	public void setUser_delflag(int user_delflag) {
		this.user_delflag = user_delflag;
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

	public String getUser_remark() {
		return user_remark;
	}

	public void setUser_remark(String user_remark) {
		this.user_remark = user_remark;
	}
	
}
