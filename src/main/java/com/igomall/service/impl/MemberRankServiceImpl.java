/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 7SSywxydNAnz3jUSZm/5yZXin2MCKEVW
 */
package com.igomall.service.impl;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.igomall.dao.MemberRankDao;
import com.igomall.entity.MemberRank;
import com.igomall.service.MemberRankService;

/**
 * Service - 会员等级
 * 
 * @author 爱购 Team
 * @version 6.1
 */
@Service
public class MemberRankServiceImpl extends BaseServiceImpl<MemberRank, Long> implements MemberRankService {

	@Inject
	private MemberRankDao memberRankDao;

	@Override
	@Transactional(readOnly = true)
	public boolean amountExists(BigDecimal amount) {
		return memberRankDao.exists("amount", amount);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean amountUnique(Long id, BigDecimal amount) {
		return memberRankDao.unique(id, "amount", amount);
	}

	@Override
	@Transactional(readOnly = true)
	public MemberRank findDefault() {
		return memberRankDao.findDefault();
	}

	@Override
	@Transactional(readOnly = true)
	public MemberRank findByAmount(BigDecimal amount) {
		return memberRankDao.findByAmount(amount);
	}

	@Override
	@Transactional
	public MemberRank save(MemberRank memberRank) {
		Assert.notNull(memberRank, "[Assertion failed] - memberRank is required; it must not be null");

		if (BooleanUtils.isTrue(memberRank.getIsDefault())) {
			memberRankDao.clearDefault();
		}
		return super.save(memberRank);
	}

	@Override
	@Transactional
	public MemberRank update(MemberRank memberRank) {
		Assert.notNull(memberRank, "[Assertion failed] - memberRank is required; it must not be null");

		MemberRank pMemberRank = super.update(memberRank);
		if (BooleanUtils.isTrue(pMemberRank.getIsDefault())) {
			memberRankDao.clearDefault(pMemberRank);
		}
		return pMemberRank;
	}

}