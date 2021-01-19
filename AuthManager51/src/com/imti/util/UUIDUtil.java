package com.imti.util;

import java.util.UUID;

/**@文件名: UUIDUtil.java
 * @类功能说明: 
 * @作者: GuoHaiFeng
 * @Email: 1191619897@qq.com
 * @日期: 2021年1月6日下午2:38:05
 * @修改说明:<br> 
 * <pre>
 * 	 <li>作者: GuoHaiFeng</li> 
 * 	 <li>日期: 2021年1月6日下午2:38:05</li> 
 *	 <li>内容: </li>
 * </pre>
 */
public class UUIDUtil {

	public static String getUUID() {
		String uuid=UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
}
