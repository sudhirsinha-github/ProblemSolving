package atlassian.c1;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    Map<String, Element> listOfRLClient = new HashMap<>();
    private static final int INITIAL_VALUE = 20;
    private static final int DELTA_TIME_DURATION = 1*1000;
    // add/update the details
     void verifyAndUpdateClient(String client) {

        // if client key is not present

        // Node element
        Element element = new Element();
        element.timeStamp = System.currentTimeMillis();
        listOfRLClient.putIfAbsent(client, element); // tS - ttl

        // else we should get and update the counter

        Element value = listOfRLClient.get(client);

        // we have to compare timestamp
        long currentTime = System.currentTimeMillis();
        if (value.counter > 0 && currentTime - value.timeStamp < DELTA_TIME_DURATION) {
            System.out.println(" Current limit was - " + value.counter + " and time stamp was " + value.timeStamp);
            value.counter--;
            listOfRLClient.put(client, value);
        } else {
            // throw new RuntimeException("Exceeded limit for the time");
            System.out.println("Exceeded limit for the time");
//            System.currentTimeMillis()

            if (currentTime - value.timeStamp > DELTA_TIME_DURATION) {
                Element nextElement = new Element();
                nextElement.counter = INITIAL_VALUE;
                nextElement.timeStamp = System.currentTimeMillis();
                listOfRLClient.put(client, nextElement);
            }
        }
    }

     class Element{
        long timeStamp;
        int counter = INITIAL_VALUE;
    }
}
