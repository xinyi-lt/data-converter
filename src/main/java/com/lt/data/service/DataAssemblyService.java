package com.lt.data.service;

import com.lt.data.model.TableInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2017/8/8.
 */
public interface DataAssemblyService {
    /**
     * 数据组装
     * @return
     */
    TableInfo dataAssembly(String tableName, String primaryKey, Map<String, Integer> columnMap);

    List<TableInfo> getTableList();
}
