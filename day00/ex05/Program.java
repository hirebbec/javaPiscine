import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        int []unicode = new int[65535];
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char [][]graf = new char[12][40];
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 39; j++) {
                graf[i][j] = ' ';
            }
        }
        for (int i = 0; i < str.length(); ++i) {
            unicode[str.charAt(i)]++;
        }
        int Max = 0;
        for (int i = 1; i < 65535; ++i) {
            Max = Max > unicode[i] ? Max : unicode[i];
        }
        if (Max > 999) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        for (int i = 0; i < 10; ++i) {
            int max = 0;
            for (int j = 1; j < 65535; ++j) {
                max = unicode[max] >= unicode[j] ? max : j;
            }
            graf[0][(i + 1) * 4 - 1] = (char)max;
            int k = 0;
            for (k = 0; k < 10 * unicode[max] / Max; ++ k) {
                graf[k + 1][(i + 1) * 4 - 1] = '#';
            }
            graf[k][(i * 4) + 3] = (char)((unicode[max] % 10) + '0');
            if (((unicode[max] / 10) % 10) > 0)
                graf[k][(i * 4) + 2] = (char)(((unicode[max] / 10) % 10) + '0');
            if (((unicode[max] / 100) % 10) > 0)
                graf[k][(i * 4) + 1] = (char)(((unicode[max] / 100) % 10) + '0');
            unicode[max] = -1;
        }
        for (int i = 11; i >= 0; --i) {
            for (int j = 0; j < 39; j++) {
                System.out.print(graf[i][j]);
            }
            System.out.println();
        }
    }
}
