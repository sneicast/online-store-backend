package dev.scastillo.admin.shared.util;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeUtils {
    private static final ZoneId COLOMBIA_ZONE = ZoneId.of("America/Bogota");

    public static OffsetDateTime now() {
        return ZonedDateTime.now(COLOMBIA_ZONE).toOffsetDateTime();
    }
}
