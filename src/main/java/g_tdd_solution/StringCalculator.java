package g_tdd_solution;
/*
Utwórz klasę StringCalculator.
Wykorzystując technikę TDD zaimplementuj metodę:
int add(String numbers)
Metoda powinna byd w stanie dodad dwie liczby oddzielone przecinkiem i zwrócid rezultat.
1.Dla wartości null powinna rzucad wyjątek typu IllegalArgumentException z informacją”null not allowed”.
2.Dla pustego łaocucha znaków (””) powinna zwracad 0.
3.Dla pojedynczej liczby (”1”) powinna zwrócid tę liczbę.
4.Dla dwóch liczb (”1,2”) powinna zwrócid ich sumę.
5.Metoda powinna wspierad dowolną liczbę liczb.
6.Metoda powinna wspierad również dwa inne separatory – średnik (;) oraz znak nowej linii (\n).
7.Jeżeli do metody przekazane zostały liczby ujemne metoda powinna rzucid wyjątek IllegalArgumentException z wiadomością ”negatives not allowed: ” i listą owych ujemnych liczb, np. ”negatives not allowed: -1,-2”.
8.Liczby większe niż 1000 powinny byd ignorowane (czyli 2 + 1001 = 2).
9.Metoda powinna wspierad dowolny jednoznakowy separator podany w odpowiednim formacie, np. dla znaku #:
 */
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class StringCalculator {

    public static final String SEPARATOR_REGEX = "[,;\n]";

    public int add(String numbers) {
        checkForNull(numbers);

        if (isEmpty(numbers)) {
            return 0;
        }

        return calculateSum(numbers);
    }

    private void checkForNull(String numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("null not allowed");
        }
    }

    private boolean isEmpty(String numbers) {
        return numbers.equals("");
    }

    private int calculateSum(String numbersString) {
        List<String> numbers = splitNumbers(numbersString);

        Map<Boolean, List<Integer>> all = partitionByBeingNegative(numbers);
        List<Integer> negatives = all.get(true);
        List<Integer> nonNegatives = all.get(false);

        if (!negatives.isEmpty()) {
            throwNegativeException(negatives);
        }
        return nonNegatives.stream().filter(lowerOrEqualTo1000()).mapToInt(Integer::intValue).sum();
    }

    private Map<Boolean, List<Integer>> partitionByBeingNegative(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).collect(partitioningBy(isNegative()));
    }

    private Predicate<Integer> isNegative() {
        return number -> number < 0;
    }

    private Predicate<Integer> lowerOrEqualTo1000() {
        return number -> number <= 1000;
    }

    private void throwNegativeException(List<Integer> negatives) {
        throw new IllegalArgumentException(generateExceptionMessage(negatives));
    }

    private String generateExceptionMessage(List<Integer> numbers) {
        String exceptionMessage = "negatives not allowed: " + numbers.stream().map(Object::toString).collect(joining(","));
        throw new IllegalArgumentException(exceptionMessage);
    }

    private List<String> splitNumbers(String numbers) {
        String separatorRegex = SEPARATOR_REGEX;
        if (isSeparatorDefined(numbers)) {
            separatorRegex = obtainSeparator(numbers);
            numbers = getOnlyNumbers(numbers);
        }
        return Arrays.asList(numbers.split(separatorRegex));
    }

    private boolean isSeparatorDefined(String numbers) {
        return numbers.startsWith("//");
    }

    private String obtainSeparator(String numbers) {
        numbers = numbers.replaceFirst("//", "");
        String[] parts = numbers.split("\n");
        return parts[0];
    }

    private String getOnlyNumbers(String numbers) {
        return numbers.substring(4);
    }
}