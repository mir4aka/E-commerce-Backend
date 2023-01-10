package eu.deltasource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private final List<CartItem> cartItems = new ArrayList<>(); // избрани продукти
    private double deliveryFee;

    public double calculateFinalPrice() { //изчисляване на крайна цена на продуктите в кошницата заедно с ДДСто и доставката
        double finalPrice = this.calculateProductsPrices() + getVAT();

        if (this.calculateProductsPrices() < 100) {
            this.deliveryFee = 10;
        } else if (this.calculateProductsPrices() >= 100 && this.calculateProductsPrices() < 200) {
            this.deliveryFee = 5;
        } else {
            this.deliveryFee = 0;
        }

        return finalPrice + deliveryFee;
    }

    public void addItemsToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public void removeItemsFromCart(CartItem cartItem) {
        if (checkIfTheCartIsEmpty()) { //проверка дали количката е празна, ако е празна, изкарва резултат
            return;
        }

        if (!this.cartItems.contains(cartItem)) { //проверка дали избраният за махане продукт го има въобще в количката
            throw new IllegalArgumentException("Item is not in the cart");
        } else {
            this.cartItems.remove(cartItem);
        }
    }

    public double calculateProductsPrices() { // изчисляване на сумата на продукта според количеството
        double productPrice = 0;
        for (CartItem cartItem : this.cartItems) {
            productPrice += cartItem.product.getPrice() * cartItem.getQuantity();
        }

        return productPrice;
    }

    private double getVAT() {
        return this.calculateProductsPrices() * 0.2;
    }

    private boolean checkIfTheCartIsEmpty() {
        if (this.cartItems.isEmpty()) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        if (checkIfTheCartIsEmpty()) {
            deliveryFee = 0;
            return "Your cart is empty";
        }

        String items = cartItems.stream().map(CartItem::toString).collect(Collectors.joining(", "));

        return String.format("""
                Items in cart: %s
                Delivery fee: %.2f lv.
                Final price:  %.2f lv.""", items, this.deliveryFee, this.calculateFinalPrice());
    }
}
