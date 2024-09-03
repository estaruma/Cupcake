package estaruma.cupcake;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BakeryItem cupcake = new Cupcake();
        BakeryItem cookie = new Cookie();

        System.out.println(cupcake.getName() + ": $" + cupcake.getPrice());
        System.out.println(cookie.getName() + ": $" + cookie.getPrice());

        BakeryItem chocolateCupcake = new Toppings(cupcake, "🍫", 0.1);
        BakeryItem nutsChocolateCupcake = new Toppings(chocolateCupcake, "🥜", 0.1);

        // Print cakes with toppings
        System.out.println(nutsChocolateCupcake.getName() + ": $" + String.format("%.2f", nutsChocolateCupcake.getPrice()));

        BakeryItem chocolateCookie = new Toppings(cookie, "🍫", 0.1);
        BakeryItem nutsChocolateCookie = new Toppings(chocolateCookie, "🥜", 0.1);

        System.out.println(nutsChocolateCookie.getName() + ": $" + String.format("%.2f", nutsChocolateCookie.getPrice()));

        // Create a bundle of cakes
        BakeryItem bundle = new Bundle(List.of(nutsChocolateCupcake, nutsChocolateCookie));
        System.out.println(bundle.getName() + ": $" + String.format("%.2f", bundle.getPrice()));

        // Create a nested bundle
        BakeryItem nestedBundle = new Bundle(List.of(bundle, cupcake));

        // Print the nested bundle details
        System.out.println(nestedBundle.getName() + ": $" + String.format("%.2f", nestedBundle.getPrice()));
    }
}