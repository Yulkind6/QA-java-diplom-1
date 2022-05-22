import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest() {
        String expected = "Белая булочка";
        Bun bun = new Bun("Белая булочка", 100);

        String actual = bun.getName();

        assertEquals("Названия различаются", expected, actual);
    }

    @Test
    public void getPriceTest() {
        float expected = (float) 100.00;
        Bun bun = new Bun("Белая булочка", (float) 100.00);

        float actual = bun.getPrice();

        assertEquals("Цены различаются", expected, actual, 0);
    }
}
