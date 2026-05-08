public class ArrayAverage {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5};
        String[] arr = {"1", "1", "2", "45", "abs"};
        int sum = 0;
        int count = 0;

        try {
            for (int i = 0; i <= arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
                //sum += arr[i];
                count++;
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Попытка обратиться к несуществующему индексу массива (" + e.getMessage() + ").");

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Элемент не является числом.");

        } finally {

            if (count > 0) {
                double average = (double) sum / count;
                System.out.println("Среднее арифметическое: " + average);
            } else {
                System.out.println("Массив пуст, вычисление среднего невозможно.");
            }
        }
    }
}
