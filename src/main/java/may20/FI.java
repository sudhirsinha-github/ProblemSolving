package may20;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TrainingCourses {
    private final String title;
    private final BigDecimal price;

    public TrainingCourses(String title, BigDecimal price) {
        super();
        this.title = title;
        this.price = price;
    }

    public String title() {
        return title;
    }

    public BigDecimal price() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", title, price);
    }
}

public class FI {
    public static void main(String[] args) {


        List<TrainingCourses> onlineCourses = new ArrayList<>();
        onlineCourses.add(new TrainingCourses("Java", new BigDecimal("200")));
        onlineCourses.add(new TrainingCourses("Scala", new BigDecimal("300")));
        onlineCourses.add(new TrainingCourses("Spring", new BigDecimal("250")));
        onlineCourses.add(new TrainingCourses("NoSQL", new BigDecimal("310")));
        // Creating Comparator to compare Price of training courses

        final Comparator<TrainingCourses> PRICE_COMPARATOR = new Comparator<TrainingCourses>() {
            @Override
            public int compare(TrainingCourses t1, TrainingCourses t2) {
                return t1.price().compareTo(t2.price());
            }
        };

        final Comparable<TrainingCourses> PRICE_COMPARATOR_2 = new Comparable<TrainingCourses>() {
            @Override
            public int compareTo(TrainingCourses o) {
                return o.price().compareTo(o.price());
            }
        };


    }
}

