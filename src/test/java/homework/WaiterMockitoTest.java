package homework;

import homework.exception.WrongOrderException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WaiterMockitoTest {

    @Mock
    private Order myOrder;

    @Mock
    private Pizza pizza;
    private Waiter waiter;

    @Test
    public void ReturnsOrderWhenWaiterWorks() {
        waiter = new Waiter("Oleh", 2, 21);
        when(myOrder.getPizza()).thenReturn(List.of(pizza));
        when(pizza.getSize()).thenReturn(15D);
        Assert.assertEquals(myOrder, waiter.work(myOrder));
    }

    @Test(expected = WrongOrderException.class)
    public void ThrowsExceptionWhenSizeOfPizzaTooLittle() {
        waiter = new Waiter("Oleh", 2, 21);
        when(myOrder.getPizza()).thenReturn(List.of(pizza));
        when(pizza.getSize()).thenReturn(5D);
        waiter.work(myOrder);
    }
}