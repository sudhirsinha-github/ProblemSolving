package hashcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String s1 = "abZ";
        String s2 = "aay";

        System.out.println(s1.hashCode() + " : " + s2.hashCode());
        System.out.println(s1.equals(s2));

        Employee e1 = new Employee("Sudhir", "sudhir@tesco.com", "SUD11");

        Employee e2 = new Employee("Sudhir", "sudhir@tesco.com", "SUD11");


        System.out.println(e1.equals(e2));

        Map<Employee, String> map = new HashMap<Employee, String>();
        map.put(e1, "CSE");
        map.put(e2, "IT");

        System.out.println("Going to for loop");
        for(Employee employee : map.keySet())
        {
            System.out.println(map.get(employee).toString());
        }

        HashMap<Integer, Student> data = new HashMap<>();


        Student studentX = new Student();
        studentX.setName("TIM");
        data.put(1, studentX);

        Student studentY = new Student();
        studentY.setName("TIM");
        data.put(2, studentY);

        System.out.println("studentX.equals(studentY) " + studentX.equals(studentY));

        Student[] values = new Student[3];
        int i =0;
        for (Map.Entry<Integer, Student> entry1 : data.entrySet()) {
            Student value1 = entry1.getValue();
            // compare value1 and value2;
            // System.out.println(value1.getName());
//                System.out.println(value1.equals(value2));

            values[i] = value1;
            i++;
        }

        System.out.println(values[0].equals(values[1]));


        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(studentX);
        studentArrayList.add(studentY);
        System.out.println(studentArrayList.get(0).equals(studentArrayList.get(1)));
    }

}
