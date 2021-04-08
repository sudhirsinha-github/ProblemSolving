package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSORTEDARRRAY {

    public static void main(String[] args) {

        int[] arr = new int[]{9,8,7,19,18,20,99,9999};
        sort(arr,2);
    }

    static void sort(int[] arr, int k){

        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(k);

        for (int i = 0; i <= k; i++) {
            integerPriorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k+1; i < arr.length; i++) {
            arr[index++] = integerPriorityQueue.poll();
            integerPriorityQueue.add(arr[i]);
        }

        while (!integerPriorityQueue.isEmpty()) {
            arr[index++] = integerPriorityQueue.poll();
        }

        Arrays.stream(arr).forEach(r -> System.out.println(r));
    }
}
