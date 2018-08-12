// *************************************************************************************************
//
// PROJECT : Fortunaglobal School Management System
// PRODUCT : AOD School Management System
// ************************************************************************************************
//
// Copyright(C) 2014 Fortunaglobal (PRIVATE) LIMITED
// All rights reserved.
//
// THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
// Fortunaglobal(PRIVATE) LIMITED.
//
// This copy of the Source Code is intended for Fortunaglobal (PRIVATE) LIMITED 's internal use only
// and is
// intended for view by persons duly authorized by the management of Fortunaglobal (PRIVATE)
// LIMITED. No
// part of this file may be reproduced or distributed in any form or by any
// means without the written approval of the Management of Fortunaglobal (PRIVATE) LIMITED.
//
// *************************************************************************************************
//
// REVISIONS:
// Author : Sayyaff
// Date : Sep 26, 2014
// Since : version 1.0
// Description : 
// ************

package com.sw.ontology.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by praveen on 8/12/18
 */
public class DateUtil {

    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);


    public long convertToLong(String date, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);// dd-MMM-yyyy
        Date d = null;
        try {
            d = f.parse(date);
        } catch (ParseException e) {
            logger.error("ParseException occurred convertToLong()", e);
        }
        return d.getTime();
    }

    /**
     * String to Date Conversion
     *
     * @param sDate
     * @param format
     * @return
     * @throws ParseException
     */
    public static final Date stringToDate(String sDate, String format) {
        DateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = simpleDateFormat.parse(sDate);
        } catch (ParseException e) {

            logger.error("ParseException occurred stringToDate()", e);
        }
        return date;
    }

    /**
     * Date to String Conversion
     *
     * @param date
     * @param format
     * @return
     */
    public static final String dateToString(Date date, String format) {
        Format formatter = new SimpleDateFormat(format);
        String sDate = formatter.format(date);
        return sDate;
    }

    /**
     * Adding days to the current date
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); // minus number would decrement the days
        return cal.getTime();
    }

    /*
    this is for jasper report date and time
     */
    public static String getReportGeneratedDateTime() {

        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
        return df.format(new Date());
    }


}
