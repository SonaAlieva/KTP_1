import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    private final int threadCount = Runtime.getRuntime().availableProcessors();
    private final ExecutorService executor = Executors.newFixedThreadPool(threadCount);

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        try {
            data = Files.readAllLines(Paths.get(source));
            System.out.println("Загружено строк: " + data.size());
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }

    public void saveData(String destination) {
        try {
            Files.write(Paths.get(destination), data);
            System.out.println("Данные успешно сохранены в: " + destination);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    public void processData() {
        if (data.isEmpty() || processors.isEmpty()) return;

        int chunkSize = (int) Math.ceil((double) data.size() / threadCount);
        List<Callable<List<String>>> tasks = new ArrayList<>();

        for (int i = 0; i < data.size(); i += chunkSize) {
            final int start = i;
            final int end = Math.min(data.size(), i + chunkSize);
            final List<String> subList = data.subList(start, end);

            tasks.add(() -> {
                List<String> currentData = new ArrayList<>(subList);

                for (Object processor : processors) {
                    Method[] methods = processor.getClass().getDeclaredMethods();
                    for (Method method : methods) {

                        if (method.isAnnotationPresent(DataProcessor.class)) {
                            @SuppressWarnings("unchecked")
                            List<String> result = (List<String>) method.invoke(processor, currentData);
                            currentData = result;
                        }
                    }
                }
                return currentData;
            });
        }

        try {
            List<Future<List<String>>> futures = executor.invokeAll(tasks);
            List<String> processedData = new ArrayList<>();

            for (Future<List<String>> future : futures) {
                processedData.addAll(future.get());
            }

            this.data = processedData;

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Ошибка при многопоточной обработке: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }
}
