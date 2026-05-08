import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite{
    public static void main(String[] args) {

        try (
            FileInputStream fis = new FileInputStream("input.txt");
            FileOutputStream fos = new FileOutputStream("output.txt");){

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("Файл успешно скопирован.");

        } catch (IOException e) {
            System.err.println("Ошибка при работе с содержимым файла!" + e.getMessage());

        }
    }
}