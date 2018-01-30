package tasks.t557;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class Main {
    private volatile static int[][] matrix1;
    private volatile static int[][] matrix2;
    private volatile static int[][] result;
    private static int matrixSize;

    private static int p;


    public static void main(String[] args) {

        String dir = "C:\\TestDir\\";
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(dir + "input.txt")))) {

            String line;
            int count = 0;
            int row = 0;
            int column = 0;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (count == 0) {
                    matrixSize = Integer.parseInt(line.split(" ")[1]);
                    matrix1 = new int[matrixSize][matrixSize];
                    for (int j = 0; j < matrixSize; j++)
                        matrix1[j][j] = 1;
                    matrix2 = new int[matrixSize][matrixSize];
                }
                if (count == 1) {
                    row = Integer.parseInt(line.split(" ")[0]) - 1;
                    column = Integer.parseInt(line.split(" ")[1]) - 1;
                }
                if (count == 2) {
                    p = Integer.parseInt(line);
                }
                if (count > 3) {
                    if (line.length() != 0) {
                        matrix2[i] = Arrays
                                .stream(line.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        i++;
                    } else {
                        i = 0;
                        multiplication(0, matrixSize);
                    }
                }
                count++;
            }
            multiplication(0, matrixSize);
            Files.write(Paths.get(dir + "output.txt")
                    , Integer.toString(matrix1[row][column]).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void multiplication(int startBorder, int finishBorder) {
        int temp;
        result = new int[matrixSize][matrixSize];
        for (int i1 = startBorder; i1 < finishBorder; i1++)
            for (int j1 = 0; j1 < matrixSize; j1++) {
                temp = 0;
                for (int k1 = 0; k1 < matrixSize; k1++)
                    temp += matrix1[i1][k1] * matrix2[k1][j1];
                result[i1][j1] = (temp >= p) ? temp % p : temp;
            }
        matrix1 = result;
    }
}