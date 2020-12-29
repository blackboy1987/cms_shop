/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: zhjV2F+cYdEVfTT9iynQTX1lM6n+8Lnx
 */
package com.igomall.dao;

import com.igomall.entity.AuditLog;

/**
 * Dao - 审计日志
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface AuditLogDao extends BaseDao<AuditLog, Long> {

	/**
	 * 删除所有
	 */
	void removeAll();

}