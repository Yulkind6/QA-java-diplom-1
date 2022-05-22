import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    @Test
    public void setBunsTest() {
        Bun expected = bun;
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals(expected, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        List<Ingredient> expected = Arrays.asList(ingredient1, ingredient2);
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        assertEquals("Количество добавленных ингредиентов различается", 2, burger.ingredients.size());
        assertEquals("Тнгредиенты различаются", expected, burger.ingredients);
    }

    @Test
    public void removeIngredientTest() {
        List<Ingredient> expected = Arrays.asList(ingredient2);
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);

        assertEquals("Количество ингредиентов различается", 1, burger.ingredients.size());
        assertEquals("Ингредиенты различаются", expected, burger.ingredients);

        burger.removeIngredient(0);

        assertEquals("Количество ингредиентов различается", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientAndChangeTest() {
        List<Ingredient> expected = Arrays.asList(ingredient2, ingredient1);
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        int expectedSize = burger.ingredients.size();
        burger.moveIngredient(0, 1);

        assertEquals("Количество ингредиентов различается", expectedSize, burger.ingredients.size());
        assertEquals("Порядок ингредиентов различается", expected, burger.ingredients);
    }

    @Test
    public void moveIngredientAndNoChangeTest() {
        List<Ingredient> expected = Arrays.asList(ingredient1, ingredient2);
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        int expectedSize = burger.ingredients.size();
        burger.moveIngredient(0, 0);

        assertEquals("Количество ингредиентов различается", expectedSize, burger.ingredients.size());
        assertEquals("Порядок ингредиентов различается", expected, burger.ingredients);
    }

    @Test
    public void getPriceWholeBurgerTest() {
        float priceBun = (float) 100.00;
        float priceFilling = (float) 100.00;
        float priceSauce = (float) 100;
        float expected = 2 * priceBun + priceFilling + priceSauce;

        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Начинка", priceFilling);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Соус", priceSauce);
        Mockito.when(bun.getPrice()).thenReturn(priceBun);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float actual = burger.getPrice();

        assertEquals("Цены различаются", expected, actual, 0);
    }

    @Test
    public void getPriceNoIngredientsTest() {
        float priceBun = (float) 100.00;
        float expected = 2 * priceBun;

        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(priceBun);

        burger.setBuns(bun);
        float actual = burger.getPrice();

        assertEquals("Цены различаются", expected, actual, 0);
    }
}
