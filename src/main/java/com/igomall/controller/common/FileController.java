/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: localhost
 * License: localhost/license
 * FileId: 2rJuFAEVFvIkoAm7LbPkRFoArOIt2GkA
 */
package com.igomall.controller.common;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.igomall.FileType;
import com.igomall.Results;
import com.igomall.service.FileService;

/**
 * Controller - 文件
 * 
 * @author 爱购 Team
 * @version 6.1
 */
@Controller("commonFileController")
@RequestMapping("/common/file")
public class FileController {

	@Inject
	private FileService fileService;

	/**
	 * 上传
	 */
	@PostMapping("/upload")
	public ResponseEntity<?> upload(FileType fileType, MultipartFile file) {
		Map<String, Object> data = new HashMap<>();
		if (fileType == null || file == null || file.isEmpty()) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		if (!fileService.isValid(fileType, file)) {
			return Results.unprocessableEntity("common.upload.invalid");
		}
		String url = fileService.upload(fileType, file, false);
		if (StringUtils.isEmpty(url)) {
			return Results.unprocessableEntity("common.upload.error");
		}

		data.put("url", url);
		return ResponseEntity.ok(data);
	}

}