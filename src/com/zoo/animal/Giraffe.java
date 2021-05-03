/**
 * A class that describes the properties and actions of a {@code Giraffe}
 * <p>
 * Class {@code Giraffe} extend class {@code Animal} and implements interface {@code Condition}, {@code Communication}
 * <p>
 * from class Animal override methods:
 * String   getName()                   returning the name {@code Giraffe};
 * void     info()                      displays brief information about {@code Giraffe};
 * void     printAnimal()               displays a picture of a {@code Giraffe} on the screen;
 * void     printAnimal(int count)      displays the image of a {@code Giraffe} the specified
 *                                      number of times.
 * <p>
 * from interface Communication:
 * void     say()                       displays the sound of a {@code Giraffe} on the screen.
 * void     setName(String name)
 * <p>
 * from interface Communication:
 * void     feed(String food)           Feed the animal. Displays the error {@link NotTheRightFoodException}
 *                                      eating the argument {@code food} does not match its
 *                                      {@code likeFood};
 * void     movement(int meter)         Moving the animal to a certain distance. Displays the error;
 *                                      {@link NotEnoughStaminaException} if the specified distance {@code meter}
 *                                      is greater than the {@code Giraffe} can pass with the current saturation.
 */

package com.zoo.animal;

import com.zoo.exception.*;
import com.zoo.exception.animal.NotEnoughStaminaException;
import com.zoo.exception.animal.NotTheRightFoodException;

public class Giraffe extends Animal implements Condition, Communication {
    private String name;
    private final String SAY = "Aahhuu";
    private int saturation = 100;
    private int energyСonsumption = 8;
    private String typeOfFood = "Herbivorous";
    private String likeFood = "leaves";

    public Giraffe() {

    }

    public Giraffe(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println(SAY);
    }

    public void feed(String food) throws ZooException {
        if (this.likeFood.equals(food)) {
            saturation += 10;
            System.out.println(name + " " + SAY);
        }
        else {
            throw new NotTheRightFoodException("You gave the " + food + ", and the "
                    + name + " eats the " + likeFood);
        }
    }

    public void movement(int meter) throws ZooException {
        meter = Math.abs(meter);
        if ((saturation -= energyСonsumption * meter) > 10) {
            saturation -= energyСonsumption * meter;
            System.out.println(name + " moved over " + meter);
        } else {
            throw  new NotEnoughStaminaException(name + " not enough stamina to walk "
                    + meter + ".");
        }

    }

    public void saturationLevel() {
        System.out.printf("Name - %s, saturationLevel - %s\n",
                name, saturation);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void info() {
        System.out.println("The giraffe is a cloven-hoofed mammal of the family Giraffaceae.");
        System.out.println(typeOfFood + ".\nHeight - 5,5 — 6,1 m.\nWeight - 900 — 1200 kg.\nSpeed - 55 km\\h.");
        System.out.println("Giraffes live in the savannas of Africa. " +
                "Today, they can only be found south and southeast of the Sahara, " +
                "primarily in the savannas of Eastern and Southern Africa.");
        System.out.println();
    }

    @Override
    public void printAnimal() {
        System.out.println(
                "　　八八\n" +
                " ︹/　#\\︹\n" +
                "'ーe　e;ー'\n" +
                "  |。。#）\n" +
                "  \\＿／|   " + SAY + "\n" +
                " 　 |＃|\n" +
                "  　|　|\n" +
                " 　 )＃(\n" +
                "　 ／＃  ＼\n" +
                " （ #  ＃ ＼___/\n" +
                "  \\＃||　/　  　）\n" +
                "   \\# ||　/^(　/\n" +
                " 　 )｜ ) | ｜＼\\\n" +
                "  （＿)(__)（(＿\\"
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

