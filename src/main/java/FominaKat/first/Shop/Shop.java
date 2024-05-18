package FominaKat.first.Shop;

import java.util.*;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        Comparator<Product> forCost = Comparator.comparingInt(Product::getCost);
        Collections.sort(products, forCost);
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        Comparator<Product> forCost = Comparator.comparingInt(Product::getCost);
        return Collections.max(products, forCost);


    }

}