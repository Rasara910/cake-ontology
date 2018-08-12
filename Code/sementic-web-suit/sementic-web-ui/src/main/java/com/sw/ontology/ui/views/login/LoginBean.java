/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.ui.views.login;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import javax.faces.bean.SessionScoped;

/**
 * Created by praveen on 8/12/18
 */

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private static MessageDigest md;
    private boolean loggedIn;

    @PostConstruct
    public void init() {
        //
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void loginAction() {
        try {
            String ePassword = "123";
            String enteredPassword = password;
            if (enteredPassword.equals(ePassword)) {
                loggedIn = true;
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() + "/views/index.xhtml");
            } else {
                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Inavlid", "xfg");
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            String error = "Error " + ex.getMessage();
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, error, error);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }
    }

    public void logoutAction() {
        try {
            loggedIn = false;
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changePasswword() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/views/user-updatepassword.jsf?username=" + getUsername());
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}
