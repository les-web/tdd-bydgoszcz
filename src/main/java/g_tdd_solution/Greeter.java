package g_tdd_solution;
/*
Utwórz klasę Greeter.
Wykorzystując technikę TDD zaimplementuj metodę:
String generateGreeting(String name)
1.Metoda zwraca pozdrowienie w formie „Hello <imię>”.
2.Metoda usuwa białe znaki z początku i kooca otrzymanego stringa przed wyświetleniem pozdrowienia.
3.Metoda automatycznie zmienia pierwszą literę na wielką jeśli imię rozpoczyna się z małej litery.

Utwórz nowy interfejs TimeProvider a metodą zwracającą aktualny czas.
Zmodyfikuj klasę Greeter w taki sposób aby przyjmowała obiekt typu TimeProvider w konstruktorze.
4.Metoda powinna zwracad pozdrowienie „Good morning <imię>” między 6:00 a 12:00.
5.Metoda powinna zwracad pozdrowienie w formie „Good evening <imię>” między 18:00 a 22:00.
6.Metoda powinna zwracad pozdrowienie w formie „Good night <imię>” między 22:00 a 6:00.

 */
import java.time.LocalTime;

public class Greeter {

    private TimeProvider timeProvider;
    public static final String DEFAULT_GREETING = "Hello ";
    public static final String GOOD_MORNING = "Good morning ";
    public static final String GOOD_EVENING = "Good evening ";
    public static final String GOOD_NIGHT = "Good night ";

    public Greeter(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String generateGreeting(String name) {
        name = trimWhitespace(name);
        name = makeFirstLetterUppercase(name);

        String greeting = DEFAULT_GREETING;
        LocalTime currentTime = getCurrentTime();
        if(isMorning(currentTime)) {
            greeting = GOOD_MORNING;
        }
        if(isEvening(currentTime)) {
            greeting = GOOD_EVENING;
        }
        if(isNight(currentTime)) {
            greeting = GOOD_NIGHT;
        }
        return greeting + name;
    }

    private String trimWhitespace(String name) {
        name = name.trim();
        return name;
    }

    private String makeFirstLetterUppercase(String name) {
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        return name;
    }

    private LocalTime getCurrentTime() {
        return timeProvider.getCurrentTime();
    }

    private boolean isMorning(LocalTime currentTime) {
        return currentTime.isAfter(LocalTime.of(6,0)) && currentTime.isBefore(LocalTime.of(12,0));
    }

    private boolean isEvening(LocalTime currentTime) {
        return currentTime.isAfter(LocalTime.of(18,0)) && currentTime.isBefore(LocalTime.of(22,0));
    }

    private boolean isNight(LocalTime currentTime) {
        return currentTime.isBefore(LocalTime.of(6,0)) || currentTime.isAfter(LocalTime.of(22,0));
    }
}

interface TimeProvider {
    LocalTime getCurrentTime();
}
