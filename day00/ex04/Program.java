import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        long MinScoreForWeek = 0;
        while (!str.equals("42")) {
            if (!str.equals("Week")) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            int num = scanner.nextInt();
            if (num < 1 || num > 18) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            long min = 10;
            for (int i = 0; i < 5; ++i) {
                int tmp = scanner.nextInt();
                if (tmp < 1 || tmp > 9) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                min = tmp > min ? min : tmp;
            }
            while (num > 1) {
                min *= 10;
                num--;
            }
            MinScoreForWeek += min;
            str = scanner.next();
        }
        int num = 1;
        while (MinScoreForWeek > 0) {
            int min = (int)(MinScoreForWeek % 10);
            if (min > 0) {
                System.out.print("Week " + num + " ");
                while (min > 0) {
                    System.out.print("=");
                    min--;
                }
                System.out.println(">");
            }
            MinScoreForWeek /= 10;
            num++;
        }
    }
}
