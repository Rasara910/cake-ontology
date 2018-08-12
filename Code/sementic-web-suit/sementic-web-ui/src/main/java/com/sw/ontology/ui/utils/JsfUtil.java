/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.ui.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 * Created by praveen on 8/12/18
 */
public class JsfUtil {
    
    public static String getAbsolutePath(String path) {
        String relativeWebPath = path;
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
        return absoluteDiskPath;
    } 
    
    public static void showInfoMessage(String msg){
         FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
     public static void showFatalessage(String msg){
         FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg);
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
}
