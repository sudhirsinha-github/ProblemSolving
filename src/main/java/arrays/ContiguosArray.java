package arrays;

public class ContiguosArray {
    public static void main(String[] args) {
        int[] a = {-10,-20,0,20,10,0,-40, 40, -30};

        int final_sum = 0;
        int temp_sum = 0;
        int start_index = 0;
        int final_start_index = 0;
        int end_index = 0;

        for (int i = 0; i < a.length; i++) {
            temp_sum = temp_sum + a[i];

            if(final_sum < temp_sum) {
                final_sum = temp_sum;
                final_start_index = start_index;
                end_index = i;
            }

            if(temp_sum<=0)
            {
                temp_sum = 0;
                start_index = i+1;
            }
        }

        System.out.println("@@@@" + final_start_index + "==== " + end_index + "--->>" + final_sum);

        }

    public static int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int n : nums) {min = Math.min(min, n);
            System.out.println(Math.min(min, n));
            sum += n;}
        return sum - nums.length * min;
    }

}
