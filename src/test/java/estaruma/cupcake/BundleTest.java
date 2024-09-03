package estaruma.cupcake;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BundleTest {
    @Test
    void testCakeWithMultipleToppings() {
        BakeryItem cupcake = new Cupcake();
        BakeryItem chocolateCupcake = new Toppings(cupcake, "🍫", 0.10);
        BakeryItem nutsChocolateCupcake = new Toppings(chocolateCupcake, "🥜", 0.10);

        assertEquals("🧁 with 🍫 with 🥜", nutsChocolateCupcake.getName());
        assertEquals(1.20, nutsChocolateCupcake.getPrice(), 0.001);
    }

    @Test
    void testBundleOfCakes() {
        BakeryItem cupcake = new Cupcake();
        BakeryItem chocolateCupcake = new Toppings(cupcake, "🍫", 0.10);
        BakeryItem nutsChocolateCupcake = new Toppings(chocolateCupcake, "🥜", 0.10);
        BakeryItem cookie = new Cookie();

        BakeryItem bundle = new Bundle(List.of(nutsChocolateCupcake, cookie));

        assertEquals("🧁 with 🍫 with 🥜, 🍪", bundle.getName());
        assertEquals(2.88, bundle.getPrice(), 0.001);
    }

    @Test
    void testLargeBundleWithMultipleItems() {
        BakeryItem cupcake1 = new Cupcake();
        BakeryItem cupcake2 = new Cupcake();
        BakeryItem cookie = new Cookie();

        BakeryItem chocolateCupcake1 = new Toppings(cupcake1, "🍫", 0.10);
        BakeryItem chocolateCupcake2 = new Toppings(cupcake2, "🍫", 0.10);

        BakeryItem nutsChocolateCupcake1 = new Toppings(chocolateCupcake1, "🥜", 0.10);
        BakeryItem nutsChocolateCupcake2 = new Toppings(chocolateCupcake2, "🥜", 0.10);

        BakeryItem largeBundle = new Bundle(List.of(nutsChocolateCupcake1, nutsChocolateCupcake2, cookie));

        assertEquals("🧁 with 🍫 with 🥜, 🧁 with 🍫 with 🥜, 🍪", largeBundle.getName());

        assertEquals(3.96, largeBundle.getPrice(), 0.001);
    }

    @Test
    void testNestedBundleDiscounts() {
        BakeryItem cupcake1 = new Cupcake();
        BakeryItem cupcake2 = new Cupcake();
        BakeryItem cookie = new Cookie();

        BakeryItem chocolateCupcake1 = new Toppings(cupcake1, "🍫", 0.10);
        BakeryItem nutsChocolateCupcake1 = new Toppings(chocolateCupcake1, "🥜", 0.10);

        BakeryItem bundle1 = new Bundle(List.of(nutsChocolateCupcake1, cookie));

        BakeryItem plainCupcake = new Cupcake();
        BakeryItem bundle2 = new Bundle(List.of(bundle1, plainCupcake)); // Nested bundle

        String expectedName = "🧁 with 🍫 with 🥜, 🍪, 🧁";
        assertEquals(expectedName, bundle2.getName());

        // (1.2 + 2) * 0.9 = 2.88
        // (2.88 + 1) * 0.9 = 3.49 after rounding
        assertEquals(3.49, bundle2.getPrice(), 0.001);
    }

    @Test
    void testEmptyBundle() {
        BakeryItem emptyBundle = new Bundle(List.of());

        assertEquals("", emptyBundle.getName());

        // 0.00
        assertEquals(0.00, emptyBundle.getPrice(), 0.001);
    }

    @Test
    void testMultipleToppings() {
        BakeryItem cupcake = new Cupcake();
        BakeryItem chocolateCupcake = new Toppings(cupcake, "🍫", 0.10);
        BakeryItem nutsChocolateCupcake = new Toppings(chocolateCupcake, "🥜", 0.10);
        BakeryItem sprinklesNutsChocolateCupcake = new Toppings(nutsChocolateCupcake, "✨", 0.05);

        assertEquals("🧁 with 🍫 with 🥜 with ✨", sprinklesNutsChocolateCupcake.getName());

        // 1 + 0.10 + 0.10 + 0.05 = 1.25
        assertEquals(1.25, sprinklesNutsChocolateCupcake.getPrice(), 0.001);
    }
}


