package designpaterns;

class Factorial {
    public int[] arr = new int[Integer.MAX_VALUE];

    static int factorial( int n ) {
        
        if (n != 0)
            return n * factorial(n-1); // recursive call
        else
            return 1;
    }

    public static void main(String[] args) {
        int number = 99999999, result;
        result = factorial(number);
        System.out.println(number + " factorial = " + result);
    }
}