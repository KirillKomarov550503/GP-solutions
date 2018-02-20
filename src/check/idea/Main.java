package check.idea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class Main {
    private volatile static int[] matrix1;
    private volatile static int[] matrix2;
    private volatile static int[] result;
    private static int matrixSize;
    private static int squareMatrix;
    private static int p;

    private static void printMatrix(int[] array) {
        System.out.println("\nOne-dimensional array: ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "\t");
        System.out.println("\n\nTwo-dimensional array: ");
        for (int i = 0; i < array.length; i++) {
            if (i % matrixSize == 0)
                System.out.println();
            System.out.print(array[i] + "\t");
        }
        System.out.println("\n_____________________________________________");
    }


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
            int amount = 0;
            int pointer = 0;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                if (line.length() == 0) {
                    pointer++;
                }
                if (count == 0) {
                    amount = Integer.parseInt(line.split(" ")[0]);
                    matrixSize = Integer.parseInt(line.split(" ")[1]);
                    squareMatrix = matrixSize * matrixSize;
                    matrix1 = new int[squareMatrix];
                    for (int j = 0; j < squareMatrix; j += matrixSize + 1)
                        matrix1[j] = 1;
                    matrix2 = new int[squareMatrix];
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
                        int[] temp = Arrays
                                .stream(line.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        for (int j = 0; j < matrixSize; j++, index++)
                            matrix2[index]
                                    = temp[j];

                        i++;
                    } else {
                        i = 0;
                        index = 0;
                        multiplication();
                    }
                }

                count++;
            }
            multiplication();
            Files.write(Paths.get(dir + "output.txt")
                    , Integer.toString(matrix1[row * matrixSize + column]).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void usualMulti(int[] matrix1, int[] matrix2) {
        int matrixSize = (int) Math.sqrt(matrix1.length);
        int squareMatrix = matrix1.length;
        int[] result = new int[squareMatrix];
        for (int i = 0; i < matrixSize; i++){
            int iIndex = i * matrixSize;
            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++)
                    result[iIndex + j] += matrix1[iIndex + k] * matrix2[k * matrixSize + j];
            }
        }

    }

    private static void multiplication() {
        int temp;
        result = new int[squareMatrix];
        for (int i = 0; i < matrixSize; i++){
            int iIndex = i * matrixSize;
            for (int j = 0; j < matrixSize; j++) {
                temp = 0;
                for (int k = 0; k < matrixSize; k++)
                    temp += matrix1[iIndex + k] * matrix2[k * matrixSize + j];
                result[iIndex + j] = (temp >= p) ? temp % p : temp;
            }
        }
        matrix1 = result;
    }

//    private static int lastMulti(int row, int column) {
//        int temp = 0;
//        for (int i = 0; i < matrixSize; i++)
//            temp += matrix1[row][i] * matrix2[i][column];
//        return (temp >= p) ? temp % p : temp;
//    }
//
//    private static void penultimateMulti(int row) {
//        result = new int[matrixSize][matrixSize];
//        for (int j = 0; j < matrixSize; j++) {
//            int temp = 0;
//            for (int k = 0; k < matrixSize; k++)
//                temp += matrix1[row][k] * matrix2[k][j];
//            result[row][j] = (temp >= p) ? temp % p : temp;
//        }
//        matrix1 = result;
//    }
//
//
//    private static void multiplication(int startBorder, int finishBorder) {
//        int temp;
//        result = new int[matrixSize][matrixSize];
//        for (int i1 = startBorder; i1 < finishBorder; i1++)
//            for (int j1 = 0; j1 < matrixSize; j1++) {
//                temp = 0;
//                for (int k1 = 0; k1 < matrixSize; k1++)
//                    temp += matrix1[i1][k1] * matrix2[k1][j1];
//                result[i1][j1] = (temp >= p) ? temp % p : temp;
//            }
//        matrix1 = result;
//    }
}