package arrays;// Java program to find the largest number that can be
// formed from given sum of digits and number of digits

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FindLargestNumber
{
	// Function to print the largest possible number with digit sum 's'
	// and 'm' number of digits
	static long findLargest(int m, int s)
	{
		// If sum of digits is 0, then a number is possible
		// only if number of digits is 1
		if (s == 0)
		{
			System.out.print(m == 1 ? "Largest number is 0" : "Not possible");
			
			return -1L;
		}


		// Create an array to store digits of result
		int[] res = new int[m];

		// Fill from most significant digit to least
		// significant digit
		for (int i=0; i<m; i++)
		{
			// Fill 9 first to make the number largest
			if (s >= 9)
			{
				res[i] = 9;
				s -= 9;
			}

			// If remaining sum becomes less than 9, then
			// fill the remaining sum
			else
			{
				res[i] = s;
				s = 0;
			}
		}

		System.out.print("Largest number is ");
		long d = 0l;
		for (int i=0; i<m; i++)
		{
			d += (res[i] * Math.pow(10, (m-1-i)));
			//System.out.print(res[i]);
		}

		return d;
	}
	
	// driver program
	public static void main (String[] args)
	{
		int s = 15, m = 2;
		System.out.println(findLargest(m, s));
	}
}
