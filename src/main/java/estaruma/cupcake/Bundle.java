package estaruma.cupcake;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Bundle extends BakeryItem {

    private List<BakeryItem> cakes;

    public Bundle(List<BakeryItem> cakes) {
        super(generateBundleName(cakes), calculateBundlePrice(cakes));
        this.cakes = cakes;
    }

    private static double calculateBundlePrice(List<BakeryItem> cakes) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (BakeryItem cake : cakes) {
            totalPrice = totalPrice.add(BigDecimal.valueOf(cake.getPrice()));
        }
        // Apply rounding before summing and discount
        totalPrice = totalPrice.setScale(2, RoundingMode.HALF_UP);
        // 10%
        totalPrice = totalPrice.multiply(BigDecimal.valueOf(0.9));
        return totalPrice.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private static String generateBundleName(List<BakeryItem> cakes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (BakeryItem cake : cakes) {
            stringBuilder.append(cake.getName()).append(", ");
        }
        return stringBuilder.toString().replaceAll(", $", "");
    }

    @Override
    public String getName() {
        return generateBundleName(cakes);
    }
}