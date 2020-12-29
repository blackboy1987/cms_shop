/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: l+kfsvm0bkK5LlzQ8jBxN3JE8CL32V+6
 */
package com.igomall.dao;

import java.util.List;

import com.igomall.entity.Area;

/**
 * Dao - 地区
 * 
 * @author 爱购 Team
 * @version 6.1
 */
public interface AreaDao extends BaseDao<Area, Long> {

	/**
	 * 查找顶级地区
	 * 
	 * @param count
	 *            数量
	 * @return 顶级地区
	 */
	List<Area> findRoots(Integer count);

	/**
	 * 查找上级地区
	 * 
	 * @param area
	 *            地区
	 * @param recursive
	 *            是否递归
	 * @param count
	 *            数量
	 * @return 上级地区
	 */
	List<Area> findParents(Area area, boolean recursive, Integer count);

	/**
	 * 查找下级地区
	 * 
	 * @param area
	 *            地区
	 * @param recursive
	 *            是否递归
	 * @param count
	 *            数量
	 * @return 下级地区
	 */
	List<Area> findChildren(Area area, boolean recursive, Integer count);

}