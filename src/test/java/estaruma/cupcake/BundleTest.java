package estaruma.cupcake;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BundleTest {
    @Test
    void testCakeWithMultipleToppings() {
        Cake cupcake = new Cupcake();
        Cake chocolateCupcake = new Toppings(cupcake, "🍫", 0.10);
        Cake nutsChocolateCupcake = new Toppings(chocolateCupcake, "🥜", 0.10);

        assertEquals("🧁 with 🍫 with 🥜", nutsChocolateCupcake.getName());
        assertEquals(1.20, nutsChocolateCupcake.getPrice(), 0.001);
    }

    @Test
    void testBundleOfCakes() {
        Cake cupcake = new Cupcake();
        Cake chocolateCupcake = new Toppings(cupcake, "🍫", 0.10);
        Cake nutsChocolateCupcake = new Toppings(chocolateCupcake, "🥜", 0.10);
        Cake cookie = new Cookie();

        Cake bundle = new Bundle(List.of(nutsChocolateCupcake, cookie));

        assertEquals("🧁 with 🍫 with 🥜, 🍪", bundle.getName());
        assertEquals(2.88, bundle.getPrice(), 0.001);
    }

    @Test
    void testLargeBundleWithMultipleItems() {
        Cake cupcake1 = new Cupcake();
        Cake cupcake2 = new Cupcake();
        Cake cookie = new Cookie();

        Cake chocolateCupcake1 = new Toppings(cupcake1, "🍫", 0.10);
        Cake chocolateCupcake2 = new Toppings(cupcake2, "🍫", 0.10);

        Cake nutsChocolateCupcake1 = new Toppings(chocolateCupcake1, "🥜", 0.10);
        Cake nutsChocolateCupcake2 = new Toppings(chocolateCupcake2, "🥜", 0.10);

        Cake largeBundle = new Bundle(List.of(nutsChocolateCupcake1, nutsChocolateCupcake2, cookie));

        assertEquals("🧁 with 🍫 with 🥜, 🧁 with 🍫 with 🥜, 🍪", largeBundle.getName());

        assertEquals(3.96, largeBundle.getPrice(), 0.001);
    }

    @Test
    void testNestedBundleDiscounts() {
        Cake cupcake1 = new Cupcake();
        Cake cupcake2 = new Cupcake();
        Cake cookie = new Cookie();

        Cake chocolateCupcake1 = new Toppings(cupcake1, "🍫", 0.10);
        Cake nutsChocolateCupcake1 = new Toppings(chocolateCupcake1, "🥜", 0.10);

        Cake bundle1 = new Bundle(List.of(nutsChocolateCupcake1, cookie));

        Cake plainCupcake = new Cupcake();
        Cake bundle2 = new Bundle(List.of(bundle1, plainCupcake)); // Nested bundle

        String expectedName = "🧁 with 🍫 with 🥜, 🍪, 🧁";
        assertEquals(expectedName, bundle2.getName());

        // (1.2 + 2) * 0.9 = 2.88
        // (2.88 + 1) * 0.9 = 3.49 after rounding
        assertEquals(3.49, bundle2.getPrice(), 0.001);
    }

    @Test
    void testEmptyBundle() {
        Cake emptyBundle = new Bundle(List.of());

        assertEquals("", emptyBundle.getName());

        // 0.00
        assertEquals(0.00, emptyBundle.getPrice(), 0.001);
    }

    @Test
    void testMultipleToppings() {
        Cake cupcake = new Cupcake();
        Cake chocolateCupcake = new Toppings(cupcake, "🍫", 0.10);
        Cake nutsChocolateCupcake = new Toppings(chocolateCupcake, "🥜", 0.10);
        Cake sprinklesNutsChocolateCupcake = new Toppings(nutsChocolateCupcake, "✨", 0.05);

        assertEquals("🧁 with 🍫 with 🥜 with ✨", sprinklesNutsChocolateCupcake.getName());

        // 1 + 0.10 + 0.10 + 0.05 = 1.25
        assertEquals(1.25, sprinklesNutsChocolateCupcake.getPrice(), 0.001);
    }
}


