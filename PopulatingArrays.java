/*
 * Created by: MF-ROB
 * Created on: Oct 2026
 * Generates an array of 10 random integers (0 to 100),
 * displays them on one line, then sorts the array with
 * Arrays.sort(), calculates the average, and displays the
 * sorted array and average. This process is repeated 5 times.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    static final String INPUT_FILE = "input.txt";
    static final String OUTPUT_FILE = "output.txt";

    public static void appendLine(String fileName, String text) throws IOException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text + "\n");
        }
    }

    public static int[] populateArray() throws IOException {
        int[] numbers = new int[10];
        Random rand = new Random();
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(101); // 0 to 100
            line.append(numbers[i]).append(" ");
        }
        String text = line.toString().trim();
        System.out.println(text);
        appendLine(INPUT_FILE, text);
        return numbers;
    }

    public static void calculateAverage(int[] numbers) throws IOException {
        Arrays.sort(numbers);

        int sum = 0;
        StringBuilder line = new StringBuilder();
        for (int n : numbers) {
            sum += n;
            line.append(n).append(" ");
        }
        double average = (double) sum / numbers.length;

        String text = String.format("%s  Average:  %.1f", line.toString().trim(), average);
        System.out.println(text);
        appendLine(OUTPUT_FILE, text);
    }

    public static void main(String[] args) {
        try {
            new FileWriter(INPUT_FILE, false).close();   // clear files
            new FileWriter(OUTPUT_FILE, false).close();

            for (int i = 0; i < 5; i++) {
                int[] numbers = populateArray();
                calculateAverage(numbers);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}