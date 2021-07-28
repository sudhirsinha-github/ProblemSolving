package stropn;// Java Program to reverse a String
// without using inbuilt String function
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseWords {

	// Method to reverse words of a String
	static String reverseWords(String str)
	{

		// Specifying the pattern to be searched
//		Pattern pattern = Pattern.compile("\\s");

		// splitting String str with a pattern
		// (i.e )splitting the string whenever their
		// is whitespace and store in temp array.
		String[] temp = str.split("\\s");
		String result = "";

		// Iterate over the temp array and store
		// the string in reverse order.
		Stack<String> stringStack = new Stack<>();
		for (int i = 0; i < temp.length; i++) {
//			if (i == temp.length - 1)
//				result = temp[i] + result;
//			else
//				result = " " + temp[i] + result;
			stringStack.add(temp[i]);

		}

		while (!stringStack.isEmpty()) {
			System.out.print(stringStack.pop());
			System.out.println(" ");
		}

		return result;
	}

	static String[] reverseWord(String[] arr, int low, int high) {
		if (low > high)
			return arr;

		swap(arr, low, high);

		reverseWord(arr, low + 1, high - 1);

		return arr;
	}

	private static String[] swap(String[] arr, int low, int high) {
		String temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
		return arr;
	}

	// Driver methods to test above method
	public static void main(String[] args)
	{
		String s1 = "Welcome to geeksforgeeks";
		String[] split = s1.split("\\s");
		String[] x = reverseWord(split, 0, split.length - 1);
		Arrays.stream(x).map( r -> r + "").collect(Collectors.toList());

		String s2 = "I love Java Programming";
		//System.out.println(reverseWords(s2));
	}
}
