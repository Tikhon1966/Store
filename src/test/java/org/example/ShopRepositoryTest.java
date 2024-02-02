package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Хлеб", 20);
    Product product2 = new Product(2, "Молоко", 100);


    ShopRepository products = new ShopRepository();

    @BeforeEach
    public void setup() throws AlreadyExistsException {
        products.add(product1);
    }

    @Test
    public void shouldRemoveExistProduct() {
        Product[] expected = {};
        Product[] actual = products.remove(1);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNoExistProduct() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            products.remove(10);
        });
    }

    @Test
    public void testSuccessAdd() throws AlreadyExistsException {

        Product[] expected = {product1, product2};
        Product[] actual = products.add(product2);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAlreadyAddProduct() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            products.add(product1);
        });
    }
}
