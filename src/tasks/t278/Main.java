package tasks.t278;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\TestDir\\";
        String[] strings = Files.lines(Paths.get(dir + "input.txt"))
                .toArray(String[]::new);
        String firstLine = strings[0];
        String secondLine = strings[1];
        int firstLength = strings[0].length();
        int secondLength = strings[1].length();
        for (int i = 0, j = 0; i < secondLength; i++) {
            if (secondLine.charAt(i) == firstLine.charAt(j)) {
                if (j < (firstLength - 1)) {
                    j++;
                } else {
                    Files.write(Paths.get(dir + "output.txt"), "YES".getBytes());
                    System.exit(0);
                }
            }
        }
        Files.write(Paths.get(dir + "output.txt"), "NO".getBytes());
    }
}
