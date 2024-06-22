package com.comunicacao.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("unused")
public class DateUtils {

    public static final String PADRAO_DATA = "dd/MM/yyyy";
    public static final String PADRAO_HORA = "HH:mm:ss";
    public static final String PADRAO_DATA_HORA = PADRAO_DATA +"|"+ PADRAO_HORA;

    public static final DateTimeFormatter FORMATO_PADRAO_DATA = DateTimeFormatter.ofPattern(PADRAO_DATA);
    public static final DateTimeFormatter FORMATO_PADRAO_HORA = DateTimeFormatter.ofPattern(PADRAO_HORA);
    public static final DateTimeFormatter FORMATO_PADRAO_DATA_HORA = DateTimeFormatter.ofPattern(PADRAO_DATA_HORA);

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATO_PADRAO_DATA_HORA);
    }

    public static String localDateToString(LocalDate localDate) {
        return localDate.format(FORMATO_PADRAO_DATA);
    }

    public static String localTimeToString(LocalTime localTime) {
        return localTime.format(FORMATO_PADRAO_HORA);
    }

}
