package com.bh.genbh.common.bh;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TreePathService {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public void buildPath(String parentId, com.bh.genbh.common.bh.NamingConfig config) {
		com.bh.genbh.common.bh.TreePathGenerator.buildPath(jdbcTemplate, StringUtils.isBlank(parentId) ? null : parentId, config);
	}

	public String getPath(String id, com.bh.genbh.common.bh.NamingConfig config) {
		return com.bh.genbh.common.bh.TreePathGenerator.getPath(jdbcTemplate, id, config);
	}

	public List<String> getPathValue(String id, com.bh.genbh.common.bh.NamingConfig config, String field) {
		return com.bh.genbh.common.bh.TreePathGenerator.getPathValue(jdbcTemplate, id, config, field);
	}

	public List<String> getPathValueByBH(String bh, com.bh.genbh.common.bh.NamingConfig config, String field) {
		return com.bh.genbh.common.bh.TreePathGenerator.getPathValueByBH(jdbcTemplate, bh, config, field);
	}

	public List<Map<String, Object>> getPathValue(String id, com.bh.genbh.common.bh.NamingConfig config, String[] fields) {
		return com.bh.genbh.common.bh.TreePathGenerator.getPathValue(jdbcTemplate, id, config, fields);
	}

	public List<Map<String, Object>> getPathValueByBH(String bh, com.bh.genbh.common.bh.NamingConfig config, String[] fields) {
		return com.bh.genbh.common.bh.TreePathGenerator.getPathValueByBH(jdbcTemplate, bh, config, fields);
	}

}
