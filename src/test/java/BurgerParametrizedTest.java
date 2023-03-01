import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParametrizedTest {

    private final Bun bun;
    private final float expectedPrice;
    private static final double DELTA = 1e-15;


    public BurgerParametrizedTest(Bun bun, float expectedPrice) {
        this.bun = bun;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {new Bun("Пшеничная",5.00f), 12.00f},
                {new Bun("Пшеничная",0.0f), 2.0f},
                {new Bun("Пшеничная",5f), 12.0f},
                {new Bun("Пшеничная",-2.0f), -2.0f},
                {new Bun("Пшеничная", Float.MAX_VALUE), Float.POSITIVE_INFINITY},
                {new Bun("Пшеничная", Float.MIN_VALUE), 2f}
        };
    }

    @Test
    public void getPriceForBurger() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE,"Барбекю",1.0f));
        burger.ingredients.add(new Ingredient(IngredientType.FILLING,"Котлета",1.0f));
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, DELTA);
    }
}
