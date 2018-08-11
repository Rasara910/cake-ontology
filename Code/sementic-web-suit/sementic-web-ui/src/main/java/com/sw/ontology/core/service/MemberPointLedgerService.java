/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;
import java.util.List;

import com.sw.ontology.model.MemberPointLedger;

/**
 *
 * @author Amith
 */
public interface MemberPointLedgerService {

    public void updateCredit(String memberCode, double value) throws SystemException;

    public void updateDebit(String memberCode, double value) throws SystemException;

    public double getBalancePoints(String memberCode);
    
    public List<MemberPointLedger> getAllBalancePoints();
}
