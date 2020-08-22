package b_exceptions;

public class ExceptionsCalculator {

    public Integer divide(Integer a, Integer b) {
        if (b == null || a == null){
            throw new IllegalArgumentException("null argument");
        }
        if (b == 0) {
            throw new IllegalArgumentException("do not divide by 0");
        }
        return a/b;
    }
}
