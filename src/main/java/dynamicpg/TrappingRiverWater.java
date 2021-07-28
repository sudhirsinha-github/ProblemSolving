package dynamicpg;

import java.util.*;
import java.io.*;

// Java implementation of the approach
class TrappingRiverWater {
	// ||
	// ||  ||
	// ||  ||
	//  3 0 2 ->>2
	// Function to return the maximum
	// water that can be stored
	public static int maxWater(int[] height)
	{
		// Stores the indices/position of the bars
		Stack<Integer> stack = new Stack<>();

		// size of the array
		int n = height.length;

		// Stores the final result
		int ans = 0;

		// Loop through the each bar
		for (int i = 0; i < n; i++) {

			// Remove bars from the stack
			// until the condition holds
			while ((!stack.isEmpty())
				&& (height[stack.peek()] < height[i])) {

				// store the height of the top
				// and pop it.
				int pop_height = height[stack.peek()];
				stack.pop();

				// If the stack does not have any
				// bars or the the popped bar
				// has no left boundary
				if (stack.isEmpty())
					break;

				// Get the distance between the
				// left and right boundary of
				// popped bar
				int distance = i - stack.peek() - 1;

				// Calculate the min. height
				int min_height
					= Math.min(height[stack.peek()],
							height[i])
					- pop_height;

				ans += distance * min_height;
			}

			// If the stack is either empty or
			// height of the current bar is less than
			// or equal to the top bar of stack
			stack.push(i);
		}

		return ans;
	}

	static int findWater(int[] arr, int n)
	{
		// left[i] contains height of tallest bar to the
		// left of i'th bar including itself
		int left[] = new int[n];

		// Right [i] contains height of tallest bar to
		// the right of ith bar including itself
		int right[] = new int[n];

		// Initialize result
		int water = 0;

		// Fill left array
		left[0] = arr[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], arr[i]);

		// Fill right array
		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], arr[i]);

		// Calculate the accumulated water element by element
		// consider the amount of water on i'th bar, the
		// amount of water accumulated on this particular
		// bar will be equal to min(left[i], right[i]) - arr[i] .
		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - arr[i];

		return water;
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr[] = { 3,0,2 };
		System.out.print(findWater(arr, arr.length));
	}
}
