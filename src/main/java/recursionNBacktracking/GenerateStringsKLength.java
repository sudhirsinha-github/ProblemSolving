package recursionNBacktracking;

public class GenerateStringsKLength {


    static void binary(char[] A, String prefix, int n, int k) {
        if  (k==0) {
            System.out.println(prefix);

            return;
        }

        for (int j = 0; j < n; j++) {
            binary(A, prefix + A[j], n, k -1);
        }

    }

    public static void main(String[] args) {
        int k = 3;
        String a = "abc";

        binary(a.toCharArray(), "", a.length(), k);
    }
}




