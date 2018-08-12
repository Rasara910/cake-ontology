package com.sw.ontology.util;

import java.util.ResourceBundle;

/**
 * Created by praveen on 8/12/18
 */

public class PropertyReader {


    public static String getMappingProperties(final String propertyName) {
        ResourceBundle mappingResourceBundle = null;
        if (null == mappingResourceBundle) {
            mappingResourceBundle = ResourceBundle.getBundle("/properties/mapping");
        }

        return mappingResourceBundle.getString(propertyName);


    }

    public static String getReportProperties(final String propertyName) {
        ResourceBundle reportResourceBundle = null;
        if (null == reportResourceBundle) {
            reportResourceBundle = ResourceBundle.getBundle("/properties/report");
        }

        return reportResourceBundle.getString(propertyName);

    }

    public static String getApplicationProperties(final String propertyName) {
        ResourceBundle applicationResourceBundle = null;
        if (null == applicationResourceBundle) {
            applicationResourceBundle = ResourceBundle.getBundle("/properties/application");
        }

        return applicationResourceBundle.getString(propertyName);

    }


}
