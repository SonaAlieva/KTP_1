public class Main2 {
    public static void main(String[] args) {
        // Указываем тип Integer при создании объекта
        Stack<Integer> stack = new Stack<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());  // Выведет: 3 (последний зашел — первый вышел)
        System.out.println(stack.peek()); // Выведет: 2 (смотрим на верхний элемент, не удаляя)

        stack.push(4);
        System.out.println(stack.pop());  // Выведет: 4
    }
}