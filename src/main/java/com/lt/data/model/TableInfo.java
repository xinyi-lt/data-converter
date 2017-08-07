package com.lt.data.model;

import java.util.List;

/**
 * Created by liutao on 2017/8/7.
 */
public class TableInfo {
    private String tableName;
    private String primaryKey;
    private List<ColumnInfo> columnList;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnInfo> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnInfo> columnList) {
        this.columnList = columnList;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
}
