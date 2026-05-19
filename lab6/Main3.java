public class Main3 {
    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        // 1. Имитируем продажи (добавление в коллекцию)
        tracker.addSale(new Product("Смартфон", 45000));
        tracker.addSale(new Product("Наушники", 5000));
        tracker.addSale(new Product("Чехол для телефона", 1200));
        tracker.addSale(new Product("Наушники", 5000));
        tracker.addSale(new Product("Ноутбук", 90000));
        tracker.addSale(new Product("Наушники", 5000));
        tracker.addSale(new Product("Чехол для телефона", 1200));

        // 2. Выводим список всех проданных товаров
        tracker.printSales();

        // 3. Выводим аналитику (сумма и популярный товар)
        System.out.println("\n--- Финансовые итоги ---");
        System.out.println("Общая сумма продаж: " + tracker.getTotalSalesAmount() + " руб.");
        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularProduct());
    }
}