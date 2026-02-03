package example.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TestDataUtils {

    private TestDataUtils() {
    }

    public static String generateEmail() {
        return "testuser_"
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
                + "@mail.com";
    }
}
