import java.util.regex.*;

public class Upper {
    public static void main(String[] args) {
        try {
            String text = "heLlo worLd teSt";

            Pattern pattern = Pattern.compile("(?<=[a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);

            String result = matcher.replaceAll("!$1!");

            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}