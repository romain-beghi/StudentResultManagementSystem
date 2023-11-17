package com.shyftlabs.srms.utils.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    private static final String DATE_PATTERN            = "yyyy-MM-dd";
    private static final DateTimeFormatter formatter    = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static LocalDate convert(String date) {
        return LocalDate.parse(date, formatter);
    }
}
