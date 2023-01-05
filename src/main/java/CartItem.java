package main.java;

public class CartItem {
    protected Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return this.product.getLabel() + " quantity: " + this.quantity;
    }
}
