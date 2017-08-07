package com.lt.data.model;

/**
 * Created by liutao on 2017/8/7.
 */
public class ResultModel {
    private Object primaryKeyValue;
    private String columnValue;

    public Object getPrimaryKeyValue() {
        return primaryKeyValue;
    }

    public void setPrimaryKeyValue(Object primaryKeyValue) {
        this.primaryKeyValue = primaryKeyValue;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }
}
