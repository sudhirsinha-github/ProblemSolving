package recursion;

public class PrintSubString {
//    public static void main(String[] args) {
//        String s = "abc";
//        findsubsequences(s, ""); // Calling a function
//        int[] a = {1, 5, 7,10,1,12};
//       // System.out.println(countOfSubset(12, a, a.length));
//    }
//
//    private static void findsubsequences(String s,
//                                         String ans) {
//        if (s.length() == 0) {
//            System.out.println(ans);
//            return;
//        }
//
//        // We add adding 1st character in string
//        findsubsequences(s.substring(1), ans +
//                s.charAt(0));
//
//        // Not adding first character of the string
//        // because the concept of subsequence either
//        // character will present or not
//        findsubsequences(s.substring(1), ans);
//    }
//
//    private static int countOfSubset(int sum, int a[], int len) {
//        if (len == 0)
//            return sum == 0 ? 1 : 0;
//
//
//        return countOfSubset(sum - a[len-1], a, len - 1)
//                + countOfSubset(sum, a, len - 1);
//
//    }

//    public static void main(String[] args) {
//        def get_weight(char):                     ### gets ascii value of character then
//        return ord(char)-ord('a')+1             ### subtract ascii of 'a' to get weight
//
//        def get_max_steps(weights,length,median):
//        max_steps=-1
//        max_indx=-1
//        total_steps=0
//        for indx in range(length):              ###  for each word
//        tmp_steps=abs(weights[indx]-median)   ### calculate steps req to reach
//        total_steps+=tmp_steps                ### median weight
//        if max_steps<tmp_steps:
//        max_steps=tmp_steps                 ### store the max steps required in max_steps
//                max_indx=indx                       ### and index for which its required in max_indx
//        return total_steps-max_steps,max_indx   ### exclude the max_steps from total steps for the invalid string
//
//        def function(words,length):
//        weights=[0 for i in range(length)]      ### array to store weights of each word
//        for indx in range(length):              ### for each word
//        weight=0                              ###
//        for char in words[indx]:              ### calculate weight of each word
//        weight+=get_weight(char)            ###
//        weights[indx]=weight                  ### store it in the array
//                sorted_weights=sorted(weights)          ### sort the array
//                median=sorted_weights[length/2]         ### get median do Integer divison
//        total_steps,max_indx=get_max_steps(weights,length,median)  ### calculate the total steps required to
//                                          ### reach median of weight excluding the steps for invalid string at max_ind
//        if length%2==0:                         ### if array's length is even
//        median=sorted_weights[length/2 -1]    ### get second median and do similar step as above and do Integer division here
//                ntotal_steps,nmax_indx=get_max_steps(weights,length,median)
//        if ntotal_steps<total_steps:          ### if the total steps using second median is less
//        max_indx=nmax_indx                  ### then the string by this median is appropriate choice for invalid string
//
//        return words[max_indx]
//    }
}
