package main.java;

public class RunApp {
    public void runApplication() {
        Product avocados = new Product("Avocados", 3);
        Product tomatoes = new Product("Tomatoes", 17.8);
        Product coffees = new Product("Coffee", 40);

        CartItem avocado = new CartItem(avocados, 9);
        CartItem tomato = new CartItem(tomatoes, 6);
        CartItem coffee = new CartItem(coffees, 27);

        Cart cart = new Cart();

        cart.addItemsToCart(avocado);
        cart.addItemsToCart(tomato);
        cart.addItemsToCart(coffee);


        cart.removeItemsFromCart(tomato);
//        cart.removeItemsFromCart(coffee);
        cart.removeItemsFromCart(avocado);

        cart.calculateFinalPrice();

        System.out.println(cart);
    }
}
