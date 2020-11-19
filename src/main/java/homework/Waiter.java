package homework;

import homework.exception.NotEnoughExperienceException;
import homework.exception.WrongOrderException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ToString
@Getter
@Setter
public class Waiter extends Employee<Order> {

    private List<Order> orders = new ArrayList<>();

    public Waiter(String name, double experience, int age, List<Order> orders)
            throws NotEnoughExperienceException {
        super(name, experience, age);
        this.orders = orders;
    }

    public Waiter(String name, double experience, int age) throws NotEnoughExperienceException {
        super(name, experience, age);
    }

    public List<Order> work(List<Order> orders) {
        for (Order order : orders) {
            List<Pizza> pizzas = order.getPizza();
            Iterator<Pizza> iterator = pizzas.iterator();
            while (iterator.hasNext()) {
                Pizza pizza = iterator.next();
                if (pizza.getSize() < 10) {
                    // використання власного WrongOrderException та обробка помилка в блоці try-catch-finally
                    throw new WrongOrderException("The size of pizza is too small..." +
                            "Enter the size more than 10 the next time...");
                }
            }
        }
        System.out.println("The order was done");
        return orders;
    }

    //Метод, який імітує взяття замовлення офіціантом
    @Override
    public Order work(Order order) {
        List<Pizza> pizzas = order.getPizza();
        Iterator<Pizza> iterator = pizzas.iterator();
        while (iterator.hasNext()) {
            Pizza pizza = iterator.next();
            if (pizza.getSize() < 10) {
                // використання власного WrongOrderException та обробка помилка в блоці try-catch-finally
                throw new WrongOrderException("The size of pizza is too small..." +
                        "Enter the size more than 10 the next time...");
            }
        }
        System.out.println("The order was done");
        return order;
    }
}
