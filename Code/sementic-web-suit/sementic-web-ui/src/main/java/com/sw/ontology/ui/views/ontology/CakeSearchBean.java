package com.sw.ontology.ui.views.ontology;

import com.sw.ontology.core.service.CakeOntologyService;
import com.sw.ontology.ui.views.SecurityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by praveen on 8/12/18
 */


@ManagedBean
@ViewScoped
public class CakeSearchBean extends SecurityBean implements Serializable {

    public List<String> cakeBaseList;
    private String selectedBase;

    @Autowired
    private CakeOntologyService cakeOntologyService;

    @PostConstruct
    public void init() {
        cakeBaseList = cakeOntologyService.findAllCakeBases();
    }


    public List<String> getCakeBaseList() {
        return cakeBaseList;
    }

    public void setCakeBaseList(List<String> cakeBaseList) {
        this.cakeBaseList = cakeBaseList;
    }

    public CakeOntologyService getCakeOntologyService() {
        return cakeOntologyService;
    }

    public void setCakeOntologyService(CakeOntologyService cakeOntologyService) {
        this.cakeOntologyService = cakeOntologyService;
    }

    public String getSelectedBase() {
        return selectedBase;
    }

    public void setSelectedBase(String selectedBase) {
        this.selectedBase = selectedBase;
    }
}
