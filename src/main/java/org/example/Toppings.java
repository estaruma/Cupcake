package org.example;

// allow toppings
public class Toppings extends Cake {
    private Cake baseCake;

    public Toppings (Cake baseCake, String topping, double toppingPrice){
        super(baseCake.getName() + " with " + topping, baseCake.getPrice() + toppingPrice);
        this.baseCake = baseCake;
    }

    @Override
    public String getName() {
        return baseCake.getName();
    }

    @Override
    public double getPrice() {
        return baseCake.getPrice();
    }



}
