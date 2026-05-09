import java.util.regex.*;
import java.util.Scanner;

public class PasswordCheck {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Пароль должен состоять из латинских букв и цифр, быть " +
                    "длиной от 8 до 16 символов и содержать хотя бы одну заглавную букву и " +
                    "одну цифру");
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();

            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");

            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль корректный");
            } else {
                System.out.println("Пароль некорректный");
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}