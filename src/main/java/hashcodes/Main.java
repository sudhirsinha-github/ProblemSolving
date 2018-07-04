package hashcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Student> data = new HashMap<>();

        Student studentX = new Student();
        studentX.setName("TIM");
        data.put(1, studentX);

        Student studentY = new Student();
        studentY.setName("TIM");
        data.put(2, studentY);

        Student[] values = new Student[3];
        int i =0;
        for (Map.Entry<Integer, Student> entry1 : data.entrySet()) {
            Student value1 = entry1.getValue();
            // compare value1 and value2;
            System.out.println(value1.getName());
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
