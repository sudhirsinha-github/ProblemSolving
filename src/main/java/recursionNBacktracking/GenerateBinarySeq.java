package recursionNBacktracking;

public class GenerateBinarySeq {


    static void binary(int[] A, int i, int n) {
        if (i == n) {
            printTheArray(A, n);
            return;
        }


        A[i] = 0;
        binary(A, i+1, n);

        A[i] = 1;
        binary(A, i+1, n);
    }

    static void printTheArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int v = 3;
        int[] a = new int[v];

        binary(a,0, v);
    }
}
