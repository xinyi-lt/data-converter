package com.lt.data;

import com.lt.data.model.ColumnInfo;
import com.lt.data.model.TableInfo;
import com.lt.data.service.DataConverterService;
import com.touna.loan.sensitive.facade.code.SensitiveDataType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main( String[] args ) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataConverterService dataConverterService = ac.getBean("dataConverterServiceImpl", DataConverterService.class);

        List<TableInfo> tableList = new ArrayList<TableInfo>();

        TableInfo tb1 = new TableInfo();
        tb1.setTableName("tb_lb_custinfo");
        tb1.setPrimaryKey("ID");

        List<ColumnInfo> columnList1 = new ArrayList<ColumnInfo>();

        ColumnInfo c2 = new ColumnInfo();
        c2.setColumnName("DOCNO");
        c2.setDataType(SensitiveDataType.ID_NUMBER.getCode());
        columnList1.add(c2);

        ColumnInfo c3 = new ColumnInfo();
        c3.setColumnName("MOBILE");
        c3.setDataType(SensitiveDataType.PHONE_NUMBER.getCode());
        columnList1.add(c3);

        ColumnInfo c4 = new ColumnInfo();
        c4.setColumnName("SPOUSETEL");
        c4.setDataType(SensitiveDataType.PHONE_NUMBER.getCode());
        columnList1.add(c4);

        ColumnInfo c5 = new ColumnInfo();
        c5.setColumnName("SPOUSECORPTEL");
        c5.setDataType(SensitiveDataType.PHONE_NUMBER.getCode());
        columnList1.add(c5);

        ColumnInfo c6 = new ColumnInfo();
        c6.setColumnName("SPOUSEDOCNO");
        c6.setDataType(SensitiveDataType.ID_NUMBER.getCode());
        columnList1.add(c6);

        ColumnInfo c7 = new ColumnInfo();
        c7.setColumnName("BANK_PHONE");
        c7.setDataType(SensitiveDataType.PHONE_NUMBER.getCode());
        columnList1.add(c7);

        ColumnInfo c8 = new ColumnInfo();
        c8.setColumnName("ESTATEADDR");
        c8.setDataType(SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnList1.add(c8);

        ColumnInfo c9 = new ColumnInfo();
        c9.setColumnName("HOME_ADDR");
        c9.setDataType(SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnList1.add(c9);

        ColumnInfo c10 = new ColumnInfo();
        c10.setColumnName("HOUSEHOLD");
        c10.setDataType(SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnList1.add(c10);

        ColumnInfo c11 = new ColumnInfo();
        c11.setColumnName("MOBILE2");
        c11.setDataType(SensitiveDataType.PHONE_NUMBER.getCode());
        columnList1.add(c11);

        ColumnInfo c12 = new ColumnInfo();
        c12.setColumnName("MOBILE3");
        c12.setDataType(SensitiveDataType.PHONE_NUMBER.getCode());
        columnList1.add(c12);


        tb1.setColumnList(columnList1);
        tableList.add(tb1);


        dataConverterService.dataConverter(tableList);
    }
}
