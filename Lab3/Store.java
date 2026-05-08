import java.util.HashMap;

public class Store {

    // HashMap: артикул  товар
    private HashMap<String, Product> products = new HashMap<>();


    public void addProduct(String article, Product product) {
        products.put(article, product);
    }


    public Product getProduct(String article) {
        return products.get(article);
    }


    public void removeProduct(String article) {
        products.remove(article);
    }

    // Показать все товары
    public void printAllProducts() {
        for (String key : products.keySet()) {
            System.out.println(key + " → " + products.get(key));
        }
    }

    // Тест
    public static void main(String[] args) {
        Store store = new Store();

        // создаём товары
        Product p1 = new Product("Laptop", "Gaming laptop", 1200.0, 5);
        Product p2 = new Product("Phone", "Smartphone", 800.0, 10);

        // добавляем
        store.addProduct("A123", p1);
        store.addProduct("B456", p2);

        // поиск
        System.out.println("Поиск A123:");
        System.out.println(store.getProduct("A123"));

        // удаление
        store.removeProduct("B456");

        // вывод всех
        System.out.println("Все товары");
        store.printAllProducts();
    }
}
