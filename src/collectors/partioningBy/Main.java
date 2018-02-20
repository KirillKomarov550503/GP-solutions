package collectors.partioningBy;


import java.io.IOException;

public class Main {

    private static int number = 0;


    private synchronized static void increment() {
        number++;
    }


    public static void main(String[] args) throws IOException, InterruptedException {
//        String dir = "C:\\TestDir\\";
//        int[] numbers = Arrays.stream(Files.lines(Paths.get(dir + "input.txt"))
//                .toArray(String[]::new)[0].split(" "))
//                .mapToInt(Integer::parseInt).toArray();
//        for(int i =0 ;i < numbers.length; i++)
//            System.out.print(numbers[i] + "\t");
//        Map<Boolean, List<Integer>> map = Arrays.stream(numbers)
//                .mapToObj(elem -> (Integer)elem)
//                .collect(Collectors.partitioningBy(elem -> elem > 0));
//        System.out.println("Map: " + map);

    }
}
