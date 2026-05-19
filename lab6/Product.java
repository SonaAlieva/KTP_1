import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + price + " руб.)";
    }
}


class SalesTracker {

    private LinkedList<Product> soldProducts = new LinkedList<>();


    public void addSale(Product product) {
        soldProducts.add(product);
        System.out.println("Добавлено в продажи: " + product.getName());
    }


    public void printSales() {
        if (soldProducts.isEmpty()) {
            System.out.println("Продаж пока не было.");
            return;
        }
        System.out.println("\n--- Список проданных товаров ---");
        for (Product p : soldProducts) {
            System.out.println("- " + p);
        }
    }

    public double getTotalSalesAmount() {
        double total = 0;
        for (Product p : soldProducts) {
            total += p.getPrice();
        }
        return total;
    }


    public String getMostPopularProduct() {
        if (soldProducts.isEmpty()) {
            return "Нет данных (продажи отсутствуют)";
        }


        Map<String, Integer> frequencyMap = new HashMap<>();
        for (Product p : soldProducts) {
            frequencyMap.put(p.getName(), frequencyMap.getOrDefault(p.getName(), 0) + 1);
        }

        String mostPopular = null;
        int maxSales = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxSales) {
                maxSales = entry.getValue();
                mostPopular = entry.getKey();
            }
        }

        return mostPopular + " (продан " + maxSales + " раз(а))";
    }
}
