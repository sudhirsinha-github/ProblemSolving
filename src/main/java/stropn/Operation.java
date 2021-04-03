package stropn;

import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Operation {

    public static void main(String[] args) {

        String line ="";
        List<String> stringsList = new ArrayList<>();
        Collection<List<String>> permutations = Collections2.permutations(Lists.newArrayList("string1", "string2","str3", "str4"));
        for (List<String> str : permutations) {
            stringsList.add(Joiner.on("").join(str));
        }

    }

    public static void findConcatenatedSubstring(String data, String[] words) {

    }
}
