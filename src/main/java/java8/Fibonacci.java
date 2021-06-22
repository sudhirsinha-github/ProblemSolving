package java8;

/**
 * Created by sudhirkumar on 6/28/17.
 */
public class Fibonacci {

    /**
     * Method Purpose to sum
     * @param number
     * @return
     */
     static final public int  fibonacciSum(int number){
        if(number<= 1)
            return number;
        else
            return fibonacciSum(number-1) + fibonacciSum(number-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacciSum(20));
    }
}
