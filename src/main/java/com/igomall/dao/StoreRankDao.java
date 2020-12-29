/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: cb/eIl7r50TJ5yRkBtaXPppbN8ETdTh1
 */
package com.igomall.dao;

import java.util.List;

import com.igomall.Filter;
import com.igomall.Order;
import com.igomall.entity.StoreRank;

/**
 * Dao - 店铺等级
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface StoreRankDao extends BaseDao<StoreRank, Long> {

	/**
	 * 查找店铺等级
	 * 
	 * @param isAllowRegister
	 *            是否允许注册
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 店铺等级
	 */
	List<StoreRank> findList(Boolean isAllowRegister, List<Filter> filters, List<Order> orders);

}