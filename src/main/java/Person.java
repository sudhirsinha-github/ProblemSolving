import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudhirkumar on 4/12/17.
 */
public class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name +" --- " + this.id;
    }
}

class PersonTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person(11, "Sudhir1"));
        personList.add(new Person(12, "Sudhir4"));
        personList.add(new Person(13, "Sudhir3"));
        personList.add(new Person(14, "Sudhir2"));

        for (int i = 0; i < personList.size(); i++) {
            final Person person = personList.get(i);
            System.out.println(person);
        }
    }


}
