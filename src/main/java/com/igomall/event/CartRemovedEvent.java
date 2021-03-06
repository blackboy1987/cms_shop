/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 5FqfMuqR2c2iqrVgeYt00YPbLotIMjnO
 */
package com.igomall.event;

import com.igomall.entity.Cart;
import com.igomall.entity.Sku;

/**
 * Event - 移除购物车SKU
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public class CartRemovedEvent extends CartEvent {

	private static final long serialVersionUID = 6638396637072338544L;

	/**
	 * SKU
	 */
	private Sku sku;

	/**
	 * 构造方法
	 * 
	 * @param source
	 *            事件源
	 * @param cart
	 *            购物车
	 * @param sku
	 *            SKU
	 */
	public CartRemovedEvent(Object source, Cart cart, Sku sku) {
		super(source, cart);
		this.sku = sku;
	}

	/**
	 * 获取SKU
	 * 
	 * @return SKU
	 */
	public Sku getSku() {
		return sku;
	}

}