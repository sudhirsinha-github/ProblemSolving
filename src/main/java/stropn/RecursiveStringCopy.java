package stropn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RecursiveStringCopy {
    public static void main(String[] args) {
        String s1 ="test";
        String s2 ="golmal";
        String ss = "sdhi adesc Peeww";
//        copystrings(s1.toCharArray(), s2.toCharArray(), 0);

        String[] sss = ss.split(" ");
        for (String x:sss) {
            System.out.println(x.toCharArray()[0]);
        }
        // new RecursiveStringCopy().rearrangeString("aaabc");
    }

    private static void copystrings(char[] s1, char[] s2, int i) {

        if(i == s1.length)
            return;
        s2[i] = s1[i];

        copystrings(s1, s2, i+1);
    }

    //Input : %welcome' to @geeksforgeek<s
    // Given a string with repeated characters, the task is to rearrange characters i
    // n a string so that no two adjacent characters are same
    // Input: aaabc
    // Output: abaca

    //Input : Hello!!!, he said ---and went.
    // Output : Hello he said and went
    // !"#$%&'()*+,-./:;?@[\]^_`{|}~
//    private static void rearrangeString() {
//        char[] ch = "aaabc".toCharArray();
//        PriorityQueue<Character> priorityQueue = new PriorityQueue<>();
//        for (char c : ch) {
//            priorityQueue.add(c);
//        }
//    }
    class KeyComparator implements Comparator<Key> {

        // Overriding compare()method of Comparator
        public int compare(Key k1, Key k2)
        {
            if (k1.freq < k2.freq)
                return 1;
            else if (k1.freq > k2.freq)
                return -1;
            return 0;
        }
    }

    class Key {
        int freq; // store frequency of character
        char ch;
        Key(int val, char c)
        {
            freq = val;
            ch = c;
        }
    }

    private void rearrangeString(String str)
    {
        int n = str.length();

        // Store frequencies of all characters in string
        int[] count = new int[26];

        for (int i = 0; i < n; i++)
            count[str.charAt(i) - 'a']++;

        // Insert all characters with their frequencies
        // into a priority_queue
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int val = ch - 'a';
            if (count[val] > 0)
                pq.add(new Key(count[val], ch));
        }

        // 'str' that will store resultant value
        str = "" ;

        // work as the previous visited element
        // initial previous element be. ( '#' and
        // it's frequency '-1' )
        Key prev = new Key(-1, '#');

        // traverse queue
        while (pq.size() != 0) {

            // pop top element from queue and add it
            // to string.
            Key k = pq.peek();
            pq.poll();
            str = str + k.ch;

            // If frequency of previous character is less
            // than zero that means it is useless, we
            // need not to push it
            if (prev.freq > 0)
                pq.add(prev);

            // make current character as the previous 'char'
            // decrease frequency by 'one'
            (k.freq)--;
            prev = k;
        }

        // If length of the resultant string and original
        // string is not same then string is not valid
        if (n != str.length())
            System.out.println(" Not valid String ");
        else
            System.out.println(str);
    }


}
