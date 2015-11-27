package com.epam.vakhidat.news_management.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateConverter {
    public static Date dateFromString(String stringDate) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sf.parse(stringDate);
        return date;
    }
}
