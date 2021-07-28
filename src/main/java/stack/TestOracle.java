package stack;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TestOracle {
    private static final String SPACE = " ";

    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(new HashMap());
    //Question - a,b swap a , b without 3rd var

    /*static void swap(int a, int b) {
        a = a + b;
        b = a - b; // {(a+B) -b} //a
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        swap(a, b);
    }*/

    // name = "sudhir kumar", "Sachin Tendulkar"
    // print kumar sudhir, tendulkar Sachin ...

    //

//    static String reverseSingleName(String name){
//        String[] splitedName = name.split(SPACE);
//        String temp = splitedName[1];
//        splitedName[1] = splitedName[0];
//        splitedName[0] = temp;
//
//        return splitedName[0] + SPACE + splitedName[1];
//    }
//
//    public static void main(String[] args) {
//        ArrayList<String> listOfNames = new ArrayList<>();
//        listOfNames.add("SUDHIR KUMAR");
//        listOfNames.add("SACHIN KUMAR");
//        listOfNames.add("SACHIN TENDULKAR");
//
//        for (String name : listOfNames) {
//            System.out.println(reverseSingleName(name));
//        }
//    }


    // name ages {sudhir 30,Sachin 32,...}

    public static void main(String[] args) {
        Person thirdPerson = new Person("dhoni", 40);
        Person firstPerson = new Person("sudhir", 30);
        Person secondPerson = new Person("sachin", 34);

        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(thirdPerson);
        personArrayList.add(secondPerson);
        personArrayList.add(firstPerson);

        Collections.sort(personArrayList);
//        Collections.sort(personArrayList, new Sorter());

    }

//    static class Sorter implements Comparator<Person> {
//        @Override
//        public int compare(Person o1, Person o2) {
//            return ((o1).age - (o2).age);
//        }
//    }

    static class Person implements Comparable<Person>
    {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return this.age -o.age;
        }

        @Override
        protected void finalize() throws Throwable {
System.gc();
        }

//        @Override
//        public int compare(Object o1, Object o2) {
//            Person firstPerson = (Person) o1;
//            Person secondPerson = (Person) o2;
//
//            if (firstPerson.age > secondPerson.age) {
//                return -1;
//            }
//
//            return 1;
//        }


        // number is prime or not 2,3,5,7 (divisible by 1 or itself)

//        static boolean isPrime(int number) {
//            if (number == 1)
//                return false;
//
//            for (int i = 2; i <= number/2; i++) {
//                if (number != i && number % i == 0)
//                    return false;
//                else
//                    return true;
//            }
//
//            return false;
//        }
//
//        public static void main(String[] args) {
//            System.out.println(isPrime(11));
//        }
    }
}
