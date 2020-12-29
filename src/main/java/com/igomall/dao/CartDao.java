/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: sw/ND8IMf1McSDVGAxbp9yhfhsS1FrL8
 */
package com.igomall.dao;

import com.igomall.entity.Cart;

/**
 * Dao - 购物车
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface CartDao extends BaseDao<Cart, Long> {

	/**
	 * 删除过期购物车
	 */
	void deleteExpired();

}