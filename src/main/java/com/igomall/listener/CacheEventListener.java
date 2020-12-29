/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: B7/DqioNLPyLcApCaIWWUiEH+4awkVkY
 */
package com.igomall.listener;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListenerAdapter;
import com.igomall.entity.Article;
import com.igomall.entity.Product;
import com.igomall.service.ArticleService;
import com.igomall.service.ProductService;

/**
 * Listener - 缓存
 * 
 * @author 爱购 Team
 * @version 6.1
 */
@Component
public class CacheEventListener extends CacheEventListenerAdapter {

	@Inject
	private ArticleService articleService;
	@Inject
	private ProductService productService;

	/**
	 * 元素过期调用
	 * 
	 * @param ehcache
	 *            缓存
	 * @param element
	 *            元素
	 */
	@Override
	public void notifyElementExpired(Ehcache ehcache, Element element) {
		String cacheName = ehcache.getName();
		if (StringUtils.equals(cacheName, Article.HITS_CACHE_NAME)) {
			Long id = (Long) element.getObjectKey();
			Long hits = (Long) element.getObjectValue();
			Article article = articleService.find(id);
			if (article != null && hits != null && hits > 0 && hits > article.getHits()) {
				article.setHits(hits);
				articleService.update(article);
			}
		} else if (StringUtils.equals(cacheName, Product.HITS_CACHE_NAME)) {
			Long id = (Long) element.getObjectKey();
			Long hits = (Long) element.getObjectValue();
			Product product = productService.find(id);
			if (product != null && hits != null && hits > 0) {
				long amount = hits - product.getHits();
				if (amount > 0) {
					productService.addHits(product, amount);
				}
			}
		}
	}

}