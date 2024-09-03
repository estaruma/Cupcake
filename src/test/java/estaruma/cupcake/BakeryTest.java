package estaruma.cupcake;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BakeryTest {
    @Test
    public void testBundleWithOneCupcakeAndOneCookie() {
        BakeryItem cupcake = new Cupcake();
        BakeryItem cookie = new Cookie();
        BakeryItem bundle = new Bundle(List.of(cupcake, cookie));

        assertEquals("🧁, 🍪", bundle.getName());
        // 1 + 2 = 3.00 * 0.9 = 2.70
        assertEquals(2.70, bundle.getPrice());
    }

    @Test
    public void testBundleWithTwoCupcakesAndOneCookie() {
        BakeryItem cupcake1 = new Cupcake();
        BakeryItem cupcake2 = new Cupcake();
        BakeryItem cookie = new Cookie();
        BakeryItem bundle = new Bundle(List.of(cupcake1, cupcake2, cookie));

        assertEquals("🧁, 🧁, 🍪", bundle.getName());
        // 1 + 1+ 2 = 4 * 0.9 = 3.60
        assertEquals(3.60, bundle.getPrice());
    }

    @Test
    public void testComplexBundle() {
        BakeryItem cupcake1 = new Cupcake();
        BakeryItem cupcake2 = new Cupcake();
        BakeryItem cookie1 = new Cookie();
        BakeryItem cookie2 = new Cookie();

        //  cupcake and 1 cookie
        BakeryItem bundle1 = new Bundle(List.of(cupcake1, cookie1)); // 1 + 2 = 3 * 0.9 = 2.70
        // 1 cupcake and 1 cookie
        BakeryItem bundle2 = new Bundle(List.of(cupcake2, cookie2)); // 1 + 2 = 3 * 0.9 = 2.70

        // Bundle of bundles
        BakeryItem megaBundle = new Bundle(List.of(bundle1, bundle2)); // 2.70 + 2.70 = 5.40 * 0.9 = 4.86

        BakeryItem finalBundle = new Bundle(List.of(megaBundle, new Cupcake())); // 4.86 + 1 = 5.86 * 0.9 = 5.27

        assertEquals("🧁, 🍪, 🧁, 🍪, 🧁", finalBundle.getName());
        assertEquals(5.27, finalBundle.getPrice());
    }
}

