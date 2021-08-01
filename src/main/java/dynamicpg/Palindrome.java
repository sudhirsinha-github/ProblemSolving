package dynamicpg;// Java program to find palindromic substrings of a string

import java.util.HashSet;
import java.util.Set;

public class Palindrome {
	static int countPS(char str[], int n)
	{
		boolean dp[][] = new boolean[n][n];
		Set<String> set = new HashSet<>();

		int count = 0;
		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j= gap; j < n; i++,j++) {
				if (gap == 0) {
					dp[i][j] = true;
				} else if (gap == 1) {
					if (str[i] == str[j]) {
						dp[i][j] = true;
					}
				} else {
					if (str[i] == str[j] && dp[i + 1][j - 1] == true)
					// dp[i+1][j-1] this is to fetch diagonal value of current column
					{
						dp[i][j] = true;
//						set.add(String.valueOf(str).substring(i, j+1));
					}
				}

				if(dp[i][j]){
					set.add(String.valueOf(str).substring(i, j+1));
					count++;
				}
			}
		}

		for (String s:set) {
			System.out.println(s);
		}

		return count;
	}

	// Driver code
	public static void main(String[] args)
	{
		String str = "abaaa";
		//System.out.println(lengthOfPalindromeSequence(str.toCharArray(), str.length()));
		System.out.println(countPS(str.toCharArray(), str.length()));
	}



	// c(mn) = c(m+1,n) + c(m,n+1) +1 {c(m) == c(n)}
	// else c(m+1,n) + c(m,n+1) - c(m+1, n-1)
	private static int lengthOfPalindromeSequence(char[] data, int n){
		int[][] dp = new int[n][n];

		//gap =0 to n
		for (int gap = 0; gap<n; gap++)
		{
			for (int i = 0, j= gap; j < n; i++,j++) {
				if(gap == 0)
				{
					dp[i][j] = 1;
				}
				else if(gap == 1){
					dp[i][j] = (data[i] == data[j])? 3:2;
				}
				else {
					if (data[i] == data[j]) {
						dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
					} else {
						dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i+1][j-1];
					}
				}
			}

		}

		return dp[0][n-1];
	}

}
