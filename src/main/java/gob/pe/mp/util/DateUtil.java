package gob.pe.mp.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public final class DateUtil {

    public static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private DateUtil() {
    }

    public static String getStringFromDate(final Date date, final String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static Date getDateFromString(final String date, final String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(date);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Date();
        }
    }

    public static String getActualString(final String formato) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
        return simpleDateFormat.format(getDateTimeZone(formato));
    }

    public static Date getActualDate(final String formato) {
        return getDateTimeZone(formato);
    }

    public static Date getDateTimeZone(final String formato) {
        try {
            Instant instant = Instant.now();
            ZoneId zoneId = ZoneId.of("America/Lima");
            ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formato);
            DateFormat dateFormat = new SimpleDateFormat(formato);
            String fechaString = zonedDateTime.format(dateTimeFormatter);

            return dateFormat.parse(fechaString);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new Date();
        }
    }

}
