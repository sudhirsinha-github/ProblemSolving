package arrays;

public class matrix_check {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 3}, {4, 0, 5}, {0, 6, 7}};
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                res[i][j] = -111;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i][j] == 0)
                {
                    for (int k = 0; k < a.length; k++) {
                        res[i][k] =0;
                        res[k][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(res[i][j] == -111)
                    res[i][j] = a[i][j];
            }
        }

        System.out.println("--- " + res.toString());
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(" "+ res[i][j]);
            }
            System.out.println();
        }

    }

}
