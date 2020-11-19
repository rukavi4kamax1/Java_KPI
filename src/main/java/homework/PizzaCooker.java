package homework;

import homework.exception.NotEnoughExperienceException;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PizzaCooker extends Employee<Pizza> {
    private static final double MAX_PRICE = 250;
    private static final double UPPER_INTERMEDIATE_PRICE = 220;
    private static final double INTERMEDIATE_PRICE = 200;
    private static final double UPPER_BEGINNER_PRICE = 180;
    private static final double BEGINNER_PRICE = 150;
    private static final double MIN_PRICE = 100;
    private static final double STANDARD_SIZE = 30;
    private List<Pizza> pizzas = new ArrayList<>();

    public PizzaCooker(String name, double experience, int age, List<Pizza> pizzas)
            throws NotEnoughExperienceException {
        super(name, experience, age);
        this.pizzas = pizzas;
    }

    public PizzaCooker(String name, double experience, int age)
            throws NotEnoughExperienceException {
        super(name, experience, age);
    }

    public List<Pizza> work(List<Pizza> pizzas) {
        for (Pizza pizza : pizzas) {
            setPrice(pizza);
        }
        System.out.println("\nThe pizzas have been cooked. Info about them: ");
        return pizzas;
    }


    @Override
    public Pizza work(Pizza pizza) {
        setPrice(pizza);
        System.out.println("\nThe pizzas have been cooked. Info about them: ");
        return pizza;
    }

    //Метод для встановлення ціни на піцу
    private void setPrice(Pizza pizza) {
        Filling filling = pizza.getFilling();
        if (filling.getMeat() != null && filling.getCheese() != null
                && filling.getVegetables() != null && pizza.getSize() > STANDARD_SIZE) {
            pizza.setPrice(MAX_PRICE);
        } else if (filling.getMeat() != null && filling.getCheese() != null
                && filling.getVegetables() != null && pizza.getSize() < STANDARD_SIZE) {
            pizza.setPrice(UPPER_INTERMEDIATE_PRICE);
        } else if (filling.getMeat() != null && filling.getCheese() != null
                && pizza.getSize() > STANDARD_SIZE) {
            pizza.setPrice(INTERMEDIATE_PRICE);
        } else if (filling.getMeat() != null && filling.getCheese() != null
                && pizza.getSize() < STANDARD_SIZE) {
            pizza.setPrice(UPPER_BEGINNER_PRICE);
        } else if (pizza.getSize() > STANDARD_SIZE) {
            pizza.setPrice(BEGINNER_PRICE);
        } else {
            pizza.setPrice(MIN_PRICE);
        }
    }
}
