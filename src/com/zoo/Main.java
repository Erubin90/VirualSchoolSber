package com.zoo;

import com.zoo.animal.*;
import com.zoo.exception.ZooException;

public class Main {
    public static void main(String[] args) {
        Zoo african_animal = new Zoo("African Animal", 5);
        Enclosure averageAnimalEnclosure = new Enclosure("average animal", 4);

        var giraffe = new Giraffe("Melman");
        var lion = new Lion("Alex");
        var zebra = new Zebra("Martin");
        var hippo = new Hippo("Gloria");
        var penguin = new Penguin("Shkiper");
        var monkey = new Monkey("Jango");
        var lemur = new Lemur("King");

        //Задание 11
        try {
            zebra.feed("grass");
            lion.feed("grass");
        } catch (ZooException ex) {
            ex.printStackTrace();
        }

        try {
            giraffe.movement(5);
            hippo.movement(10);
        } catch (ZooException ex) {
            ex.printStackTrace();
        }


        //Задание 12
        try {
            african_animal.addEnclosure(averageAnimalEnclosure);
            averageAnimalEnclosure.addAnimal(zebra);
            averageAnimalEnclosure.addAnimal(lion);
            averageAnimalEnclosure.removeAnimal(zebra);
            averageAnimalEnclosure.addAnimal(zebra);
        } catch (ZooException ex) {
            ex.printStackTrace();
        }

        try {
            averageAnimalEnclosure.addAnimal(hippo);
            averageAnimalEnclosure.addAnimal(penguin);
            averageAnimalEnclosure.addAnimal(monkey);
        } catch (ZooException ex) {
            ex.printStackTrace();
        }

        //Задание 13
        Enclosure littleEnclosure = new Enclosure("little animal", 3);
        Enclosure bigAnimalEnclosure = new Enclosure("Omnivores animal", 6);
        try {
            african_animal.addEnclosure(littleEnclosure);
            african_animal.removeEnclosure(littleEnclosure);
            bigAnimalEnclosure.addAnimal(zebra);
        } catch (ZooException ex) {
            ex.printStackTrace();
        }
    }
}