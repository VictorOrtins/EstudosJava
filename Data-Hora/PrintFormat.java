import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class PrintFormat {
    public static void main(String[] args) {

        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter formato3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter formato4 = DateTimeFormatter.ISO_DATE_TIME;
        
        LocalDate localDateNow = LocalDate.now();
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        Instant instantNow = Instant.now();

        LocalDate parseLocalDate = LocalDate.parse("2023-02-28");
        LocalDateTime parseLocalDateTime = LocalDateTime.parse("2023-02-28T01:36:26");
        Instant instantParse1 = Instant.parse("2023-02-28T01:35:26Z");
        Instant instantParse2 = Instant.parse("2023-02-28T01:35:26-03:00");

        LocalDate parseLocalDateFormat = LocalDate.parse("29/06/1974",formato1);
        LocalDateTime parseLocalDateTimeFormat = LocalDateTime.parse("29/06/1974 22:39", formato2);

        LocalDate localDateOf = LocalDate.of(2022, 10, 27);
        LocalDateTime localDateTimeOf = LocalDateTime.of(2033, 10, 21, 20, 30, 57);

        //Tudo é printado no formato Padrão ISO 8601
        System.out.println(localDateNow);
        System.out.println(localDateTimeNow);
        System.out.println(instantNow);
        System.out.println(parseLocalDate);
        System.out.println(parseLocalDateTime);
        System.out.println(instantParse1);
        System.out.println(instantParse2);
        System.out.println(parseLocalDateFormat);
        System.out.println(parseLocalDateTimeFormat);
        System.out.println(localDateOf);
        System.out.println(localDateTimeOf);

        //Printando em formatos diferentes, definidos por objetos da classe DateTimeFormatter
        System.out.println(parseLocalDate.format(formato1));
        System.out.println(formato1.format(parseLocalDate));
        System.out.println(parseLocalDateTime.format(formato2));
        System.out.println(formato3.format(instantParse1));
        System.out.println(parseLocalDateTime.format(formato4));
    }
}
