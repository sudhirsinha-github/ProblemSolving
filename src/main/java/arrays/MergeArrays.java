package arrays;
// Java program to merge two sorted arrays
import java.util.*;

class MergeArrays {

	// Function to merge arrays
	static void mergeArrays(int a[], int b[], int n, int m) {
		Map<Integer, Boolean> data = new TreeMap<>();

		// Inserting values to a map.
		for (int i = 0; i < n; i++) {
			data.put(a[i], true);
		}
		for (int i = 0; i < m; i++) {
			data.put(b[i], true);
		}

		data.keySet().stream().forEach(r -> System.out.println(r));
	}

	// Driver Code
	public static void main(String[] args) {
		int a[] = {1, 3, 5,8,11,19,21,7},
				b[] = {2, 4, 6, 8};
		int size = a.length;
		int size1 = b.length;

		// Function call
		mergeArrays(a, b, size, size1);
	}
}