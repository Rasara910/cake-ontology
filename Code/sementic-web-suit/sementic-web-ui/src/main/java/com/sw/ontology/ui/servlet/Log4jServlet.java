/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.ui.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.bridge.SLF4JBridgeHandler;

/**
 *
 * @author amithfernando
 */
public class Log4jServlet implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg) {
        System.out.println("contextInitialized....");

        //remove the jsf root logger, avoid duplicated logging
        //try comment out this and see the different on the console
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg) {
        System.out.println("contextDestroyed....");

    }

}


