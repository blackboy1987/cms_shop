/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: ub7AvBcP6Pr5MIIgrAc0pWK/8hl18/+X
 */
package com.igomall.service;

import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.Business;
import com.igomall.entity.BusinessDepositLog;

/**
 * Service - 商家预存款记录
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface BusinessDepositLogService extends BaseService<BusinessDepositLog, Long> {

	/**
	 * 查找商家预存款记录分页
	 * 
	 * @param business
	 *            商家
	 * @param pageable
	 *            分页信息
	 * @return 商家预存款记录分页
	 */
	Page<BusinessDepositLog> findPage(Business business, Pageable pageable);

}