/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 1PYGJGJTlF51kL0A4GI3Vm1AaWBSFcRh
 */
package com.igomall.dao;

import java.util.List;

import com.igomall.Filter;
import com.igomall.Order;
import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.Store;
import com.igomall.entity.StoreProductTag;

/**
 * Dao - 店铺商品标签
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface StoreProductTagDao extends BaseDao<StoreProductTag, Long> {

	/**
	 * 查找店铺商品标签
	 * 
	 * @param store
	 *            店铺
	 * @param isEnabled
	 *            是否启用
	 * @return 店铺商品标签
	 */
	List<StoreProductTag> findList(Store store, Boolean isEnabled);

	/**
	 * 查找店铺商品标签
	 * 
	 * @param store
	 *            店铺
	 * @param isEnabled
	 *            是否启用
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 店铺商品标签
	 */
	List<StoreProductTag> findList(Store store, Boolean isEnabled, Integer count, List<Filter> filters, List<Order> orders);

	/**
	 * 查找店铺商品标签分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页
	 * @return 店铺商品标签分页
	 */
	Page<StoreProductTag> findPage(Store store, Pageable pageable);

}