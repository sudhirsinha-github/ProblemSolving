package atlassian.c2;



import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import java.util.*;

public class Test {
    // is visible?

    private static final int INITIAL_VALUE = 1;

    private static String findWinner(List<String> votes){

        HashMap<String, Integer> voterMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String winner = StringUtils.EMPTY;

        for (String vote:votes) {
            if(!voterMap.containsKey(vote)) {
                voterMap.put(vote, INITIAL_VALUE); // first time
                if(max == Integer.MIN_VALUE) {
                    max = INITIAL_VALUE;
                }

                winner = vote;
            }
            else {
                Integer existingCount = voterMap.get(vote);
                voterMap.put(vote, ++existingCount);

                if(existingCount >= max)
                {
                    max = existingCount;
                    winner = vote;
                }
            }
        }

        return winner;
    }


    @org.junit.Test
    public void testWinnerReturnsString()
    {
        List<String> strings = new ArrayList<String>();
        Assert.assertFalse(findWinner(strings).equalsIgnoreCase("A"));
    }

    @org.junit.Test
    public void testWinner()
    {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("C");
        list.add("D");

        Assert.assertTrue(findWinner(list).equalsIgnoreCase("C"));
    }


    @org.junit.Test
    public void testLastAsWinner()
    {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("C");
        list.add("D");
        list.add("D");

        Assert.assertTrue(findWinner(list).equalsIgnoreCase("D"));
    }

    @org.junit.Test
    public void testTheWinner()
    {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");

        Assert.assertTrue(findWinner(list).equalsIgnoreCase("B"));
    }
}

// Arrays.asList("A", "B", "C", "B", "C", "D", "C", "D")
// A -1, b-2 ,c-3,d-2

//// Arrays.asList("A", "B", "C", "B", "C", "D", "C", "D","D")
// A -1, b-2 ,c-3,d-3
// o/p c-3 || D -3