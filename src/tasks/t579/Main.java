package tasks.t579;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static void write(ArrayList<String> arrayList, String dir) throws IOException {

        StringBuilder stringBuilder = new StringBuilder(100000);
        stringBuilder.append(arrayList.size());
        stringBuilder.append(System.lineSeparator());
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append(arrayList.get(i) + " ");
        }
        byte[] array = stringBuilder.toString().getBytes();
        Files.write(Paths.get(dir + "output.txt"), array);
    }

    public static void main(String[] args) throws IOException {
        String dir = "C:\\TestDir\\";
        String[] strings = Files.lines(Paths.get(dir + "input.txt"))
                .toArray(String[]::new)[1].split(" ");
        ArrayList<String> positive = new ArrayList<>(5000);
        ArrayList<String> negative = new ArrayList<>(5000);
        int posSum = 0;
        int negSum = 0;
        int num;
        for (int i = 0; i < strings.length; i++) {
            num = Integer.parseInt(strings[i]);
            if (num >= 0) {
                posSum += num;
                positive.add(Integer.toString(i + 1));
            } else {
                negSum += num;
                negative.add(Integer.toString(i + 1));
            }
        }
        if (posSum > negSum * (-1))
            write(positive, dir);
        else
            write(negative, dir);
    }
}
