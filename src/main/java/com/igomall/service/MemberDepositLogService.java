/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: pChw8iHWExlpqgmXacC/4d2MrWKcwxvS
 */
package com.igomall.service;

import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.Member;
import com.igomall.entity.MemberDepositLog;

/**
 * Service - 会员预存款记录
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface MemberDepositLogService extends BaseService<MemberDepositLog, Long> {

	/**
	 * 查找会员预存款记录分页
	 * 
	 * @param member
	 *            会员
	 * @param pageable
	 *            分页信息
	 * @return 会员预存款记录分页
	 */
	Page<MemberDepositLog> findPage(Member member, Pageable pageable);

}