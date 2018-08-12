package com.sw.ontology.ui.views.ontology;

import com.sw.ontology.core.service.impl.CakeOntology;
import com.sw.ontology.core.service.CakeOntologyService;
import com.sw.ontology.model.Cake;
import com.sw.ontology.ui.views.SecurityBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
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
    public List<String> cakeFruitAddingList;
    public List<String> cakeOtherIngredientList;
    public List<String> cakeOccasionList;
    public List<String> cakeShapeList;

    public List<Cake> cakeList;


    private String selectedBase;
    private String selectedFrosting;
    private String selectedTopping;
    private String selectedFruitAdding;
    private String selectedOtherIngredient;
    private String selectedOccasion;
    private String selectedShape;
    private String priceFrom;
    private String priceTo;

    private Cake selectedCake;


    @Autowired
    private CakeOntologyService cakeOntologyService;



    @PostConstruct
    public void init() {
        CakeOntology co =new CakeOntology();
        cakeBaseList = co.findAllCakeBases();
        cakeFrostingList=co.findAllFrostings();
        cakeToppingList=co.findAllToppings();
        cakeFruitAddingList=co.findAllFruitAddings();
        cakeOtherIngredientList=co.findAllOtherIngredients();
        cakeOccasionList=co.findAllOccasions();
        cakeShapeList=co.findAllShapes();
    }

    public void searchCake() {
        try {
//            memberMasters = memberMasterService.findMembersForMemberSearch(fromAddedDate, toAddedDate, addedBy, status, showroom, cardIssuance, memberCode, nic);
//            memberMasterService.getNoOfPoints(memberMasters);
//            Collections.sort(memberMasters, new Comparator<MemberMaster>() {
//                @Override
//                public int compare(MemberMaster mm1, MemberMaster mm2) {
//                    return mm1.getAddedDate().compareTo(mm2.getAddedDate());
//                }
//            });

            CakeOntology co =new CakeOntology();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public List<String> getCakeFruitAddingList() {
        return cakeFruitAddingList;
    }

    public void setCakeFruitAddingList(List<String> cakeFruitAddingList) {
        this.cakeFruitAddingList = cakeFruitAddingList;
    }

    public String getSelectedFruitAdding() {
        return selectedFruitAdding;
    }

    public void setSelectedFruitAdding(String selectedFruitAdding) {
        this.selectedFruitAdding = selectedFruitAdding;
    }

    public List<String> getCakeOtherIngredientList() {
        return cakeOtherIngredientList;
    }

    public void setCakeOtherIngredientList(List<String> cakeOtherIngredientList) {
        this.cakeOtherIngredientList = cakeOtherIngredientList;
    }

    public String getSelectedOtherIngredient() {
        return selectedOtherIngredient;
    }

    public void setSelectedOtherIngredient(String selectedOtherIngredient) {
        this.selectedOtherIngredient = selectedOtherIngredient;
    }

    public List<String> getCakeOccasionList() {
        return cakeOccasionList;
    }

    public void setCakeOccasionList(List<String> cakeOccasionList) {
        this.cakeOccasionList = cakeOccasionList;
    }

    public String getSelectedOccasion() {
        return selectedOccasion;
    }

    public void setSelectedOccasion(String selectedOccasion) {
        this.selectedOccasion = selectedOccasion;
    }

    public List<String> getCakeShapeList() {
        return cakeShapeList;
    }

    public void setCakeShapeList(List<String> cakeShapeList) {
        this.cakeShapeList = cakeShapeList;
    }

    public String getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(String selectedShape) {
        this.selectedShape = selectedShape;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public List<Cake> getCakeList() {
        return cakeList;
    }

    public void setCakeList(List<Cake> cakeList) {
        this.cakeList = cakeList;
    }

    public Cake getSelectedCake() {
        return selectedCake;
    }

    public void setSelectedCake(Cake selectedCake) {
        this.selectedCake = selectedCake;
    }
}
