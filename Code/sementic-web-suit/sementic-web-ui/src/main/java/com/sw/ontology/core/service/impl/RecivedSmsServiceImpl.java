/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.RecivedSmsDao;
import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.core.service.MemberMasterService;
import com.sw.ontology.core.service.MemberPointLedgerService;
import com.sw.ontology.core.service.RecivedSmsService;
import com.sw.ontology.core.service.SmsLogService;
import com.sw.ontology.model.MemberMaster;
import com.sw.ontology.model.RecivedSms;
import com.sw.ontology.model.SmsLog;
import com.sw.ontology.model.enums.SmsLogStatus;
import com.sw.ontology.model.enums.SmsLogType;
import com.sw.ontology.util.DateUtil;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class RecivedSmsServiceImpl implements RecivedSmsService {

    private final Logger logger = LoggerFactory.getLogger(RecivedSmsServiceImpl.class);

    @Autowired
    private RecivedSmsDao recivedSmsDao;
    @Autowired
    private MemberMasterService memberMasterService;
    @Autowired
    private SmsLogService smsLogService;
    @Autowired
    private MemberPointLedgerService memberPointLedgerService;

    @Transactional
    @Override
    public void save(String originatedNo, String msg, String time) throws SystemException {
        try {
            RecivedSms recivedSm = new RecivedSms();
            recivedSm.setMessage(msg);
            recivedSm.setMobileNo(originatedNo);
            recivedSm.setReceivedTime(DateUtil.stringToDate(time, "YYYY-MM-dd HH:mm:ss"));
            recivedSm.setAddedBy("SYNCER");
            recivedSm.setAddedDate(new Date());
            recivedSmsDao.create(recivedSm);
            //
            logger.info("SMS Received from " + originatedNo);
            String formatedMobileNo = "0" + originatedNo.substring(2);//to format 94712418969 to 0712418969
            MemberMaster memberMaster = memberMasterService.findByMobileNo(formatedMobileNo);
            if (msg.equalsIgnoreCase("BAL") && memberMaster != null) {
                //get balance points
                double inquiryPointBalance = memberPointLedgerService.getBalancePoints(memberMaster.getMemberCode());
                //save sms log
                SmsLog smsLog = new SmsLog();
                smsLog.setMemberCode(memberMaster);
                //smsLog.setSmsText(SMS.buildBalanceSmsText(memberMaster, inquiryPointBalance));
                smsLog.setSmsType(SmsLogType.BALANCE_SMS);
                smsLog.setStatus(SmsLogStatus.PENDING);
                smsLog.setAddedBy("SYNCER");
                smsLog.setAddedDate(new Date());
                smsLog.setModifiedBy("SYNCER");
                smsLog.setModifiedDate(new Date());
                if (memberMaster.getContactMobile1() != null && memberMaster.getContactMobile1().length() == 10) {
                    smsLog.setMobileNo(memberMaster.getContactMobile1());
                    smsLogService.save(smsLog);
                } else if (memberMaster.getMobile2() != null && memberMaster.getMobile2().length() == 10) {
                    smsLog.setMobileNo(memberMaster.getMobile2());
                    smsLogService.save(smsLog);
                }
            }
        } catch (Exception e) {
            logger.error("error", e);
            throw new SystemException("error", e);
        }

    }

}
