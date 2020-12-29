/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: chZ9hLYvon+qYkrutF82ly7Ybo/Kvu7y
 */
package com.igomall.dao;

import java.util.List;

import com.igomall.Filter;
import com.igomall.Order;
import com.igomall.entity.Brand;
import com.igomall.entity.ProductCategory;

/**
 * Dao - 品牌
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface BrandDao extends BaseDao<Brand, Long> {

	/**
	 * 查找品牌
	 * 
	 * @param productCategory
	 *            商品分类
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 品牌
	 */
	List<Brand> findList(ProductCategory productCategory, Integer count, List<Filter> filters, List<Order> orders);

}