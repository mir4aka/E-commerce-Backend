package main.java;

public class Product {
    private String label;
    private double price;

    public Product(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }

    public String getInfo() {
        return this.label + " " + this.price;
    }
}
