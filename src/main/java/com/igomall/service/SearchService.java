/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: QQGMvU78dVMHDe0DG4OkyDuC7i2UoS10
 */
package com.igomall.service;

/**
 * Service - 搜索
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface SearchService {

	/**
	 * 创建索引
	 * 
	 * @param type
	 *            索引类型
	 */
	void index(Class<?> type);

	/**
	 * 创建索引
	 * 
	 * @param type
	 *            索引类型
	 * @param purgeAll
	 *            是否清空已存在索引
	 */
	void index(Class<?> type, boolean purgeAll);

}