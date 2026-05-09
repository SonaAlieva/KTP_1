import java.util.regex.*;
import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            String text = "Cat Dog Turtle Cow Pig Horse";

            System.out.print("Введите букву: ");
            String letter = scanner.nextLine();

            Pattern pattern = Pattern.compile("\\b" + letter + "\\w*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            System.out.println("Найденные слова:");

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}