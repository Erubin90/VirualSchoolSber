/**
 * A class that describes the properties and actions of a {@code Penguin}
 * <p>
 * Class {@code Penguin} extend class {@code Animal} and implements interface {@code Condition}, {@code Communication}
 * <p>
 * from class Animal override methods:
 * String   getName()                   returning the name {@code Penguin};
 * void     info()                      displays brief information about {@code Penguin};
 * void     printAnimal()               displays a picture of a {@code Penguin} on the screen;
 * void     printAnimal(int count)      displays the image of a {@code Penguin} the specified
 *                                      number of times.
 * <p>
 * from interface Communication:
 * void     say()                       displays the sound of a {@code Penguin} on the screen.
 * void     setName(String name)
 * <p>
 * from interface Communication:
 * void     feed(String food)           Feed the animal. Displays the error {@link NotTheRightFoodException}
 *                                      eating the argument {@code food} does not match its
 *                                      {@code likeFood};
 * void     movement(int meter)         Moving the animal to a certain distance. Displays the error;
 *                                      {@link NotEnoughStaminaException} if the specified distance {@code meter}
 *                                      is greater than the {@code Penguin} can pass with the current saturation.
 */

package com.zoo.animal;

import com.zoo.exception.animal.NotEnoughStaminaException;
import com.zoo.exception.animal.NotTheRightFoodException;

public class Penguin extends Animal implements Condition, Communication {
    private String name;
    private final String SAY = "Yyyyaayr";
    private int saturation = 100;
    private int energyСonsumption = 2;
    private  String typeOfFood = "Herbivorous";
    private String likeFood = "fish";

    public Penguin() {

    }

    public Penguin(String name) {
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
        System.out.println("The penguins are a family of flightless seabirds, the only modern one in the order Sphenisciformes.");
        System.out.println(typeOfFood + ".\nHeight - 0,5 — 1,3m.\nWeight - 2.5 - 23 kg.\nSpeed - 2 - 9 km\\h.");
        System.out.println("Penguins live in the open sea of the Southern Hemisphere: in the coastal waters of " +
                "Antarctica, New Zealand, southern Australia, South Africa, along the entire coast of South America " +
                "from the Falkland Islands to Peru, on the Galapagos Islands near the equator.");
    }

    @Override
    public void printAnimal() {
        System.out.println(
                "Картинка пингвина"
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
