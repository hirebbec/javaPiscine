import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner =  new Scanner(System.in);
        int num = scanner.nextInt();
        while (num != 42) {
            if (isPrime(digitsCount(num)))
                count++;
            num = scanner.nextInt();
        }
        System.out.println("Count of coffe-request - " + count);
    }

    static int sqrt(int num) {
        if (num < 0) {
            return 0;
        }
        int sqrt = 0;
        while (sqrt * sqrt < num) {
            sqrt++;
        }
        return sqrt;
    }

    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        int sqrt = sqrt(num);
        int i = 2;

        while (i < sqrt) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    static int digitsCount(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 10;
            num /= 10;
        }
        return count;
    }
}
