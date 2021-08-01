package dynamicpg.eggs;

public class EggRecursion {

	// eggCount -> egg number
	// floor == floor count
	//
	static int eggDropMinTrialsNumber(int eggCount, int floor)
	{
		if(floor == 0) //floor =0
			return 0;
		if (floor == 1) //floor =1
			return 1;

		if (eggCount == 1)  // floor floor and 1 eggCount
			return floor; // floor floors

		int min = Integer.MAX_VALUE; 
		int res;


		for (int i = 1; i <= floor; i++) {
			res = Math.max(
					eggDropMinTrialsNumber(eggCount - 1, i - 1), // egg breaks here so eggCount -1, so try in lower part of i-1
						eggDropMinTrialsNumber(eggCount, floor - i)); // egg doesn't break so eggCount = eggCount,
																			// try on top floor from i+1 to f == floor - i range
			if (res < min) 
				min = res; 
		} 

		return min + 1; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		int n = 2, k = 10;
		System.out.println("Minimum number of "
						+ "trials in worst case with "
						+ n + " eggs and " + k 
						+ " floors is " + eggDropMinTrialsNumber(n, k));

		System.out.println(eggBreakingTrialsUsingDP(k, n));
	}

	private static int eggBreakingTrialsUsingDP(int floor, int egg) {
		int[][] dp = new int[floor + 1][egg + 1];

		// floor 0
		for (int i = 1; i < egg + 1; i++) {
			dp[0][i] = 0;
			dp[1][i] = 1;
		}

		//for egg =1
		for (int i = 1; i < floor + 1; i++) {
			dp[i][1] = i;
		}


		for (int i = 2; i < floor + 1; i++) {
			for (int j = 2; j < egg + 1; j++) {

				dp[i][j] = Integer.MAX_VALUE;
				for (int k = 1; k < i + 1; k++) {

					dp[i][j] = Math.min(
							dp[i][j],
							Math.max(
									dp[k - 1][j - 1], //broke
									dp[i - k][j]  //not broke
							) + 1);
				}
			}
		}


		return dp[floor][egg];
	}
	
} 
