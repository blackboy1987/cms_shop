/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: gqUH4t8tHJCqlOehoPJmm2UBnKFFEmzM
 */
package com.igomall.service;

import com.igomall.entity.AdPosition;

/**
 * Service - 广告位
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface AdPositionService extends BaseService<AdPosition, Long> {

	/**
	 * 查找广告位
	 * 
	 * @param id
	 *            ID
	 * @param useCache
	 *            是否使用缓存
	 * @return 广告位
	 */
	AdPosition find(Long id, boolean useCache);

}