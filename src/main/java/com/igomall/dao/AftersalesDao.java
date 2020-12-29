/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: JqzXDomykJ97Q3wA18T0HGPonfCDXEu4
 */
package com.igomall.dao;

import java.util.List;

import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.Aftersales;
import com.igomall.entity.Member;
import com.igomall.entity.OrderItem;
import com.igomall.entity.Store;

/**
 * Dao - 售后
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface AftersalesDao extends BaseDao<Aftersales, Long> {

	/**
	 * 查找售后列表
	 * 
	 * @param orderItems
	 *            订单项
	 * @return 售后列表
	 */
	List<Aftersales> findList(List<OrderItem> orderItems);

	/**
	 * 查找售后分页
	 * 
	 * @param type
	 *            类型
	 * @param status
	 *            状态
	 * @param member
	 *            会员
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页信息
	 * @return 售后分页
	 */
	Page<Aftersales> findPage(Aftersales.Type type, Aftersales.Status status, Member member, Store store, Pageable pageable);

}