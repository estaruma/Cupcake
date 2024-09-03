package estaruma.cupcake;

// base for all cakes and toppings
public class BakeryItem {
    private String name;
    private double price;

    // constructor
    public BakeryItem(String name, double price) {
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
