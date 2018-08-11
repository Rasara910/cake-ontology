/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.model.RedeemDetailsStatusHistory;
import com.sw.ontology.model.RedeemDetails;

/**
 *
 * @author Amith
 */
public interface RedeemPointStatusHistoryService {
    
     public void save(RedeemDetails redeemPoints)throws Exception;
    
    public void save(RedeemDetailsStatusHistory redeemPointStatusHistory)throws Exception;
}
