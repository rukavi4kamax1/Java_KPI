package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PizzaCookerMockitoTest {
    private Pizza pizza = mock(Pizza.class);
    private Filling filling = mock(Filling.class);
    private PizzaCooker cooker = new PizzaCooker("Volodymyr", 10, 45);

    @Test
    public void ReturnsPizzaWhenCookerWorks() {
        when(pizza.getFilling()).thenReturn(filling);
        when(filling.getCheese()).thenReturn(Cheese.MOZZARELLA);
        when(filling.getMeat()).thenReturn(Meat.CHICKEN);
        when(filling.getVegetables()).thenReturn(Vegetables.OLIVES);
        Assert.assertEquals(pizza, cooker.work(pizza));
    }
}