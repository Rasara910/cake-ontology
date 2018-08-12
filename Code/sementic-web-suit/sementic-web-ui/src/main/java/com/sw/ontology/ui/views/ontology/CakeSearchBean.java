package com.sw.ontology.ui.views.ontology;

import com.sw.ontology.core.service.impl.CakeOntology;
import com.sw.ontology.core.service.CakeOntologyService;
import com.sw.ontology.ui.views.SecurityBean;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<String> cakeFrostingList;
    public List<String> cakeToppingList;


    private String selectedBase;
    private String selectedFrosting;
    private String selectedTopping;

    @Autowired
    private CakeOntologyService cakeOntologyService;



    @PostConstruct
    public void init() {
        CakeOntology co =new CakeOntology();
        cakeBaseList = co.findAllCakeBases();
        cakeFrostingList=co.findAllFrostings();
        cakeToppingList=co.findAllToppings();
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

    public List<String> getCakeFrostingList() {
        return cakeFrostingList;
    }

    public void setCakeFrostingList(List<String> cakeFrostingList) {
        this.cakeFrostingList = cakeFrostingList;
    }

    public String getSelectedFrosting() {
        return selectedFrosting;
    }

    public void setSelectedFrosting(String selectedFrosting) {
        this.selectedFrosting = selectedFrosting;

    }

    public List<String> getCakeToppingList() {
        return cakeToppingList;
    }

    public void setCakeToppingList(List<String> cakeToppingList) {
        this.cakeToppingList = cakeToppingList;
    }

    public String getSelectedTopping() {
        return selectedTopping;
    }

    public void setSelectedTopping(String selectedTopping) {
        this.selectedTopping = selectedTopping;
    }
}
