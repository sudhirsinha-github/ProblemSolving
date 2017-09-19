package java8;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.collect.ImmutableMap.of;

public class t6 {


   /* public static void main(String[] args) */ static {

        try{
            System.out.println("sss");
            //return;
        }
        catch (Exception ex){
            throw new RuntimeException("ee");
        }
        finally {
            System.out.println("Finally");
        }
    /*    Thread th = new Thread(()->
        {

            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(th.currentThread().getName());

        th.start();
 */
/*
        ArrayList<String> al = new ArrayList<>();
        al.add("eeee");
        al.add("fff");
        al.add("gggg");
        al.add("hhhh");

        System.out.println(al.toString());
        System.out.println(al.stream().count());


      List<String> ss =  al.stream()
              .filter(data -> data.length() > 3)
              .collect(Collectors.toList());

      ss.removeIf(e -> e.equals("gggg"));
      ss.stream().forEach(System.out::print);
        Collections.sort(ss, Comparator.reverseOrder());

      //  ArrayList<String> ddd = Collections.synchronizedCollection(al);

        StringJoiner joiner = new StringJoiner("**");
        joiner.add("\nss222s");
        joiner.add("ssswww");
        joiner.add("sssee");
        joiner.add("sddss");

        Employee employee = new Employee();
        Employee employeer = employee;

        System.out.println(joiner.merge(joiner));
        System.out.println(employee.hashCode());
        System.out.println(employee.equals(employeer));*/
    }

   /* protected static String getSearchParameters(final String routingContext) {
        String params = "<customer>";

        final String firstName = routingContext.request().getParam("Name1");
        if (null != firstName && !firstName.isEmpty())
            params = params + "<Name1>" + firstName.trim() + "</Name1>";
        final String lastName = routingContext.request().getParam("Name3");
        if (null != lastName && !lastName.isEmpty())
            params = params + "<Name3>" + lastName.trim() + "</Name3>";
        final String clubCardNumber = routingContext.request().getParam("cardAccountNumber");
        if (null != clubCardNumber && !clubCardNumber.isEmpty())
            params = params + "<cardAccountNumber>" + Long.parseLong(clubCardNumber.trim()) + "</cardAccountNumber>";
        final String email = routingContext.request().getParam("email");
        if (null != email && !email.isEmpty())
            params = params + "<Email>" + email.trim() + "</Email>";
        final String postcode = routingContext.request().getParam("postcode");
        if (null != postcode && !postcode.isEmpty())
            params = params + "<postcode>" + postcode.trim() + "</postcode>";
        // prasanth.mvk@gmail.com
        params = params + "</customer>";
        return params;
    }
*/

    public static void main(String[] args) {
        String input = "test&123<>@'";
        String str = StringEscapeUtils.escapeXml10(input);
        System.out.println(str);
    }
}
