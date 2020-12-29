/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: KlWyuwxuaBmbQmaQOVJ+5PE8i3U6Miwb
 */
package com.igomall.dao;

import com.igomall.entity.Sn;

/**
 * Dao - 序列号
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface SnDao {

	/**
	 * 生成序列号
	 * 
	 * @param type
	 *            类型
	 * @return 序列号
	 */
	String generate(Sn.Type type);

}