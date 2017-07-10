package prac;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by sudhirkumar on 7/5/17.
 */
public class ArrayPbm {

    public static void maina(String[] args) {

        int a[] = {1, 2, 5, 6, 3, 2};
        int temp;
        //Sort the array
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        int sum = 4;
        ArrayList<String> arrayList = new ArrayList<>();
        

        /*for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - 1; j++) {
                if (a[i] + a[j] == sum && i != j) {
                   // map.put(i, j);
                    arrayList.add(i +":" + j);
                }
            }
        }*/
        
        
        System.out.println(arrayList.toString());
    }

    class Employee{
       private int field;

        /*@Override
        public boolean equals(Object obj) {
            return (obj != null) && this.field == ((Employee) obj).field;
        }

        @Override
        public int hashCode() {
            return this.field;
        }*/

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            return field == employee.field;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(field).toHashCode();
        }
    }

    public static void main(String[] args) {
        ArrayPbm arrayPbm = new ArrayPbm();
        arrayPbm.test();
    }

    public  void test(){
        Employee employeeFirst = new Employee();
        Employee employeeSecond = new Employee();
        employeeFirst.field =10;
        employeeSecond.field =10;

        System.out.println(employeeFirst.equals(employeeSecond)+"====" +
                employeeFirst.hashCode() +"----"+
                employeeSecond.hashCode());

        Set<Employee> set = new HashSet<>();
        set.add(employeeFirst);
        set.add(employeeSecond);
        System.out.println(set.size());
    }
}
