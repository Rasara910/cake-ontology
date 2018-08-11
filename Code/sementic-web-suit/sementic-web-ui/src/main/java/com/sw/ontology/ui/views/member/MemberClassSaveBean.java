/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.ui.views.member;

import com.sw.ontology.core.service.MemberClassService;
import com.sw.ontology.model.MemberClass;
import com.sw.ontology.ui.utils.JsfUtil;
import com.sw.ontology.ui.views.SecurityBean;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author amithfernando
 */

@Component
@ManagedBean
@ViewScoped
public class MemberClassSaveBean extends SecurityBean implements Serializable{
    
    public MemberClass memberClass;
    @Autowired
    private MemberClassService memberClassService;
    
    @PostConstruct
    public void init(){
        memberClass=new MemberClass();
    }
    
    public void save(){
        try {
            memberClass.setAddedBy(getLoggedUserName());
            memberClass.setAddedDate(new Date());
            memberClass.setModifiedBy(getLoggedUserName());
            memberClass.setModifiedDate(new Date());
            memberClassService.save(memberClass);
            JsfUtil.showInfoMessage( "Save succeeded!");
            memberClass=new MemberClass();
        } catch (Exception e) {
            e.printStackTrace();
            JsfUtil.showFatalessage(e.getMessage());
        }
    }

    public MemberClass getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(MemberClass memberClass) {
        this.memberClass = memberClass;
    }

    
    public MemberClassService getMemberClassService() {
        return memberClassService;
    }

    public void setMemberClassService(MemberClassService memberClassService) {
        this.memberClassService = memberClassService;
    }
    
    
    
}
