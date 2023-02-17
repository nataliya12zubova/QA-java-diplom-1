import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private Bun bun;
    private static final double DELTA = 1e-15;

    @Before
    public void createBun(){
        bun = new Bun("Пшеничная",1.5f);
    }

    @Test
    public void shouldGetName(){
        String actual = bun.getName();
        String expected = "Пшеничная";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetPrice(){
        float actual = bun.getPrice();
        float expected = 1.5f;
        assertEquals(expected, actual, DELTA);
    }
}