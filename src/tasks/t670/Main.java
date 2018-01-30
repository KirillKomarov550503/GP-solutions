package tasks.t670;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            int index = Integer.parseInt(Files.lines(Paths.get("C:\\TestDir\\input.txt"))
                    .collect(Collectors.toList())
                    .get(0));
            int number = (int) Stream.iterate(1, i -> i + 1)
                    .filter(elem -> Integer.toString(elem)
                            .chars()
                            .distinct()
                            .count() == Integer.toString(elem).length())
                    .limit(10000)
                    .toArray()[index - 1];
            Files.write(Paths.get("C:\\TestDir\\output.txt"),
                    Integer.toString(number).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}