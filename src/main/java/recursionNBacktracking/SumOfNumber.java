package recursionNBacktracking;

public class SumOfNumber {

    public static void main(String[] args) {

        System.out.println(sum(253));
    }

    private static int sum(int n){
        if (n == 0)
            return 0;

        else {
            return sum(n/10) + n%10;
        }
    }
}
