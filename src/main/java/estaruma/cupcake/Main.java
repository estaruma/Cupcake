package estaruma.cupcake;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cake cupcake = new Cupcake();
        Cake cookie = new Cookie();


        System.out.println(cupcake.getName() + ": $" + cupcake.getPrice());
        System.out.println(cookie.getName() + ": $" + cookie.getPrice());

        Cake chocolateCupcake = new Toppings(cupcake, "🍫", 0.1);
        Cake nutsChocolateCupcake = new Toppings(chocolateCupcake, "🥜", 0.1);

        // Print cakes with toppings
        System.out.println(nutsChocolateCupcake.getName() + ": $" + String.format("%.2f", nutsChocolateCupcake.getPrice()));

        // Create a bundle of cakes
        Cake bundle = new Bundle(List.of(nutsChocolateCupcake, cookie));
        System.out.println(bundle.getName() + ": $" + String.format("%.2f", bundle.getPrice()));

        // Create a nested bundle
        Cake nestedBundle = new Bundle(List.of(bundle, cupcake));

        // Print the nested bundle details
        System.out.println(nestedBundle.getName() + ": $" + String.format("%.2f", nestedBundle.getPrice()));
    }
}