package g_tdd_solution;
/*
Utwórz klasę LeapYearChecker.
Wykorzystując technikę TDD zaimplementuj metodę:
boolean isLeapYear(int year)
Metoda zwraca true jeśli rok jest przestępny i false w przeciwnym wypadku.
Rok jest przestępny jeśli jest spełnia przyjnajmniej jeden z poniższych warunków:
1.Jest podzielny przez 4, ale nie jest podzielny przez 100
2.Jest podzielny przez 400
 */
public class LeapYearChecker {
    public boolean isLeapYear(int year) {
        if(year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        if(year % 400 == 0) {
            return true;
        }
        return false;
    }
}