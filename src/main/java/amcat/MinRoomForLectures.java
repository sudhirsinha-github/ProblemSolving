package amcat;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinRoomForLectures {
    public static void main(String[] args) {
        int a[][] = {{30, 75}, {0, 50}, {60, 150}};
//        Arrays.sort(a, new Comparator<int[]>() {
//                    @Override
//                    public int compare(int[] o1, int[] o2) {
//                        return (int) Integer.compare(o1[0], o2[0]);
//                    }
//                }
//        );

       /* HashMap<Integer, int[]> hashMap = new HashMap<>();
         int count =1;
        for (int i = 0; i < a.length; i++) {
            int[] temp = hashMap.get(count);

            if(temp == null || temp[1] < a[i][0]) {
                hashMap.put(count, a[i]);
            }
            else {
                count++;
                hashMap.put(count, a[i]);
                count--;
            }
        }*/

        PriorityQueue<Integer> minPriorityQ = new PriorityQueue<>();
        minPriorityQ.offer(a[0][1]);

        for (int i = 1; i < a.length; i++) {

            if (a[i][0] >= minPriorityQ.peek()) {
                minPriorityQ.poll();
                minPriorityQ.offer(a[i][1]);
            } else {
                minPriorityQ.offer(a[i][1]);
            }
        }

        System.out.println(minPriorityQ.size());

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();

    }
}
