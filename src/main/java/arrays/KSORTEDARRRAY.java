package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSORTEDARRRAY {

    public static void main(String[] args) {

        int[] arr = new int[]{9,8,7,19,18,20,99,9999};
        sort(arr,2);
    }

    static void sort(int[] arr, int k){

        PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>(k);

        for (int i = 0; i <= k; i++) {
            minPriorityQueue.add(arr[i]);
        }

        int index = 0;
        for (int i = k+1; i < arr.length; i++) {
            arr[index++] = minPriorityQueue.poll();
            minPriorityQueue.add(arr[i]);
        }

        while (!minPriorityQueue.isEmpty()) {
            arr[index++] = minPriorityQueue.poll();
        }

        Arrays.stream(arr).forEach(r -> System.out.println(r));
    }
}
