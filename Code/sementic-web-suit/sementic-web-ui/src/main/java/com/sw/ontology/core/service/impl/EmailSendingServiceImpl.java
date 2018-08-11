/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.core.service.EmailSendingService;
import com.sw.ontology.core.service.EmailService;
import com.sw.ontology.core.service.MemberPointLedgerService;
import com.sw.ontology.core.service.UserService;
import com.sw.ontology.model.Email;
import com.sw.ontology.model.MemberMaster;
import com.sw.ontology.model.RedeemDetails;
import com.sw.ontology.model.User;
import com.sw.ontology.model.enums.EmailStatus;
import com.sw.ontology.model.enums.SystemRole;
import com.sw.ontology.util.DateUtil;
import java.util.Date;
import java.util.List;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class EmailSendingServiceImpl implements EmailSendingService {

    private final Logger logger = LoggerFactory.getLogger(EmailSendingServiceImpl.class);

    @Autowired
    private EmailService emailService;
    @Autowired
    private MemberPointLedgerService memberPointLedgerService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void redemptionCreateEmail(RedeemDetails redeemDetails) throws SystemException {
        try {
            MemberMaster memberMaster = redeemDetails.getMemberCode();
            double points = redeemDetails.getNoOfPoints();
            String requestedFrom = redeemDetails.getRequestedFromShowroom().getShowroomName();
            double balancePoint = memberPointLedgerService.getBalancePoints(memberMaster.getMemberCode());
            String requestedTime = DateUtil.dateToString(redeemDetails.getRedemptionRequestedDate(), "yyyy-MM-dd");
            List<User> users = userService.findByRoleName(SystemRole.FUNCTIONAL_MANAER);
            String subject = "Redemption Request";
            String body = memberMaster.getSalutation().getSalutation() + ". " + memberMaster.getName1() + " " + memberMaster.getName2();
            body += " requested " + points + " points from " + requestedFrom + " showroom at " + requestedTime;
            body += "<br><br>";
            body += "Added By " + redeemDetails.getAddedBy() + "<br>";
            body += "Added Date " + DateUtil.dateToString(redeemDetails.getAddedDate(), "yyyy-MM-dd") + "<br>";
            for (User user : users) {
                Email email = new Email();
                if (user.getEmail() != null) {
                    email.setToEmail(user.getEmail());
                    email.setSubject(subject);
                    String salutation = "Hi " + user.getUserName() + "<br><br>";
                    email.setBody(salutation + body);
                    email.setAddedBy(redeemDetails.getAddedBy());
                    email.setAddedDate(new Date());
                    email.setModifiedBy(redeemDetails.getModifiedBy());
                    email.setModifiedDate(new Date());
                    email.setStatus(EmailStatus.PENDING);
                    emailService.save(email);
                }
            }
        } catch (Exception e) {
            logger.error("error occured in redemptionCreateEmail()", e);
            throw new SystemException("error", e);
        }

    }

    @Override
    public void sendEmail(String toEmail, String subject, String body) throws SystemException {
        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            mailMessage.setContent(body, "text/html ");
            mailMessage.setSubject(subject);
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailSender.send(mailMessage);
        } catch (Exception e) {
            logger.error("error occured in sendEmail()", e);
            throw new SystemException("error", e);
        }

    }

    @Override
    @Transactional
    public void sendPasswordTokenEmail(String url, String toEmail) throws SystemException {
        try {
            String subject = "Loyalty - Password Renewal";
            String body = "Hi User,<br/><br/>";
            body += "Please go to following url to verify your new password<br><br>";
            body += "" + url + "<br><br>";
            body += "Thank you!<br/><br/>";
            Email email = new Email();
            email.setAddedBy("SYSTEM");
            email.setAddedDate(new Date());
            email.setModifiedBy("SYSTEM");
            email.setModifiedDate(new Date());
            email.setBody(body);
            email.setSubject(subject);
            email.setToEmail(toEmail);
            email.setStatus(EmailStatus.PENDING);
            emailService.save(email);
        } catch (Exception e) {
            logger.error("error occured in sendPasswordTokenEmail()", e);
            throw new SystemException("error", e);
        }

    }

}
