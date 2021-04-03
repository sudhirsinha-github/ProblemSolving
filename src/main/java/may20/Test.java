package may20;

@FunctionalInterface
public interface Test {
    default void run() {
        System.out.println("test");
    }

    default void t() {
    }

    void test();

    boolean equals(Object obj);

    int hashCode();

}

@FunctionalInterface
interface Square
{
    int calculate(int x);
}


class yy{
    public static void main1(String[] args) {
        Square square = x -> x*x;

        System.out.println(square.calculate(2));

        Test t = () -> System.out.println("tt");;

        t.hashCode();
    }

    public static void main2(String[] args) {
        int max_count = 0;
        int count = 0;

        int[] a = new int[]{0,1,1,0,1,1,1,0,1,1,0,1,1,0,1};

        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0)
                count =0;
            else {
                count++;
                max_count = Math.max(count, max_count);
            }
        }

        System.out.println(max_count);
    }

    public static void main3(String[] args) {
        int max_count = 0;
        int count = 1;

        int[] a = new int[]{7,10, 13, 14}; //max length of odd-even or even-odd-even .. pairs

        int prev= 0;
        for (int i = 1; i < a.length; i++) {
            boolean prev_div = a[prev]%2 == 0;
            prev = i;

            boolean next = a[i]%2 == 0;

            if(prev_div == next) {
                count = 1;
            }
            else {
                count++;
                max_count = Math.max(count, max_count);
            }
        }

        System.out.println(max_count);
    }

    public static void main4(String[] args) {
        int[] a = new int[]{1,8,30,-5,20,7};
        int max_sum = a[0]+a[1]+a[2];
        int sum = max_sum;
        for (int i = 3; i < a.length; i++) {
            sum = (sum - a[i-3]) +a[i];
            max_sum = Math.max(max_sum, sum);
        }

        System.out.println(max_sum);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int required = 15;
        int sum = a[0];
        int start = 0, end = 0;

        for (int i = 1; i < a.length; i++) {
            if (sum < required) {
                sum += a[i];
                end++;
            } else {
                sum -= a[start];
                start++;
                // sum += a[i];
            }

            if(sum == required)
                break;


        }

        for (int i = start; i < end+1; i++) {
            System.out.println(a[i]);
        }

    }
}


