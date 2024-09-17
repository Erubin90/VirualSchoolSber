package com.zoo;

import com.zoo.animal.Animal;
import com.zoo.exception.ZooException;
import com.zoo.exception.enclosure.*;
import com.zoo.exception.zoo.EnclosureNotInZooException;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Enclosure {
    private String name;
    private int maxCount;
    private String nameMaster;
    private boolean master = false;
    private Set<Animal> enclosure = new LinkedHashSet<>();

    public Enclosure() {

    }

    public Enclosure (String name, int size) {
        this.name = name;
        this.maxCount = size;
    }

    public String getName() {
        return name;
    }

    public String getNameMaster() {
        return nameMaster;
    }

    public void setNameMaster(String nameZoo) {
        this.nameMaster = nameZoo;
    }

    public boolean getMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public void addAnimal(Animal animal) throws ZooException {
        if (master) {
            if (enclosure.size() < maxCount) {
                if (enclosure.add(animal)) {
                    System.out.println(animal.getName() + " added to the enclosure");
                } else {
                    throw new AnimaIsInEnclosureException(animal.getName() + " exist in " + name);
                }
            } else {
                throw new EnclosureIsFullException("The enclosure is full");
            }
        }
        else {
            throw new EnclosureDontHasMasterException("The enclosure does not belong to the zoo");
        }
    }

    public void removeAnimal(Animal animal) throws ZooException {
        if (enclosure.size() > 0) {
            if (enclosure.remove(animal)) {
                System.out.println(animal.getName() + " remove to " + name);
            }
            else {
                throw new AnimaIsNotInEnclosureException(animal.getName() + " not in " + name);

            }
        }
        else {
            throw new EnclosureIsEmptyException(name + " is empty");
        }
    }
}
