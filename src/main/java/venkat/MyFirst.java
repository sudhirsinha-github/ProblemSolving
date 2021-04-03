package venkat;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class MyFirst {
    public static void main(String[] args) {
        final int number = 5;
       // System.out.println(fibonaci(4));
        test();
    }

    private static List<Integer> fibonaci(int position) {
        if (position == 1) {
            System.out.println("position, position bjk cfghjik position");
            return Arrays.asList(1);
        }
        if (position == 2) {
            return Arrays.asList(1, 1);
        }
        return IntStream.rangeClosed(0, position - 2)
                .boxed()
                .map(index -> {

                    return new ArrayList<Integer>(Arrays.asList(1, 1));
                })
                .reduce((res, input) ->
                {
                    res.add(res.size(), res.get(res.size() - 1) + res.get(res.size() - 2));
                    return res;
                }).orElse(new ArrayList<Integer>());
    }

    private static void test()
    {
        String _data = "wErr";
        Optional<String> stringOptional =  Optional.ofNullable(_data).map(r -> r.toLowerCase());
        System.out.println(stringOptional.get());

    }

}

