package eu.deltasource;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product = new Product("apple", 5);

    @Test
    void testProductLabel() {
        assertEquals("apple", product.getLabel());
    }

    @Test
    void testProductPrice() {
        assertEquals(5, product.getPrice());
    }

    @Test
    void testToStringMethod() {
       assertEquals("apple 5.0", product.toString());
    }
}