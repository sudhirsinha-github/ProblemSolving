package assesment;

public class FibanocciWithMemoization {
    static int[] memonization = new int[200];
    public static void main(String[] args) {
        System.out.println(fibanoci(120));
    }

    public static int fibanoci(int n) {
        if (n <= 0)
            return -1;

        if(memonization[n] != 0)
            return memonization[n];

        if (n == 1 || n == 2) {
            memonization[n] = 1;
            return 1;
        }


        return memonization[n] = fibanoci(n - 1) + fibanoci(n - 2);
    }
}
