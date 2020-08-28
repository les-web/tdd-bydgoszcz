package g_tdd_solution;
/*
Utwórz klasę BracketsChecker. Klasa powinna zawierad metodę:
boolean check(String s)
Metoda przyjmuje łaocuchy znaków złożonych z otwierających nawiasów kwadratowych ”*”
i zamykających nawiasów kwadratowych ”+”.
Powinna zwracad true jeśli przekazany łaocuch znaków zawiera pary otwierających i zamykających nawiasów
 w odpowiedniej kolejności lub false w przeciwnym wypadku.
Np.: ”*” – false, ”*+” – true, ”*+*+” – true, ”**++” – true, ”+*” – false, ”+*+*” – false, ”*+*++” – false
Wskazówka: do rozwiązania może byd potrzebna pewna bardzo popularna struktura danych.
Użyj parametryzowanych testów aby sprawdzid działanie metody.
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BracketsChecker {

    public static final char OPENING_SQUARE_BRACKET = '[';

    boolean check(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char character : s.toCharArray()) {
            if (isOpeningSquareBracket(character)) {
                stack.push(character);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character characterFromStack = stack.pop();
                if (!isOpeningSquareBracket(characterFromStack)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isOpeningSquareBracket(char character) {
        return character == OPENING_SQUARE_BRACKET;
    }
}
