/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.ui.views;



import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author Amith
 */
@ManagedBean
@ApplicationScoped
public class ApplicationBean {


    private String version = "V1.0";

    @PostConstruct
    public void init() {
        //
    }

    public String getVersion() {
        return version;
    }

   
}
