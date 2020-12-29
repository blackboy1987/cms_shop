/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 0jt930lnUsbpGXmBku6eeNs8cX/hwwpC
 */
package com.igomall.dao;

import com.igomall.entity.Order;
import com.igomall.entity.OrderShipping;

/**
 * Dao - 订单发货
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface OrderShippingDao extends BaseDao<OrderShipping, Long> {

	/**
	 * 查找最后一条订单发货
	 * 
	 * @param order
	 *            订单
	 * @return 订单发货，若不存在则返回null
	 */
	OrderShipping findLast(Order order);

}