package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Хлеб", 20);
    Product product2 = new Product(2, "Молоко", 100);
    Product product3 = new Product(3, "Колбаса", 200);

    @Test
    public void shouldRemoveExistProduct() {
        ShopRepository products = new ShopRepository();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Product[] expected = {product1, product2};
        Product [] actual = products.remove(3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNoExistProduct() {
        ShopRepository products = new ShopRepository();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            products.remove(10);
        });
    }


}
