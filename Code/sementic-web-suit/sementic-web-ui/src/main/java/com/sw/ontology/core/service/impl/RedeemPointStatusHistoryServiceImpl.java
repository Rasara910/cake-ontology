/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.RedeemDetailsStatusHistoryDao;
import com.sw.ontology.core.service.RedeemPointStatusHistoryService;
import com.sw.ontology.model.RedeemDetailsStatusHistory;
import com.sw.ontology.model.RedeemDetails;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class RedeemPointStatusHistoryServiceImpl implements RedeemPointStatusHistoryService {

    @Autowired
    private RedeemDetailsStatusHistoryDao redeemPointStatusHistoryDao;

    @Transactional
    @Override
    public void save(RedeemDetailsStatusHistory redeemPointStatusHistory) throws Exception {
        redeemPointStatusHistoryDao.create(redeemPointStatusHistory);
    }

    @Transactional
    @Override
    public void save(RedeemDetails redeemPoints) throws Exception {
        RedeemDetailsStatusHistory pointStatusHistory = new RedeemDetailsStatusHistory();
        pointStatusHistory.setChangedBy(redeemPoints.getModifiedBy());
        pointStatusHistory.setChangedDate(new Date());
        pointStatusHistory.setRedemptionReferenceId(redeemPoints);
        pointStatusHistory.setStatus(redeemPoints.getStatus());
        redeemPointStatusHistoryDao.create(pointStatusHistory);
    }

}
