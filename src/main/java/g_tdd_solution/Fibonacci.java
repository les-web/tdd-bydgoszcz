package g_tdd_solution;
/*Utwórz klasę Fibonacci.
        Wykorzystując technikę TDD zaimplementuj metodę:
        int fibonacciNumber(int i)
        Metoda powinna zwracad i-tą liczbę z ciągu fibonacciego.
*/
public class Fibonacci {
    public int fibonacciNumber(int i) {
        if(i == 0) {
            return 0;
        }
        if(i == 1 || i == 2) {
            return 1;
        }
        return fibonacciNumber(i-1) + fibonacciNumber(i-2);
    }
}