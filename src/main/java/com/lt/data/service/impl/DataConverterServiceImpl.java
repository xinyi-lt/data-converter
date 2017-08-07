package com.lt.data.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.lt.data.dao.DataConverterDao;
import com.lt.data.model.ColumnInfo;
import com.lt.data.model.TableInfo;
import com.lt.data.service.DataConverterService;
import com.touna.loan.biz.dubbo.bean.Result;
import com.touna.loan.sensitive.facade.code.SensitiveDataServiceCode;
import com.touna.loan.sensitive.facade.dto.SensitiveDataDTO;
import com.touna.loan.sensitive.facade.intf.SensitiveDataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2017/8/7.
 */
@Service
public class DataConverterServiceImpl implements DataConverterService {
    private static final int PER_DATA_CONVERTER_SIZE = 100;

    @Autowired
    private DataConverterDao dataConverterDao;

    @Autowired
    private SensitiveDataFacade sensitiveDataFacade;

    @Transactional(rollbackFor = Exception.class)
    public void dataConverter(List<TableInfo> tableList) {

        for (TableInfo tableInfo : tableList) {
            String tableName = tableInfo.getTableName();
            String primaryKey = tableInfo.getPrimaryKey();
            List<ColumnInfo> columnList = tableInfo.getColumnList();

            //1.查询当前表的count
            Integer count = dataConverterDao.getTableCount(tableName);
            int loopNum = (count  +  PER_DATA_CONVERTER_SIZE  - 1) / PER_DATA_CONVERTER_SIZE;
            //2.查询当前表最小ID值
            Integer minPrimaryKey = dataConverterDao.getMinIdNum(tableName, primaryKey);
            //3.查询数据
            for (int i = 0; i <= loopNum; i++) {
                int startIndex = minPrimaryKey + i*PER_DATA_CONVERTER_SIZE;
                int endIndex = startIndex + PER_DATA_CONVERTER_SIZE;

                ColumnInfo primaryKeyColumn = new ColumnInfo();
                primaryKeyColumn.setColumnName(primaryKey);
                columnList.add(primaryKeyColumn);

                List<Map<String, Object>> dataList = dataConverterDao.getTableDataInfo(tableName, primaryKey,
                        startIndex, endIndex, columnList);

                for (Map<String, Object> map : dataList) {
                    List<SensitiveDataDTO> sensitiveList = new ArrayList<SensitiveDataDTO>();
                    for (ColumnInfo columnInfo : columnList) {
                        String columnValue = ((String) map.get(columnInfo.getColumnName()));

                        if(StringUtils.isNotEmpty(columnValue)){
                            String value = columnValue.trim();
                            //设置value
                            columnInfo.setColumnValue(value);

                            SensitiveDataDTO dto = new SensitiveDataDTO();
                            dto.setClearText(value);
                            dto.setDataType(columnInfo.getDataType());

                            sensitiveList.add(dto);
                        }

                    }
                    //保存
                    if (sensitiveList.size() == 0) {
                        break;
                    }

                    Result<Map<String, String>> result = sensitiveDataFacade.saveSensitiveDataBatch(sensitiveList);

                    if (SensitiveDataServiceCode.SYSTEM_NORMAL.getCode() == result.getStatus()){
                        Map<String, String> resultMap = result.getData();

                        if(null != resultMap && resultMap.size() > 0) {
                            List<ColumnInfo> updateColumnList = new ArrayList<ColumnInfo>();

                            for (ColumnInfo columnInfo : columnList) {
                                String originValue = columnInfo.getColumnValue();

                                if(StringUtils.isNotEmpty(originValue)){
                                    String resultValue = resultMap.get(originValue);
                                    if (StringUtils.isNotEmpty(resultValue)){
                                        ColumnInfo updateColumn = new ColumnInfo();
                                        updateColumn.setColumnName(columnInfo.getColumnName());
                                        updateColumn.setColumnValue(resultValue);

                                        updateColumnList.add(updateColumn);
                                    }

                                }

                            }
                            //更新
                            Integer primaryKeyValue = (Integer) map.get(primaryKey);
                            dataConverterDao.updateTableInfo(tableName, primaryKey, primaryKeyValue, updateColumnList);
                        }

                    }

                }

            }




        }
    }
}
