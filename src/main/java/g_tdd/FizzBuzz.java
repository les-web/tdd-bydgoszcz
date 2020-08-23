package g_tdd;

public class FizzBuzz {
    public String fizzBuzz(int i) {
        if (i % 3 == 0 && i%5 == 0){
            return "FizzBuzz";
        }
        if (i % 3 ==0)
        {return "Fizz";}

        return "Buzz";
    }
}
