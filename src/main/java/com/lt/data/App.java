package com.lt.data;

import com.lt.data.dao.DataConverterDao;
import com.lt.data.model.TableInfo;
import com.lt.data.service.DataAssemblyService;
import com.lt.data.service.DataConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataConverterService dataConverterService = ac.getBean("dataConverterServiceImpl", DataConverterService.class);
        DataAssemblyService dataAssemblyService = ac.getBean("dataAssemblyServiceImpl", DataAssemblyService.class);
        DataConverterDao dataConverterDao = ac.getBean(DataConverterDao.class);

        List<TableInfo> tableList = dataAssemblyService.getTableList();
        //表总行数
        for (TableInfo tableInfo : tableList) {
            Integer count = dataConverterDao.getTableCount(tableInfo.getTableName());

            LOGGER.info("表：" + tableInfo.getTableName() + "总记录数为" + count);
        }


        Map<String, Long> timeMap = new HashMap<String, Long>();

        long begin = System.currentTimeMillis();
        for (TableInfo tableInfo : tableList) {
            long beginTime = System.currentTimeMillis();
            dataConverterService.dataConverter(tableInfo);
            long endTime = System.currentTimeMillis();

            timeMap.put(tableInfo.getTableName(),(endTime - beginTime)/1000);
        }
        long end = System.currentTimeMillis();

        for (Map.Entry<String, Long> entry: timeMap.entrySet()){
            System.out.println("程序运行时间： 表" + entry.getKey() + "执行" + entry.getValue() +"秒==="  + entry.getValue()/60 +"分");
            LOGGER.info("程序运行时间： 表" + entry.getKey() + "执行" + entry.getValue() +"秒==="  + entry.getValue()/60 +"分");
        }

        System.out.println("总运行时间： " + (end-begin)/1000 +"秒");
        System.out.println("总运行时间： " + (end-begin)/(1000*60) +"分");
        LOGGER.info("总运行时间： " + (end-begin)/1000 +"秒");
        LOGGER.info("总运行时间： " + (end-begin)/(1000*60) +"分");

    }
}
