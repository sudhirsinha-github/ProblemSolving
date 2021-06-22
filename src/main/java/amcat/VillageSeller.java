package amcat;

public class VillageSeller {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 9, 8,27};
       // System.out.println(maxProfit(a));
        int high_sum = 0;
        for (int i =0;i< a.length -1; i++) {
            int max_sum = a[i];
            int curr_sum = a[i];

            for (int x = 0; x < a.length - 1; x++) {
                if (a[x + 1] % curr_sum == 0) {
                    max_sum += a[x + 1];
                    curr_sum = a[x + 1];
                }
            }

            if(max_sum>high_sum)
            {
                high_sum = max_sum;
            }
        }

        System.out.println(high_sum);
    }

    /*private static int maxProfit(int[] villageIndexArrayInt) {
        *//*List<Integer> sortedVilList =
                Arrays.stream(villageIndexArrayInt).boxed()
                .collect(Collectors.toList());*//*
        int maxProfit = villageIndexArrayInt[0];
        int currentVillage = villageIndexArrayInt[0];
        for (int i = 0; i < villageIndexArrayInt.length - 1; i++) {
            if (villageIndexArrayInt[i + 1] % currentVillage == 0) {
                maxProfit = maxProfit + villageIndexArrayInt[i + 1];
                currentVillage = villageIndexArrayInt[i + 1];
            }
        }
        return maxProfit;
    }*/
}
