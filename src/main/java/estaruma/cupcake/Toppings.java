package estaruma.cupcake;


// allow toppings
public class Toppings extends BakeryItem {
    private BakeryItem baseCake;

    public Toppings (BakeryItem baseCake, String topping, double toppingPrice){
        super(baseCake.getName() + " with " + topping, baseCake.getPrice() + toppingPrice);
        this.baseCake = baseCake;
    }

    // gets full name with toppings

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }



}
