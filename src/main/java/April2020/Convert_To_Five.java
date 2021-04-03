package April2020;

// { Driver Code Starts
import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static int $;

    public static void main(String args[]) {
      //  func(234521, 0);

        System.out.println(isPresent(new int[]{1, 2, 5, 4, 3},3,0));
    }

//    static void func(int n, int sum)
//    {
//        if(n ==0) {
//            System.out.println(sum);
//            return;
//        }
//        func(n/10, sum + n%10);
//    }


    static boolean isPresent(int[] n, int x, int idx) {
        if (idx > n.length)
            return false;


        if (n[idx] == x)
            return true;

        return isPresent(n, x, idx + 1);
    }
}

