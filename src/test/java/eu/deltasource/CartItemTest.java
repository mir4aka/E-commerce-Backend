package eu.deltasource;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartItemTest {

    Product product = new Product("apple", 5);
    CartItem cartItem = new CartItem(product, 5);

    @Test
    void TestShouldReturnTheQuantityOfTheCart() {
        assertEquals( 5, cartItem.getQuantity());
    }

}