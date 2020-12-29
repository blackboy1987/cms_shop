/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: g3EGvzW4cP/EJdppdJSt52wbJcKdvkt1
 */
package com.igomall.dao;

import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.DistributionCommission;
import com.igomall.entity.Distributor;

/**
 * Dao - 分销佣金
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface DistributionCommissionDao extends BaseDao<DistributionCommission, Long> {

	/**
	 * 查找分销佣金记录分页
	 * 
	 * @param distributor
	 *            分销员
	 * @param pageable
	 *            分页信息
	 * @return 分销佣金记录分页
	 */
	Page<DistributionCommission> findPage(Distributor distributor, Pageable pageable);

}