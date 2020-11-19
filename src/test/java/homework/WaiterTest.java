package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import homework.exception.NotEnoughExperienceException;
import homework.exception.WrongOrderException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WaiterTest {
    private Waiter waiter = new Waiter("Oleh", 2, 21);

    @Test
    public void work_Ok() {
        Pizza pizza = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        pizza.setSize(45);
        Order order = new Order(List.of(pizza));
        Assert.assertEquals(order, waiter.work(order));
    }

    @Test(expected = WrongOrderException.class)
    public void work() {
        Pizza pizza = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        pizza.setSize(5);
        Order order = new Order(List.of(pizza));
        waiter.work(order);
    }

    @Test
    public void workTestList_Ok() {
        Pizza pizza = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        pizza.setSize(45);
        Order order = new Order(List.of(pizza));
        Order order2 = new Order(List.of(pizza, pizza));
        Assert.assertEquals(List.of(order, order2), waiter.work(List.of(order, order2)));
    }

    @Test(expected = WrongOrderException.class)
    public void workTestList() {
        Pizza pizza = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        pizza.setSize(5);
        Order order = new Order(List.of(pizza));
        Order order2 = new Order(List.of(pizza, pizza));
        Assert.assertEquals(List.of(order, order2), waiter.work(List.of(order, order2)));
    }

    @Test(expected = NotEnoughExperienceException.class)
    public void constructorTest() {
        Waiter waiter = new Waiter("Oleh", 1, 21);
    }
}