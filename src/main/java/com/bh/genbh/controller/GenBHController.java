package com.bh.genbh.controller;

import com.bh.genbh.common.bh.NamingConfig;
import com.bh.genbh.common.bh.TreePathService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
public class GenBHController {

    @Autowired
    TreePathService treePathService;

    @GetMapping("/genBH")
    public void genBH(
            @NotEmpty String tableName,
            @NotEmpty String parentId
    ) {
        try {
            generateBH(tableName,parentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成BH，parentId 为空时，重新生成整表BH
     *
     * @param table
     * @param parentId
     */
    private void generateBH(String table, String parentId) {
        if (StringUtils.isNotBlank(table)) {
            NamingConfig cfg = new NamingConfig();
            cfg.setId("id");
            cfg.setTable(table);
            cfg.setParentId("parent_id");
            cfg.setSortField("id");
            treePathService.buildPath(parentId, cfg);
        }
    }
}
