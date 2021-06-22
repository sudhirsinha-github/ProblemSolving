package arrays;

import java.util.Arrays;

public class ArraysMoveZeroToEnd {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 4, 2, 0, 5, 0};

        // 1. Copy to new array skip 0 and counter for 0 and append 0 for given counter
        // this will take space O(N)

        //2 . without creating new array (space efficient)

        // [1,2,0,3,4,5,0]
        int counterZero = 0;

//        while(i<=j){
//            if(a[i] == 0 && a[j] != 0)
//            {
//                int temp = a[j];
//                counterZero++;
//                a[i] = a[j];
//            }
//
//        }

        for (int k = 0; k < a.length; k++) {
            if (a[k] != 0) {
                a[counterZero++] = a[k];
            }
        }

        for (int i = counterZero; i < a.length; i++) {
            a[i] = 0;
        }

        Arrays.stream(a).forEach(r -> System.out.println(r));
    }
}
