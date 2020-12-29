/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 2UMK2SM8sXCz1ACLvbgNTGTGRfTZIBBV
 */
package com.igomall.job;

import javax.inject.Inject;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.igomall.service.StoreService;

/**
 * Job - 店铺
 * 
 * @author 爱购 Team
 * @version 6.1
 */
@Lazy(false)
@Component
public class StoreJob {

	@Inject
	private StoreService storeService;

	/**
	 * 过期店铺处理
	 */
	@Scheduled(cron = "${job.store_expired_processing.cron}")
	public void evictExpired() {
		storeService.expiredStoreProcessing();
	}

}