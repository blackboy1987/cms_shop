/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 61+h0lAaInYFMUTXi2F4+ZvCKZoDABpQ
 */
package com.igomall.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.igomall.Order;
import com.igomall.dao.SvcDao;
import com.igomall.entity.Store;
import com.igomall.entity.StoreRank;
import com.igomall.entity.Svc;

/**
 * Dao - 服务
 * 
 * @author 爱购 Team
 * @version 6.1
 */
@Repository
public class SvcDaoImpl extends BaseDaoImpl<Svc, Long> implements SvcDao {

	@Override
	public List<Svc> find(Store store, String promotionPluginId, StoreRank storeRank, List<Order> orders) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Svc> criteriaQuery = criteriaBuilder.createQuery(Svc.class);
		Root<Svc> root = criteriaQuery.from(Svc.class);
		criteriaQuery.select(root);
		Predicate restrictions = criteriaBuilder.conjunction();
		if (store != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("store"), store));
		}
		if (promotionPluginId != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("promotionPluginId"), promotionPluginId));
		}
		if (storeRank != null) {
			restrictions = criteriaBuilder.and(restrictions, criteriaBuilder.equal(root.get("storeRank"), storeRank));
		}
		criteriaQuery.where(restrictions);
		if (orders == null || orders.isEmpty()) {
			criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createdDate")));
		}
		return super.findList(criteriaQuery, null, null, null, orders);
	}

}