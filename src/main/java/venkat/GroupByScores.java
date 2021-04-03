package venkat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByScores {
    public static void main(String[] args) {
        Map<String, Integer> nameScore = new HashMap<>();
        nameScore.put("Name1", 6);
        nameScore.put("name2", 7);
        nameScore.put("name3", 6);
    groupByScores(nameScore);
    }

    private static Map<Integer, List<String>> groupByScores (Map < String, Integer > nameScore){
      System.out.println( nameScore.entrySet().stream().collect(Collectors.groupingBy(entry -> entry.getValue(),Collectors.mapping(entry -> entry.getKey(),Collectors.toList()))));
      return null;
    }
}

