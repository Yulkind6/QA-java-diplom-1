import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String expected;
    private final IngredientType type;

    public IngredientTypeTest(String expected, IngredientType type) {
        this.expected = expected;
        this.type = type;
    }

    @Parameterized.Parameters(name = "Тип ингредиента - {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, "Ингредиент", 100);
        String actual = ingredient.getType().toString();

        assertEquals("Типы ингредиентов различаются", expected, actual);
    }
}
