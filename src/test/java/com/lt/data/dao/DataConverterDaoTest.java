package com.lt.data.dao;

import com.lt.data.BaseTest;
import com.lt.data.model.ColumnInfo;
import com.touna.loan.biz.dubbo.bean.Result;
import com.touna.loan.biz.exception.BizException;
import com.touna.loan.sensitive.facade.code.SensitiveDataType;
import com.touna.loan.sensitive.facade.intf.SensitiveDataFacade;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by liutao on 2017/8/7.
 */
public class DataConverterDaoTest extends BaseTest {

    @Autowired
    private DataConverterDao dataConverterDao;
    @Autowired
    private SensitiveDataFacade sensitiveDataFacade;

    @Test
    public void testGetTableCount() throws Exception {
        int count = dataConverterDao.getTableCount("tb_lb_custinfo");
        System.out.println(count);
    }

    @Test
    public void testDubboService() throws BizException {
        Result<String> result = sensitiveDataFacade.getClearTextByCipher("0192023a7bbd73250516f069df18b500");
//        Result<String> result = sensitiveDataConsumer.testDubboService("18996321457");
        System.out.println(result.getData());
        Assert.assertNotNull(result.getData());
    }

    @Test
    public void testGetTableDataInfo() throws Exception {
        List<ColumnInfo> columnList1 = new ArrayList<ColumnInfo>();
        ColumnInfo c1 = new ColumnInfo();
        c1.setColumnName("ID");
        columnList1.add(c1);

        ColumnInfo c2 = new ColumnInfo();
        c2.setColumnName("DOCNO");
        columnList1.add(c2);

        ColumnInfo c3 = new ColumnInfo();
        c3.setColumnName("MOBILE");
        columnList1.add(c3);

        ColumnInfo c4 = new ColumnInfo();
        c4.setColumnName("SPOUSETEL");
        columnList1.add(c4);

        ColumnInfo c5 = new ColumnInfo();
        c5.setColumnName("SPOUSECORPTEL");
        columnList1.add(c5);

        ColumnInfo c6 = new ColumnInfo();
        c6.setColumnName("SPOUSEDOCNO");
        columnList1.add(c6);

        ColumnInfo c7 = new ColumnInfo();
        c7.setColumnName("BANK_PHONE");
        columnList1.add(c7);

        ColumnInfo c8 = new ColumnInfo();
        c8.setColumnName("ESTATEADDR");
        columnList1.add(c8);

        ColumnInfo c9 = new ColumnInfo();
        c9.setColumnName("HOME_ADDR");
        columnList1.add(c9);

        ColumnInfo c10 = new ColumnInfo();
        c10.setColumnName("HOUSEHOLD");
        columnList1.add(c10);

        ColumnInfo c11 = new ColumnInfo();
        c11.setColumnName("MOBILE2");
        columnList1.add(c11);

        ColumnInfo c12 = new ColumnInfo();
        c12.setColumnName("MOBILE3");
        columnList1.add(c12);

        List result = dataConverterDao.getTableDataInfo("tb_lb_custinfo", "Id",1390,1490, columnList1);
        System.out.println(result.size());
    }

    @Test
    public void testUpdateTableInfo() throws Exception {
        List<ColumnInfo> columnInfoList = new ArrayList<ColumnInfo>();
        ColumnInfo columnInfo1 = new ColumnInfo();
        columnInfo1.setColumnName("DOCNO");
        columnInfo1.setColumnValue("DOCNOtest1");

        ColumnInfo columnInfo2 = new ColumnInfo();
        columnInfo2.setColumnName("MOBILE");
        columnInfo2.setColumnValue("MOBILEtest1");

        ColumnInfo columnInfo3 = new ColumnInfo();
        columnInfo3.setColumnName("HOME_ADDR");
        columnInfo3.setColumnValue("HOME_ADDRtest1");

        columnInfoList.add(columnInfo1);
        columnInfoList.add(columnInfo2);
        columnInfoList.add(columnInfo3);

        dataConverterDao.updateTableInfo("tb_lb_custinfo","ID",1391,columnInfoList);
    }

    @Test
    public void testGetMinIdNum() throws Exception {
        Integer minId = dataConverterDao.getMinIdNum("tb_lb_custinfo", "ID");
        System.out.println(minId);
    }
}