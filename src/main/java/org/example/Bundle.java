package org.example;

import java.util.List;

// applies discount
public class Bundle extends Cake {

    private List<Cake> cakes;

    public Bundle(List<Cake> cakes) {
        super(generateBundleName(cakes), calculateBundlePrice(cakes));
        this.cakes = cakes;
    }

    private static double calculateBundlePrice(List<Cake> cakes) {
        double totalPrice = 0;
        for (Cake cake : cakes) {
            totalPrice += cake.getPrice();
        }
        // 10% discount
        return totalPrice * 0.9;
    }

    // generater the bundle name
    private static String generateBundleName(List<Cake> cakes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Cake cake : cakes) {
            // seperate with commas
            stringBuilder.append(cake.getName()).append(", ");
        }
        return stringBuilder.toString().replaceAll(", $", "");
    }

    @Override
    public String getName() {
        return generateBundleName(cakes);
    }
}