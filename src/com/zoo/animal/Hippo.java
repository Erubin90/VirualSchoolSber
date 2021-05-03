/**
 * A class that describes the properties and actions of a {@code Hippo}
 * <p>
 * Class {@code Hippo} extend class {@code Animal} and implements interface {@code Condition}, {@code Communication}
 * <p>
 * from class Animal override methods:
 * String   getName()                   returning the name {@code Hippo};
 * void     info()                      displays brief information about {@code Hippo};
 * void     printAnimal()               displays a picture of a {@code Hippo} on the screen;
 * void     printAnimal(int count)      displays the image of a {@code Hippo} the specified
 *                                      number of times.
 * <p>
 * from interface Communication:
 * void     say()                       displays the sound of a {@code Hippo} on the screen.
 * void     setName(String name)
 * <p>
 * from interface Communication:
 * void     feed(String food)           Feed the animal. Displays the error {@link NotTheRightFoodException}
 *                                      eating the argument {@code food} does not match its
 *                                      {@code likeFood};
 * void     movement(int meter)         Moving the animal to a certain distance. Displays the error;
 *                                      {@link NotEnoughStaminaException} if the specified distance {@code meter}
 *                                      is greater than the {@code Hippo} can pass with the current saturation.
 */

package com.zoo.animal;

import com.zoo.exception.animal.NotEnoughStaminaException;
import com.zoo.exception.animal.NotTheRightFoodException;

public class Hippo extends Animal implements Condition, Communication {
    private String name;
    private final String SAY = "Hhhhhhh";
    private int saturation = 100;
    private int energyСonsumption = 20;
    private final String typeOfFood = "Herbivorous";
    private String likeFood = "grass";

    public Hippo() {

    }

    public Hippo(String name) {
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
        System.out.println("The hippopotamus is a cloven-hoofed mammal of the hippopotamus family.");
        System.out.println(typeOfFood + ".\nHeight - 1,65 m.\nWeight - 3500 — 4500 kg.\nSpeed - 30 km\\h.");
        System.out.println("The hippo currently lives only in sub-Saharan Africa, except for the island of Madagascar.");
        System.out.println();
    }

    @Override
    public void printAnimal() {
        System.out.println(
                "Картинка гипопотама"
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
