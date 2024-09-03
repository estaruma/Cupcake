package estaruma.cupcake;

// base for all cakes and toppings
public class Cake {
    private String name;
    private double price;

    // constructor
    public Cake (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;

    }

    public double getPrice() {
        return price;
    }
}
