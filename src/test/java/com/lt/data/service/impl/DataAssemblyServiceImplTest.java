package com.lt.data.service.impl;

import com.lt.data.BaseTest;
import com.lt.data.dao.DataConverterDao;
import com.lt.data.model.TableInfo;
import com.lt.data.service.DataAssemblyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by liutao on 2017/8/8.
 */
public class DataAssemblyServiceImplTest extends BaseTest{

    @Autowired
    private DataAssemblyService dataAssemblyService;

    @Autowired
    private DataConverterDao dataConverterDao;

    @Test
    public void testGetTableList() throws Exception {
        List<TableInfo> tableInfoList = dataAssemblyService.getTableList();

        for (TableInfo tableInfo : tableInfoList) {
            dataConverterDao.getTableDataInfo(tableInfo.getTableName(),tableInfo.getPrimaryKey(),0,2,tableInfo.getColumnList());
        }
    }
}