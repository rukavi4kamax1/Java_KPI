package homework;

import homework.exception.NotEnoughExperienceException;

public abstract class Employee<T> {
    private String name;
    private double experience;
    private int age;

    public Employee(String name, double experience, int age) throws NotEnoughExperienceException {
        // використання власного NotEnoughExperienceException
        // Exception наслідується від RuntimeException, тому його обробляти не обов'язково
        if (experience < 2) {
            throw new NotEnoughExperienceException("Experience should be not less than 2 years");
        }
        this.name = name;
        this.experience = experience;
        this.age = age;
    }

    public Employee() {
    }

    public T work(T commitment){
        return null;
    }
}
