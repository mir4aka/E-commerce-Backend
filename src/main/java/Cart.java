package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private final List<CartItem> cartItems = new ArrayList<>(); // избрани продукти
    private double deliveryFee;

    private double getVAT() {
        return this.calculateProductsPrices() * 0.2;
    }


    public double calculateFinalPrice() { //изчисляване на крайна цена на продуктите в кошницата заедно с ДДСто
        double sumWithVAT = this.calculateProductsPrices() + getVAT();

        if (this.calculateProductsPrices() < 100) {
            this.deliveryFee = 10;
        } else if (this.calculateProductsPrices() >= 100 && this.calculateProductsPrices() < 200) {
            this.deliveryFee = 5;
        } else {
            this.deliveryFee = 0;
        }

        return sumWithVAT + deliveryFee;
    }

    public void addItemsToCart(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public void removeItemsFromCart(CartItem cartItem) {
//        String output = "";
        if (cartItems.isEmpty()) { //проверка дали количката е празна
//            System.out.println("Cart is empty, there is nothing to remove");
            return;
        }


        if (!this.cartItems.contains(cartItem)) { //проверка дали избраният за махане продукт го има въобще в количката
//            System.out.println("Item is not in the cart");
            return;
        } else {
            this.cartItems.remove(cartItem);
//            System.out.println("Item removed: " + cartItem.product.getLabel());
        }
//
//        return output;
    }

    public double calculateProductsPrices() { // изчисляване на сумата на продукта според количеството
        double totalPrice = 0;
        for (CartItem cartItem : this.cartItems) {
            totalPrice += cartItem.product.getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }


    @Override
    public String toString() {
        if(this.cartItems.isEmpty()) {
            return "Your cart is empty.";
        }

        String items = cartItems.stream().map(CartItem::toString).collect(Collectors.joining(", "));
        return "items: " + items + " with delivery fee " + deliveryFee
                + "\nfinal price: " + this.calculateFinalPrice();
    }
}
