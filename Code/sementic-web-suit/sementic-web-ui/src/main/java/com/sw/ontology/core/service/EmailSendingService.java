/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.model.RedeemDetails;

/**
 *
 * @author Amith
 */
public interface EmailSendingService {
    
    
    public void redemptionCreateEmail(RedeemDetails redeemDetails)throws SystemException;

    public void sendEmail(String toEmail, String subject, String body) throws SystemException;

	public void sendPasswordTokenEmail(String url, String toEmail) throws SystemException;
}
