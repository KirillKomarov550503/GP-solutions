package collectors.groupingBy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");
        Map<String, String> map = strings.stream()
                .collect(Collectors.groupingBy(
                        elem -> elem.substring(0, 1),
                        Collectors.mapping(elem -> elem.substring(1, 2),
                                Collectors.joining(":"))));
        System.out.println("Map: " + map);
    }
}
