package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import homework.exception.NotEnoughExperienceException;
import org.junit.Assert;
import org.junit.Test;

public class PizzaCookerTest {
    private static final double DELTA = 1e-15;
    PizzaCooker cooker = new PizzaCooker("Volodymyr", 10, 45);

    @Test
    public void work() {
        Pizza expected = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        Pizza pizza = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        expected.setPrice(250);
        expected.setSize(45);
        pizza.setSize(45);
        Pizza actual = cooker.work(pizza);
        System.out.println(actual);
        Assert.assertEquals(expected.getPrice(), actual.getPrice(), DELTA);
    }

    @Test(expected = NotEnoughExperienceException.class)
    public void constructorTest() {
        PizzaCooker cooker = new PizzaCooker("Volodymyr", 1, 45);
    }
}