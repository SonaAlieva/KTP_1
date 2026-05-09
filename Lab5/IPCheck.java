import java.util.regex.*;
import java.util.Scanner;

public class IPCheck {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String ip = scanner.nextLine();

            String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("IP-адрес корректный");
            } else {
                System.out.println("IP-адрес некорректный");
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}