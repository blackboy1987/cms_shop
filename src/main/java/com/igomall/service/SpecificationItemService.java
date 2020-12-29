/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: ShuPZcHXQ2sN7ju2aLVSVWiIsgsxIHi4
 */
package com.igomall.service;

import java.util.List;

import com.igomall.entity.SpecificationItem;

/**
 * Service - 规格项
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface SpecificationItemService {

	/**
	 * 规格项过滤
	 * 
	 * @param specificationItems
	 *            规格项
	 */
	void filter(List<SpecificationItem> specificationItems);

}