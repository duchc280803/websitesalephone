package org.example.websitesalephone.utils;


import org.example.websitesalephone.comon.PagingRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utils {

    /**
     * Get paging request
     *
     * @param request PagingRequest
     * @return PageRequest
     */
    public static PageRequest getPaging(PagingRequest request) {
        int page = request.getPage() == null || request.getPage() < 1 ? 0 : request.getPage() - 1;
        PageRequest pageable = null;
        if (ObjectUtils.isEmpty(request.getSortBy())) {
            pageable = PageRequest.of(page, request.getSize() == null ? 20 : request.getSize());
        } else {
            pageable = PageRequest.of(page, request.getSize() == null ? 20 : request.getSize(),
                    Sort.by(request.isSortDesc() ? Sort.Direction.DESC : Sort.Direction.ASC,
                            request.getSortBy()));
        }
        return pageable;
    }
    public static String formatDate(OffsetDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return dateTime.atZoneSameInstant(ZoneId.systemDefault()).format(formatter);
    }


    /**
     * This method formats a given OffsetDateTime object into a string with the format "yyyy/MM/dd (E)".
     * The formatted string includes the year, month, day, and the day of the week in Japanese locale.
     *
     * @param dateTime The OffsetDateTime object to be formatted.
     * @return A string representing the formatted date with the day of the week in Japanese locale.
     *         If the input dateTime is null, the method returns null.
     */
    public static String formatDateWithDayOfWeekJapanese(OffsetDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd (E)")
                .withLocale(Locale.JAPANESE);
        return dateTime.atZoneSameInstant(ZoneId.systemDefault()).format(formatter);
    }

    /**
     * Convert half-width characters to full-width characters.
     *
     * @param input The input string containing half-width characters.
     * @return The input string with full-width characters.
     */
    public static String toFullWidth(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= '!' && c <= '~') {
                c += 0xFEE0;
            } else if (c == ' ') {
                c = '\u3000';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Adjusts the given {@link OffsetDateTime} to the end of the day.
     * The end of the day is defined as 23:59:59.999999000.
     *
     * @param dateTime the {@link OffsetDateTime} to be adjusted. If null, the method returns null.
     * @return the adjusted {@link OffsetDateTime} set to the end of the day, or null if the input was null.
     */
    public static OffsetDateTime toEndOfDay(OffsetDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime
                .atZoneSameInstant(ZoneId.systemDefault())
                .toOffsetDateTime()
                .withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999000)
                .atZoneSimilarLocal(ZoneId.systemDefault()).toOffsetDateTime();
    }

    /**
     * Adjusts the given {@link OffsetDateTime} to the start of the day.
     * The start of the day is defined as 00:00:00.000000000.
     *
     * @param dateTime the {@link OffsetDateTime} to be adjusted. If null, the method returns null.
     * @return the adjusted {@link OffsetDateTime} set to the start of the day, or null if the input was null.
     */
    public static OffsetDateTime toStartOfDay(OffsetDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime
                .atZoneSameInstant(ZoneId.systemDefault())
                .toOffsetDateTime()
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0)
                .atZoneSimilarLocal(ZoneId.systemDefault()).toOffsetDateTime();
    }

}

