/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: +ly2nR12vJXyO+JISMIMw/d3aOogboQK
 */
package com.igomall.service;

import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.StockLog;
import com.igomall.entity.Store;

/**
 * Service - 库存记录
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface StockLogService extends BaseService<StockLog, Long> {

	/**
	 * 查找库存记录分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页
	 * @return 库存记录分页
	 */
	Page<StockLog> findPage(Store store, Pageable pageable);

}