package com.imti.util;

import java.util.UUID;

/**@�ļ���: UUIDUtil.java
 * @�๦��˵��: 
 * @����: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @����: 2021��1��6������2:38:05
 * @�޸�˵��:<br> 
 * <pre>
 * 	 <li>����: GuoHaiFeng</li> 
 * 	 <li>����: 2021��1��6������2:38:05</li> 
 *	 <li>����: </li>
 * </pre>
 */
public class UUIDUtil {

	public static String getUUID() {
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
}
