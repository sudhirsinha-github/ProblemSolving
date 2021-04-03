package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WaveForm {
    public static void main(String[] args) {

        int[]a ={2,4,7,8,9,10};
        int n = a.length;

        for (int i = 0; i < n-1; i=i+2) {
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }

        Arrays.stream(a).forEach(value -> System.out.print(value +" "));
    }
}
