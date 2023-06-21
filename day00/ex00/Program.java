public class Program {
    public static void main(String[] args) {
        int num = 123456;
        int sum = 0;

        sum += num % 10;
        sum += (num / 10) % 10;
        sum += (num / 100) % 10;
        sum += (num / 1000) % 10;
        sum += (num / 10000) % 10;
        sum += (num / 100000) % 10;

        System.out.println(sum);
    }
}