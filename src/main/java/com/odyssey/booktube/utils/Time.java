package com.odyssey.booktube.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Time {
    private static final Logger logger = LoggerFactory.getLogger(Time.class);

    public static Date getCurrentUtcTime()  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat ldf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        Date d1 = null;
        try {
            d1 = ldf.parse( sdf.format(new Date()) );
        }
        catch (java.text.ParseException e) {
            logger.error(e.getMessage());
        }
        return d1;
    }
}
