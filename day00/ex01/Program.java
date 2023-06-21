import java.util.Scanner;

class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num < 1) {
            System.out.println("theIllegalArgument");
            return;
        }
        int count = 2;
        int sqrt = 0;
        while (sqrt * sqrt < num)
            sqrt++;
        while (count < sqrt) {
            if (num % count == 0) {
                System.out.println("false " + (count - 1));
                return;
            }
            count++;
        }
        System.out.println("true " + (count - 1));
    }
}
