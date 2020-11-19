package homework;

import homework.enums.Cheese;
import homework.enums.Meat;
import homework.enums.Vegetables;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Створення об'єктів піц
        Pizza pizza1 = new Pizza(new Pizza.Dough("yeast"),
                new Filling(Vegetables.OLIVES,
                        Cheese.MOZZARELLA, Meat.CHICKEN));
        Pizza pizza2 = new Pizza(new Pizza.Dough("puff"),
                new Filling(Vegetables.MUSHROOMS,
                        Cheese.BRYNZA, Meat.CHICKEN));
        Pizza pizza3 = new Pizza(new Pizza.Dough("non-yeast"),
                new Filling(Vegetables.TOMATOES,
                        Cheese.BRYNZA, Meat.SAUSAGES));
        pizza1.setSize(15);
        pizza2.setSize(25);
        pizza3.setSize(35);

        //Створення об'єктів замовлень
        Order order1 = new Order(List.of(pizza1));
        Order order2 = new Order(List.of(pizza2, pizza1));
        Order order3 = new Order(List.of(pizza3));

        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<Pizza> pizzas = Arrays.asList(pizza1, pizza2, pizza3);

        //Створення об'єкту офіціант
        Waiter waiter = new Waiter("Oleh", 2, 21, orders);

        //Створення об'єкту піцайола
        PizzaCooker cooker = new PizzaCooker("Volodymyr", 10, 45);

        //Використання ітератора
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            System.out.println(waiter.work(order));
            List<Pizza> pizzasOfCurrentOrder = order.getPizza();
            for (Pizza pizza : pizzasOfCurrentOrder)  {
                System.out.println(cooker.work(pizza));
            }
        }

        System.out.println(waiter.work(orders));
        List<Pizza> pizzasList = orders.stream().flatMap(o -> o.getPizza().stream()).collect(Collectors.toList());
        System.out.println(cooker.work(pizzasList));

        //Виклики власних методів для відображення enums
        System.out.println(Vegetables.showVegetablesEnum());
        System.out.println(Meat.showMeatEnum());
        System.out.println(Cheese.showCheeseEnum());

    }
}
