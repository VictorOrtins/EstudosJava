import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Conversao {
    public static void main(String[] args) {
        // for(String s: ZoneId.getAvailableZoneIds()){
        //     System.out.println(s);
        // }

        LocalDate localDate = LocalDate.parse("2022-07-20");
        LocalDateTime localDateTime = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant instant = Instant.parse("2022-07-20T01:30:26Z");

        LocalDate localDateSystemDefault = LocalDate.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDatePortugal = LocalDate.ofInstant(instant, ZoneId.of("Portugal"));
        LocalDateTime localDateTimeSystemDefault = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDateTime localDateTimePortugal = LocalDateTime.ofInstant(instant, ZoneId.of("Portugal"));

        // System.out.println(localDateSystemDefault);
        // System.out.println(localDatePortugal);
        // System.out.println(localDateTimeSystemDefault);
        // System.out.println(localDateTimePortugal);

        // System.out.println("dia d1 = " + localDate.getDayOfMonth());
        // System.out.println("hora d2 = " + localDateTime.getHour());

        LocalDate pastWeekLocalDate = localDate.minusDays(7);
        LocalDate nextWeekLocalDate = localDate.plusDays(7);

        LocalDateTime pastWeekLocalDateTime = localDateTime.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = localDateTime.plusDays(7);

        Instant pastWeekInstant = instant.minus(7, ChronoUnit.DAYS).minus(10, ChronoUnit.HOURS);
        Instant nextWeekInstant = instant.plus(7, ChronoUnit.DAYS);

        // System.out.println(pastWeekLocalDate);
        // System.out.println(nextWeekLocalDate);
        // System.out.println(pastWeekLocalDateTime);
        // System.out.println(nextWeekLocalDateTime);
        // System.out.println(pastWeekInstant);
        // System.out.println(nextWeekInstant);

        Duration duration1 = Duration.between(pastWeekLocalDate.atStartOfDay(), nextWeekLocalDate.atStartOfDay());
        Duration duration2 = Duration.between(pastWeekLocalDateTime, localDateTime);
        Duration duration3 = Duration.between(nextWeekInstant, pastWeekInstant);

        System.out.println(duration1.toDays());
        System.out.println(duration2.toDays());
        System.out.println(duration3.toMinutes()); //Negativo porque o primeiro argumento de between é o dia mais a frente
    }
}
