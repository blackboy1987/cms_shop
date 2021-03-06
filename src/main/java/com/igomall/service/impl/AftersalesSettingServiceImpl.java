/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: SK85ntWMAr375cJWUi5BOOUoJSEKnWsB
 */
package com.igomall.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.igomall.dao.AftersalesSettingDao;
import com.igomall.entity.AftersalesSetting;
import com.igomall.entity.Store;
import com.igomall.service.AftersalesSettingService;

/**
 * Service - 售后设置
 * 
 * @author 爱购 Team
 * @version 6.1
 */
@Service
public class AftersalesSettingServiceImpl extends BaseServiceImpl<AftersalesSetting, Long> implements AftersalesSettingService {

	@Inject
	private AftersalesSettingDao aftersalesSettingDao;

	@Override
	@Transactional(readOnly = true)
	public AftersalesSetting findByStore(Store store) {
		Assert.notNull(store, "[Assertion failed] - store is required; it must not be null");

		return aftersalesSettingDao.find("store", store);
	}

}