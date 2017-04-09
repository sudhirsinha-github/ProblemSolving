import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.apache.commons.lang3.*;
/**
 * Created by sudhirkumar on 2/27/17.
 */
public class MyClass implements DefaultInterface {

    public void myCall(){

        System.out.print("TEST...");
    }

    /*@Override
    public void run() {
        System.out.print("calling...");
    }*/


    public static void main(String[] args)
    {
       /* MyClass myClass = new MyClass();
        myClass.myCall();
        myClass.run();*/

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
                //.collect(Collectors.toList());

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
/*
        System.out.println("(*****");

        String characters = "ZXCVBNMASDFGHJKLPOIUYTREWQzxcvbnmasdfghjklqwertyuiop1234567890!@#*&";
        String pwd = RandomStringUtils.random( 15, characters );
        System.out.println( pwd );*/
    }
}


