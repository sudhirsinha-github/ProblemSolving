package dynamicpg;

import cucumber.api.java.it.Ma;

public class LongestSubsetStringMatch {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(lcsRecursion(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
        System.out.println(lcsWithDP(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }


    //O(2^n)
    private static int lcsRecursion(char[] a, char[] b, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (a[m - 1] == b[n - 1]) //last char mathced
        {
            return 1 + lcsRecursion(a, b, m - 1, n - 1);
        } else {
            return Math.max(lcsRecursion(a, b, m - 1, n), lcsRecursion(a, b, m, n - 1));
        }
    }

    private static int lcsWithDP(char[] a, char[] b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a[i-1] == b[j-1]) { // this is to compare string last char so i-1 and @m -> i = m-1
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
