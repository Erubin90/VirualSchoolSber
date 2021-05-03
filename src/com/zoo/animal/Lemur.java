/**
 * A class that describes the properties and actions of a {@code Lemur}
 * <p>
 * Class {@code Lemur} extend class {@code Animal} and implements interface {@code Condition}, {@code Communication}
 * <p>
 * from class Animal override methods:
 * String   getName()                   returning the name {@code Lemur};
 * void     info()                      displays brief information about {@code Lemur};
 * void     printAnimal()               displays a picture of a {@code Lemur} on the screen;
 * void     printAnimal(int count)      displays the image of a {@code Lemur} the specified
 *                                      number of times.
 * <p>
 * from interface Communication:
 * void     say()                       displays the sound of a {@code Lemur} on the screen.
 * void     setName(String name)
 * <p>
 * from interface Communication:
 * void     feed(String food)           Feed the animal. Displays the error {@link NotTheRightFoodException}
 *                                      eating the argument {@code food} does not match its
 *                                      {@code likeFood};
 * void     movement(int meter)         Moving the animal to a certain distance. Displays the error;
 *                                      {@link NotEnoughStaminaException} if the specified distance {@code meter}
 *                                      is greater than the {@code Lemur} can pass with the current saturation.
 */

package com.zoo.animal;

import com.zoo.exception.animal.NotEnoughStaminaException;
import com.zoo.exception.animal.NotTheRightFoodException;

public class Lemur extends Animal implements Condition, Communication {
    private String name;
    private final String SAY = "Auh'";
    private int saturation = 100;
    private int energyСonsumption = 1;
    private final String typeOfFood = "Herbivorous";
    private String likeFood = "geaves";

    public Lemur() {

    }

    public Lemur(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println(SAY);
    }

    public void feed(String food) throws NotTheRightFoodException {
        if (this.likeFood.equals(food)) {
            saturation += 10;
            System.out.println(name + " " + SAY);
        }
        else {
            throw new NotTheRightFoodException("You gave the " + food + ", and the " + name + " eats the " + likeFood);
        }
    }

    public void movement(int meter) throws NotEnoughStaminaException {
        meter = Math.abs(meter);
        if ((saturation -= energyСonsumption * meter) > 10) {
            saturation -= energyСonsumption * meter;
            System.out.println(name + " moved over " + meter);
        } else {
            throw  new NotEnoughStaminaException(name + " not enough stamina to walk " + meter + ".");
        }

    }

    public void saturationLevel() {
        System.out.printf("Name - %s, saturationLevel - %s\n", name, saturation);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void info() {
        System.out.println("Lemuriformes, or lemurs, are an infra-order of primates from the suborder Strepsirrhini. It unites all the members of the group living in Madagascar.");
        System.out.println(typeOfFood + ".\nHeight - 0,14 — 1,2m.\nWeight - 0.03 - 10 kg.\n");
        System.out.println("Place of residence Madagascar.");
    }

    @Override
    public void printAnimal() {
        System.out.println(
                "Картинка лимура"
        );
    }

    @Override
    public void printAnimal(int count) {
        while (count > 0) {
            printAnimal();
            count--;
        }
    }
}
