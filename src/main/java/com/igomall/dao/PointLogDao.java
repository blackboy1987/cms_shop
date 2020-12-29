/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 3a+8qHTssjmfM+mwyZGgQ8aykz61xuaP
 */
package com.igomall.dao;

import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.Member;
import com.igomall.entity.PointLog;

/**
 * Dao - 积分记录
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface PointLogDao extends BaseDao<PointLog, Long> {

	/**
	 * 查找积分记录分页
	 * 
	 * @param member
	 *            会员
	 * @param pageable
	 *            分页信息
	 * @return 积分记录分页
	 */
	Page<PointLog> findPage(Member member, Pageable pageable);

}