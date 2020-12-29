/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: nk/UGIfOpe6OS4oKaGgqArzsp888knVk
 */
package com.igomall.dao;

import com.igomall.Page;
import com.igomall.Pageable;
import com.igomall.entity.Member;
import com.igomall.entity.MemberDepositLog;

/**
 * Dao - 会员预存款记录
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface MemberDepositLogDao extends BaseDao<MemberDepositLog, Long> {

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