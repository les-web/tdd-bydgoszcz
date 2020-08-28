package g_tdd_solution;
/*
Utwórz klasę PasswordChecker. Klasa powinna zawierad metodę:
boolean checkPassword(String password)
Metoda sprawdza czy hasło podane jeko argument spełnia odpowiednie warunki:
1.Hasło musi mied przynajmniej 8 znaków.
2.Hasło musi mied przynajmniej 1 wielką literę.
3.Hasło musi mied przynajmniej 1 cyfrę.
4.Hasło musi mied przynajmniej jeden znak spośród: !@#$%&*
Użyj parametryzowanych testów aby sprawdzid działanie metody.
 */
public class PasswordChecker {

    public static final int MINIMUM_PASS_LENGTH = 8;

    boolean checkPassword(String password) {
        return haveAtLeast8Characters(password)
                && hasAtLeastOneUppercaseLetter(password)
                && hasAtLeastOneDigit(password)
                && hasAtLeastOneSpecialCharacter(password);
    }

    private boolean haveAtLeast8Characters(String password) {
        return password.length() >= MINIMUM_PASS_LENGTH;
    }

    private boolean hasAtLeastOneUppercaseLetter(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasAtLeastOneDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean hasAtLeastOneSpecialCharacter(String password) {
        return password.matches(".*[!@#$%&*]");
    }
}
