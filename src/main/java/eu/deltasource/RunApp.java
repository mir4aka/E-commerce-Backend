package eu.deltasource;

public class RunApp {
    public void runApplication() {
        Product avocados = new Product("Avocados", 3);
        Product tomatoes = new Product("Tomatoes", 17.8);
        Product coffees = new Product("Coffee", 40);
        Product ivan = new Product("Ivan", 10);

        CartItem avocado = new CartItem(avocados, 9);
        CartItem tomato = new CartItem(tomatoes, 6);
        CartItem coffee = new CartItem(coffees, 27);
        CartItem ivans = new CartItem(ivan, 20);

        Cart cart = new Cart();

        cart.addItemsToCart(avocado);
        cart.addItemsToCart(tomato);
        cart.addItemsToCart(coffee);
        cart.addItemsToCart(ivans);

        try {
            cart.removeItemsFromCart(tomato);
            cart.removeItemsFromCart(coffee);
//            cart.removeItemsFromCart(avocado);
//            cart.removeItemsFromCart(ivans);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        cart.calculateFinalPrice();

        System.out.println(cart);
    }
}
