import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("number of arguments must be 2!");
            return;
        }
        try (FileReader fileReader1 = new FileReader(new File(args[0]));
             FileReader fileReader2 = new FileReader(new File(args[1]));
             BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
             BufferedReader bufferedReader2 = new BufferedReader(fileReader2);) {
            Map<String, Integer> words1 = new HashMap<>();
            Map<String, Integer> words2 = new HashMap<>();
            Set<String> dic = new HashSet<>();
            String line;
            while ((line = bufferedReader1.readLine()) != null) {
                for (String word : line.split(" ")) {
                    dic.add(word);
                    if (!words1.containsKey(word)) {
                        words1.put(word, 1);
                    } else {
                        words1.put(word, words1.get(word) + 1);
                    }
                }
            }
            while ((line = bufferedReader2.readLine()) != null) {
                for (String word : line.split(" ")) {
                    dic.add(word);
                    if (!words2.containsKey(word)) {
                        words2.put(word, 1);
                    } else {
                        words2.put(word, words2.get(word) + 1);
                    }
                }
            }
            int mas1[] = new int[dic.size()];
            int mas2[] = new int[dic.size()];
            int i = 0;
            for (String key : dic) {
                mas1[i] = words1.get(key) == null ? 0 : words1.get(key);
                mas2[i] = words2.get(key) == null ? 0 : words2.get(key);
                i++;
            }
            System.out.println("Similarity = " + String.format("%.2f", (double) numerator(mas1, mas2) / denominator(mas1, mas2)));

        } catch (IOException e) {

        }
    }

    static private int numerator(int[] m1, int[] m2) {
        int sum = 0;
        for (int i = 0; i < m1.length; ++i) {
            sum += m1[i] * m2[i];
        }
        return sum;
    }

    static private double denominator(int[] m1, int[] m2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < m1.length; ++i) {
            sum1 += m1[i] * m1[i];
            sum2 += m2[i] * m2[i];
        }
        return (Math.sqrt(sum1) * Math.sqrt(sum2));
    }
}