/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: m6BFs1/KSRzftprnftaHMtJlle+wDTBi
 */
package com.igomall.dao;

import com.igomall.entity.Store;
import com.igomall.entity.StorePluginStatus;

/**
 * Dao - 店铺插件状态
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface StorePluginStatusDao extends BaseDao<StorePluginStatus, Long> {

	/**
	 * 查找店铺插件状态
	 * 
	 * @param store
	 *            店铺
	 * @param pluginId
	 *            插件ID
	 * @return 店铺插件状态，若不存在则返回null
	 */
	StorePluginStatus find(Store store, String pluginId);
}