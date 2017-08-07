package com.lt.data.dao;

import com.lt.data.model.ColumnInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liutao on 2017/8/7.
 */
public interface DataConverterDao {

    Integer getTableCount(@Param("tableName") String tableName);

    List getTableDataInfo(@Param("tableName") String tableName,
                          @Param("primaryKey") String primaryKey,
                          @Param("startIndex") Integer startIndex,
                          @Param("endIndex") Integer endIndex,
                          @Param("columnList") List<ColumnInfo> columnList);

    void updateTableInfo(@Param("tableName") String tableName,
                         @Param("primaryKey") String primaryKey,
                         @Param("primaryKeyValue") Integer primaryKeyValue,
                         @Param("columnList") List<ColumnInfo> columnList);

    Integer getMinIdNum(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey);
}
