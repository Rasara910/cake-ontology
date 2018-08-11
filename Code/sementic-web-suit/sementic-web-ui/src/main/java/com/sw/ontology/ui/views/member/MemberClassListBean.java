/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.ui.views.member;

import com.sw.ontology.core.service.MemberClassService;
import com.sw.ontology.model.MemberClass;
import com.sw.ontology.ui.views.SecurityBean;
import java.io.Serializable;
import java.util.List;
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
public class MemberClassListBean extends SecurityBean implements Serializable{
    
    public List<MemberClass> memberClassList;
    @Autowired
    private MemberClassService memberClassService;
    
    @PostConstruct
    public void init(){
        memberClassList=memberClassService.findAll();
    }

    public List<MemberClass> getMemberClassList() {
        return memberClassList;
    }

    public void setMemberClassList(List<MemberClass> memberClassList) {
        this.memberClassList = memberClassList;
    }

    public MemberClassService getMemberClassService() {
        return memberClassService;
    }

    public void setMemberClassService(MemberClassService memberClassService) {
        this.memberClassService = memberClassService;
    }
    
    
    
}
