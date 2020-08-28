package g_tdd_solution;
/*
Utwórz klasę MarsRoverNavigator, która w konstruktorze będzie przyjmowad obiekt typu MarsRover.
Wykorzystując technikę TDD zaimplementuj metodę:
void navigate(String directions)
1.Metoda przyjmuje kierunki, w których ma poruszad się łazik marsjaoski:
 F – forward, B – backward, L – left, R – rigth
 Kierunki podane są w formie jednego łaocucha znaków (np. ”F,F,L,R,B,B,B”).
 Metoda powinna na podstawie podanych w ten sposób kierunków sterowad łazikiem (MarsRover).
2.Dodaj możliwośd podawania liczby ruchów w danym kierunku (np. ”2|F,L,R,3|B” zamiast ”F,F,L,R,B,B,B”).
3.Jeśli zostanie podany nieznany kierunek (inny niż F,B,L lub R)
metoda powinna rzucid wyjątek typu IllegalArgumentException z informacją ”unrecognized direction”.
 */
public class MarsRoverNavigator {

    private final MarsRover marsRover;

    public static final int DEFAULT_NUMBER_OF_MOVES = 1;

    public MarsRoverNavigator(MarsRover marsRover) {
        this.marsRover = marsRover;
    }

    public void navigate(String directionsString) {
        for (String direction : directionsString.split(",")) {
            int numberOfMoves = DEFAULT_NUMBER_OF_MOVES;

            if(directionWithNumberOfMoves(direction)) {
                numberOfMoves = getNumberOfMoves(direction);
                direction = getDirection(direction);
            }

            for(int i = 0; i < numberOfMoves; i++) {
                switch (direction) {
                    case "F":
                        marsRover.goForward();
                        break;
                    case "B":
                        marsRover.goBackward();
                        break;
                    case "L":
                        marsRover.goLeft();
                        break;
                    case "R":
                        marsRover.goRight();
                        break;
                    default:
                        throw new IllegalArgumentException("unrecognized direction");
                }
            }
        }
    }

    private boolean directionWithNumberOfMoves(String direction) {
        return direction.contains("|");
    }

    private int getNumberOfMoves(String directionWithNumberOfMoves) {
        String[] parts = directionWithNumberOfMoves.split("\\|");
        return Integer.parseInt(parts[0]);
    }

    private String getDirection(String directionWithNumberOfMoves) {
        String[] parts = directionWithNumberOfMoves.split("\\|");
        return parts[1];
    }
}

interface MarsRover {
    void goForward();
    void goBackward();
    void goLeft();
    void goRight();
}

