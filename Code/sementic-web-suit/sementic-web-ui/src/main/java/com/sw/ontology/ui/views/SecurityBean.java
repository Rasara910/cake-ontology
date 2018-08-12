/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.ui.views;

import com.sw.ontology.ui.views.login.LoginBean;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 * Created by praveen on 8/12/18
 */
public abstract class SecurityBean {

    public String getLoggedUserName() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
            LoginBean loginBean = (LoginBean) sessionMap.get("loginBean");
            if (loginBean.isLoggedIn()) {
                return loginBean.getUsername();
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }

    }

}
