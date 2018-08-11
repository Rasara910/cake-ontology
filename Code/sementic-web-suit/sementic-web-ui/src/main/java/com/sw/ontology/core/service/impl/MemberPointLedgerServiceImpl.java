/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import java.util.List;

import com.sw.ontology.core.dao.MemberPointLedgerDao;
import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.core.service.MemberPointLedgerService;
import com.sw.ontology.model.MemberPointLedger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class MemberPointLedgerServiceImpl implements MemberPointLedgerService {

    private final Logger logger = LoggerFactory.getLogger(MemberPointLedgerServiceImpl.class);

    @Autowired
    private MemberPointLedgerDao memberPointLedgerDao;

    @Override
    public double getBalancePoints(String memberCode) {
        MemberPointLedger memberPointLedger = memberPointLedgerDao.read(memberCode);
        if (memberPointLedger != null) {
            return memberPointLedger.getPointBalance();
        } else {
            return 0.0;
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void updateCredit(String memberCode, double value) throws SystemException {
        try {
            MemberPointLedger memberPointLedger = memberPointLedgerDao.read(memberCode);
            if (memberPointLedger != null) {
                double currentBalance = memberPointLedger.getPointBalance();
                double updatedBalance = currentBalance + value;
                memberPointLedger.setPointBalance(updatedBalance);
                memberPointLedgerDao.update(memberPointLedger);
            } else {
                memberPointLedger = new MemberPointLedger();
                memberPointLedger.setMemberCode(memberCode);
                memberPointLedger.setPointBalance(value);
                memberPointLedgerDao.create(memberPointLedger);
            }
        } catch (Exception e) {
            logger.error("error occured in updateCredit()", e);
            throw new SystemException("error", e);
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void updateDebit(String memberCode, double value) throws SystemException {
        try {
            MemberPointLedger memberPointLedger = memberPointLedgerDao.read(memberCode);
            if (memberPointLedger != null) {
                double currentBalance = memberPointLedger.getPointBalance();
                double updatedBalance = currentBalance - value;
                memberPointLedger.setPointBalance(updatedBalance);
                memberPointLedgerDao.update(memberPointLedger);
            } else {
                memberPointLedger = new MemberPointLedger();
                memberPointLedger.setMemberCode(memberCode);
                memberPointLedger.setPointBalance(value * (-1));
                memberPointLedgerDao.create(memberPointLedger);
            }
        } catch (Exception e) {
            logger.error("error occured in updateDebit()", e);
            throw new SystemException("error", e);
        }
    }

    @Override
    public List<MemberPointLedger> getAllBalancePoints() {
        return memberPointLedgerDao.findAll();
    }

}
