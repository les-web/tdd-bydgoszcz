package g_tdd_solution;
/*
Utwórz klasę Stack (stos – LIFO).
Wykorzystując technikę TDD zaimplementuj metody:
void push(Object o) – dodawanie elementu do kolejki
Object peek() – zwracanie elementu ze stosu (bez usuwania go)
Object pop() – zwracanie i usuwanie elementu ze stosu
Stos powinien byd oparty o tablicę. Ma mied określoną maksymalną wielkośd (parameter konstruktora).
Jeśli próbujemy pobrad element a stos jest pusty -> wyjątek EmptyStackException.
Jeśli stos jest pełny to przy próbie dodania kolejnego elementu -> wyjątek FullStackException.

 */
public class Stack {

    private final Object[] elements;
    private int topOfTheStackIndex = -1;

    public Stack(int maxSize) {
        elements = new Object[maxSize];
    }

    public void push(Object o) {
        if(stackIsFull()) {
            throw new FullStackException();
        }
        elements[++topOfTheStackIndex] = o;
    }

    public Object pop() {
        if (stackIsEmpty()) {
            throw new EmptyStackException();
        }
        Object valueFromTheTop = elements[topOfTheStackIndex];
        topOfTheStackIndex--;
        return valueFromTheTop;
    }

    public Object peek() {
        if(stackIsEmpty()) {
            throw new EmptyStackException();
        }
        return elements[topOfTheStackIndex];
    }

    private boolean stackIsFull() {
        return topOfTheStackIndex == elements.length - 1;
    }

    private boolean stackIsEmpty() {
        return topOfTheStackIndex == -1;
    }
}

class EmptyStackException extends RuntimeException {}

class FullStackException extends RuntimeException {}
