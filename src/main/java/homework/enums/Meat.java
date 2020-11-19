package homework.enums;

import lombok.ToString;

@ToString
public enum Meat {
    CHICKEN(150), SAUSAGES;
    private double calories;

    Meat(double calories) {
        this.calories = calories;
    }// конструктор із  додатковим параметром - калорійність

    Meat() {
    }

    public static String showMeatEnum() {// власний метод для того, щоб не використовувати конкатенацію строк
        System.out.print("Meat enum: ");
        StringBuilder stringBuilder = new StringBuilder();
        for (Meat meat : Meat.values()) {
            if (meat.calories != 0) {
                stringBuilder.append(meat)
                        .append(" calories: ")
                        .append(meat.calories)
                        .append("; ");
            } else {
                stringBuilder.append(meat);
            }
        }
        return stringBuilder.substring(0, stringBuilder.length()  - 1);
    }
}
