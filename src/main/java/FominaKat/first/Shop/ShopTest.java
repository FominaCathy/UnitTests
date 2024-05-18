package FominaKat.first.Shop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    private static Shop testShop;

    public static void main(String[] args) {
        initShop();

        // 1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
        //    (правильное количество продуктов, верное содержимое корзины).
        assertThat(testShop.getProducts())
                .isNotEmpty()
                .hasSize(3);

        assertThat(testShop.getProducts().stream().map(Product::getTitle).toList())
                .contains("Milk", "Coffee", "Apple");

        //2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        Product result = testShop.getMostExpensiveProduct();
        assert result.getCost() == 100;
        assert result.getTitle().equals("Coffee");

        //3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
        // (проверьте правильность сортировки).
        List<Product> productList = testShop.sortProductsByPrice();
        assertThat(productList.stream().map(e -> e.getCost()))
                .isNotEmpty()
                .hasSize(3)
                .startsWith(5)
                .containsSequence(5, 10, 100);

    }

    private static void initShop() {
        testShop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Milk", 10));
        products.add(new Product("Coffee", 100));
        products.add(new Product("Apple", 5));

        testShop.setProducts(products);
    }


}