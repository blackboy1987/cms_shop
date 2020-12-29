/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: XeUJiqRyiGPyzYHJSO0Sbdi5H+0z0+ZT
 */
package com.igomall.dao;

import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.ShippingMethod;

/**
 * Dao - 配送方式
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface ShippingMethodDao extends BaseDao<ShippingMethod, Long> {

	/**
	 * 查找配送方式分页
	 * 
	 * @param pageable
	 *            分页
	 * @return 配送方式分页
	 */
	Page<ShippingMethod> findPage(Pageable pageable);
}