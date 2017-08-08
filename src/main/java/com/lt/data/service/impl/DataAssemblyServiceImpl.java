package com.lt.data.service.impl;

import com.lt.data.model.ColumnInfo;
import com.lt.data.model.TableInfo;
import com.lt.data.service.DataAssemblyService;
import com.touna.loan.sensitive.facade.code.SensitiveDataType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liutao on 2017/8/8.
 */
@Service
public class DataAssemblyServiceImpl implements DataAssemblyService {

    public TableInfo dataAssembly(String tableName, String primaryKey, Map<String, Integer> columnMap) {
        TableInfo tb = new TableInfo();
        tb.setTableName(tableName);
        tb.setPrimaryKey(primaryKey);

        List<ColumnInfo> columnList = new ArrayList<ColumnInfo>();

        for (Map.Entry<String, Integer> entry :columnMap.entrySet()){
            ColumnInfo columnInfo = new ColumnInfo();
            columnInfo.setColumnName(entry.getKey());
            columnInfo.setDataType(entry.getValue());

            columnList.add(columnInfo);
        }

        tb.setColumnList(columnList);

        return tb;
    }

    public List<TableInfo> getTableList(){
        List<TableInfo> tableList = new ArrayList<TableInfo>();
        tableList.add(getReturn());
        tableList.add(getRiskmanageApplyinfo());
        tableList.add(getRecpayinfo());
        tableList.add(getZzchmd());
        tableList.add(getContactor());
        tableList.add(getLinkman());
        tableList.add(getContact());
        tableList.add(getHouseproperty());
        tableList.add(getEstateinfo());
        tableList.add(getPyzx());
        tableList.add(getContactCar());
        tableList.add(getBlackdetail());
        tableList.add(getDzyw());
        tableList.add(getGpsInstall());
        tableList.add(getCarmessage());
        tableList.add(getRecpayinfouseHis());
        tableList.add(getRecpayinfouse());
        tableList.add(getCardcheck());
        tableList.add(getPayment());
        tableList.add(getPaymentdetail());
        tableList.add(getContract());
        tableList.add(getUnifiedGuarantor());
        tableList.add(getCustaccountOld());
        tableList.add(getCustaccountNew());
        tableList.add(getCustaccount());
        tableList.add(getBankcard());
        tableList.add(getCustExtra());
        tableList.add(getTongdun());
        tableList.add(getInvestigatela());
        tableList.add(getJxlreport());
        tableList.add(getJxl());
        tableList.add(getDf());
        tableList.add(getEvaluatereport());
        tableList.add(getProfession());
        tableList.add(getHouseinfo());
        tableList.add(getContinueloan());
        tableList.add(getBasicinfoMaintenance());
        tableList.add(getSysLenderInfo());
        tableList.add(getBrokencheckInfo());
        tableList.add(getSysBlackInfo());
        tableList.add(getEmpHisInfo());
        tableList.add(getEmpInfo());
        tableList.add(getCustInfo());
        tableList.add(getSurvey());
        tableList.add(getCustaccountHis());
        tableList.add(getZqr());
        return tableList;
    }

    //1 tb_riskmanage_applyinfo
    public TableInfo getRiskmanageApplyinfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("DOCNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("MOBILE2", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("MOBILE3", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_riskmanage_applyinfo", "id", columnMap);
    }

    //2 tb_lf_return
    public TableInfo getReturn(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lf_return", "ID", columnMap);
    }

    //3 tb_lf_recpayinfo
    public TableInfo getRecpayinfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());

        return  this.dataAssembly("tb_lf_recpayinfo", "ID", columnMap);
    }

    //4 tb_zx_zzchmd
    public TableInfo getZzchmd(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("pid", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("mobileNo", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("work_phone", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("home_phone", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("home_address", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_zx_zzchmd", "ID", columnMap);
    }

    //5 tb_lb_contactor
    public TableInfo getContactor(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("ADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("TELEPHONE", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_contactor", "ID", columnMap);
    }

    //6 tb_con_linkman
    public TableInfo getLinkman(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("MOBILE_PHONE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("WORK_PHONE", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_con_linkman", "ROW_ID", columnMap);
    }

    //7 tb_contact
    public TableInfo getContact(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("HOUSE_ADDRESS", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("PRI_PHONE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("SEC_PHONE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("HOME_PHONE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("LOCAL_STREET", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("ID_CODE", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_contact", "ROW_ID", columnMap);
    }

    //8 tb_contact_houseproperty
    public TableInfo getHouseproperty(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("HOUSE_ADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_contact_houseproperty", "ROW_ID", columnMap);
    }

    //9 tb_lb_estateinfo
    public TableInfo getEstateinfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("ADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("OTHERADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_lb_estateinfo", "ID", columnMap);
    }


    //10 tb_lb_pyzx
    public TableInfo getPyzx(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("ADDRESS", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("PHONE", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_pyzx", "ID", columnMap);
    }

    //11 tb_contact_car
    public TableInfo getContactCar(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("LICENSE_PLATE", SensitiveDataType.CAR_NUMBER.getCode());

        return  this.dataAssembly("tb_contact_car", "ROW_ID", columnMap);
    }

    //12 tb_sys_blackdetail
    public TableInfo getBlackdetail(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("car_no", SensitiveDataType.CAR_NUMBER.getCode());

        return  this.dataAssembly("tb_sys_blackdetail", "id", columnMap);
    }

    //13 tb_lm_dzyw
    public TableInfo getDzyw(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CARNO", SensitiveDataType.CAR_NUMBER.getCode());
        columnMap.put("FCDZ", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_lm_dzyw", "ID", columnMap);
    }

    //14 tb_lb_gps_install
    public TableInfo getGpsInstall(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CARNO", SensitiveDataType.CAR_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_gps_install", "ID", columnMap);
    }

    //15 tb_lb_carmessage
    public TableInfo getCarmessage(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CARNO", SensitiveDataType.CAR_NUMBER.getCode());
        columnMap.put("After_carno ", SensitiveDataType.CAR_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_carmessage", "ID", columnMap);
    }

    //16 tb_lf_recpayinfouse_his
    public TableInfo getRecpayinfouseHis(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());

        return  this.dataAssembly("tb_lf_recpayinfouse_his", "ID", columnMap);
    }

    //17 tb_lf_recpayinfouse
    public TableInfo getRecpayinfouse(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());

        return  this.dataAssembly("tb_lf_recpayinfouse", "ID", columnMap);
    }

    //18 tb_fuyou_cardcheck
    public TableInfo getCardcheck(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("docno", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("bankno", SensitiveDataType.BANK_CARD_NUMBER.getCode());

        return  this.dataAssembly("tb_fuyou_cardcheck", "id", columnMap);
    }

    //19 tb_lm_payment
    public TableInfo getPayment(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lm_payment", "ID", columnMap);
    }

    //20 tb_lm_paymentdetail
    public TableInfo getPaymentdetail(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());

        return  this.dataAssembly("tb_lm_paymentdetail", "ID", columnMap);
    }

    //21 tb_lm_contract
    public TableInfo getContract(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("ADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_lm_contract", "ID", columnMap);
    }

    //22 tb_unified_guarantor
    public TableInfo getUnifiedGuarantor(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("mobile", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("idcard", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("current_addr", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("domicile_addr", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_unified_guarantor", "id", columnMap);
    }

    //23 tb_lm_custaccount_old
    public TableInfo getCustaccountOld(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lm_custaccount_old", "ID", columnMap);
    }

    //24 tb_lm_custaccount_new
    public TableInfo getCustaccountNew(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lm_custaccount_new", "ID", columnMap);
    }

    //45 tb_lm_custaccount_his
    public TableInfo getCustaccountHis(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lm_custaccount_his", "ID", columnMap);
    }

    //25 tb_lm_custaccount
    public TableInfo getCustaccount(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lm_custaccount", "ID", columnMap);
    }

    //26 tb_sj_bankcard
    public TableInfo getBankcard(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());
        columnMap.put("TEL", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_sj_bankcard", "ID", columnMap);
    }

    //27 tb_lm_cust_extra
    public TableInfo getCustExtra(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("ex_doc_no", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("ex_telephone", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("ex_home_address", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("ex_per_address", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_lm_cust_extra", "id", columnMap);
    }

    //28 tb_lb_tongdun
    public TableInfo getTongdun(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("docno", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_tongdun", "id", columnMap);
    }

    //29 tb_lb_survey
    public TableInfo getSurvey(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_survey", "ID", columnMap);
    }

    //30 tb_lb_investigatela
    public TableInfo getInvestigatela(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_investigatela", "ID", columnMap);
    }

    //31 tb_zx_jxlreport
    public TableInfo getJxlreport(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("DOCNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_zx_jxlreport", "ID", columnMap);
    }

    //32 tb_zx_jxl
    public TableInfo getJxl(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("DOCNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_zx_jxl", "ID", columnMap);
    }


    //33 tb_zx_df
    public TableInfo getDf(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("cardNo", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_zx_df", "ID", columnMap);
    }

    //34 tb_lb_evaluatereport
    public TableInfo getEvaluatereport(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CARDNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("CARNO", SensitiveDataType.CAR_NUMBER.getCode());
        columnMap.put("HOUSEADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_lb_evaluatereport", "ID", columnMap);
    }

    //35 tb_lb_profession
    public TableInfo getProfession(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("TELEPHONE", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_profession", "ID", columnMap);
    }

    //36 tb_lb_houseinfo
    public TableInfo getHouseinfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("TELEPHONE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("ADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_lb_houseinfo", "ID", columnMap);
    }

    //37 tb_lb_continueloan
    public TableInfo getContinueloan(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("CUSTNO", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_continueloan", "ID", columnMap);
    }

    //38 tb_lb_basicinfo_maintenance
    public TableInfo getBasicinfoMaintenance(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("cardno", SensitiveDataType.ID_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_basicinfo_maintenance", "ID", columnMap);
    }

    //39 tb_sys_lender
    public TableInfo getSysLenderInfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("DOCNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("TEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("HJADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("XADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_sys_lender", "ID", columnMap);
    }


    //40 tb_sys_brokencheck
    public TableInfo getBrokencheckInfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("buyers_idCard", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("buyer_phone", SensitiveDataType.PHONE_NUMBER.getCode());
        return  this.dataAssembly("tb_sys_brokencheck", "id", columnMap);
    }

    //41 tb_sys_black
    public TableInfo getSysBlackInfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("docno", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("mobile", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("hometel", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("companytel", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("homeaddr", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_sys_black", "id", columnMap);
    }
    //42 tb_sys_emp_his
    public TableInfo getEmpHisInfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("IDCARD", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());
        columnMap.put("HOMETEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("OFFICETEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("TEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("HOMEADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_sys_emp_his", "ID", columnMap);
    }

    //43 tb_sys_emp
    public TableInfo getEmpInfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("IDCARD", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("BANKNO", SensitiveDataType.BANK_CARD_NUMBER.getCode());
        columnMap.put("HOMETEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("OFFICETEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("TEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("HOMEADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_sys_emp", "ID", columnMap);
    }

    //44 tb_lb_custinfo
    public TableInfo getCustInfo(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("DOCNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("MOBILE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("SPOUSETEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("SPOUSECORPTEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("SPOUSEDOCNO", SensitiveDataType.ID_NUMBER.getCode());
        columnMap.put("BANK_PHONE", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("ESTATEADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("HOME_ADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("HOUSEHOLD", SensitiveDataType.DETAIL_ADDRESS.getCode());
        columnMap.put("MOBILE2", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("MOBILE3", SensitiveDataType.PHONE_NUMBER.getCode());

        return  this.dataAssembly("tb_lb_custinfo", "ID", columnMap);
    }

    //46 tb_sys_zqr
    public TableInfo getZqr(){
        Map<String, Integer> columnMap = new HashMap<String, Integer>();
        columnMap.put("TEL", SensitiveDataType.PHONE_NUMBER.getCode());
        columnMap.put("ADDR", SensitiveDataType.DETAIL_ADDRESS.getCode());

        return  this.dataAssembly("tb_sys_zqr", "ID", columnMap);
    }

}
