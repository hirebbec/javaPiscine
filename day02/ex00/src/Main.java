import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final char[] HEX = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("results.txt");
             OutputStreamWriter outputStream = new OutputStreamWriter(fileOutputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStream)){
            Map<String, String> signatures = readSignatures();
            Scanner scanner = new Scanner(System.in);
            String path;

            while (!(path = scanner.next()).equals("42")) {
                FileInputStream fileInputStream1 = new FileInputStream(path);
                byte[] b = new byte[100];
                fileInputStream1.read(b, 0, 20);
                for (String key : signatures.keySet()) {
                    if (key.equals(bytesToHex(b).substring(0, key.length()))) {
                        System.out.println("PROCESSED");
                        bufferedWriter.write(signatures.get(key) + "\n");
                    }
                }
            }
            bufferedWriter.close();
        } catch (RuntimeException | IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private static Map<String, String> readSignatures() {
        try (FileInputStream fileInputStream = new FileInputStream(new File("./src/resources/signatures.txt"));
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            Map<String, String> signatures = new HashMap<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String value = line.split(",")[0];
                String key = line.split(",")[1].replaceAll(" ", "");
                signatures.put(key, value);
            }
            return signatures;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];

        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX[v >>> 4];
            hexChars[j * 2 + 1] = HEX[v & 0x0F];
        }
        return new String(hexChars);
    }
}