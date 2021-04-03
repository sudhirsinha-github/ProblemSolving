package dynamicpg;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IncreasingSequence {
    public static void main(String[] args) {
        int a[] = {3,10,2,1,12,24}; // O/p - 3,10,20
        printSequence(a);
    }

    private static void printSequence(int[] a) {
        int length = a.length;
        int temp[] = IntStream.range(0, length).map(i -> 1).toArray();
        int max = 1,i;

        for (i=1;i<length;i++)
        {
            for (int k = 0; k < i; k++) {
                if ( a[i] > a[k] && temp[i] < temp[k]+1)
                    temp[i] = temp[k] + 1;
            }
        }


        System.out.println(Arrays.stream(temp).max().getAsInt());
    }
}
