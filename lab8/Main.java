import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String inputFile = "input.txt";
    String outputFile = "output.txt";

    createTestData(inputFile);

    DataManager manager = new DataManager();

    manager.registerDataProcessor(new FilterProcessor());
    manager.registerDataProcessor(new TransformProcessor());
    manager.registerDataProcessor(new PrefixProcessor());
    
    System.out.println("Начало работы...");
    manager.loadData(inputFile);

    System.out.println("Запуск многопоточной обработки...");
    manager.processData();

    manager.saveData(outputFile);
    System.out.println("Работа завершена.");
  }

  private static void createTestData(String fileName) {
    List<String> lines = Arrays.asList(
            "java", "is", "a", "powerful", "language",
            "it", "supports", "multithreading", "and", "stream", "api",
            "io", "nio", "reflection"
    );
    try {
      Files.write(Paths.get(fileName), lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}