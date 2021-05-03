package com.zoo;

import com.zoo.exception.*;
import com.zoo.exception.enclosure.*;
import com.zoo.exception.zoo.*;
import java.util.LinkedList;
import java.util.List;

public class Zoo {
    private String name;
    private int maxCountEnclosure;
    private List<Enclosure> enclosure = new LinkedList<>();

    Zoo () {

    }

    public Zoo(String name, int maxCountEnclosure) {
        if (maxCountEnclosure > 0) {
            this.name = name;
            this.maxCountEnclosure = maxCountEnclosure;
        }
        else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    maxCountEnclosure);
        }
    }

    public void addEnclosure(Enclosure addEnclosure) throws ZooException {
        if (!addEnclosure.getMaster()) {
            if (maxCountEnclosure > enclosure.size()) {
                enclosure.add(addEnclosure);
                addEnclosure.setNameMaster(name);
                addEnclosure.setMaster(true);
                System.out.println(addEnclosure.getName() + " added to " + name);
            }
            else {
                throw new ZooIsFullEnclosuresException("In the zoo \"" + name +
                        "\" there is no place for enclosures" + addEnclosure.getName());
            }
        }
        else {
            throw new EnclosureHasMasterException("This enclosure belongs to " + addEnclosure.getNameMaster());
        }
    }

    public void removeEnclosure(Enclosure removeEnclosure) throws ZooException {
        if (removeEnclosure.getNameMaster().equals(name)) {
            if (enclosure.size() > 0) {
                if (enclosure.remove(removeEnclosure)) {
                    System.out.println(removeEnclosure.getName() + " remove to " + name);
                }
                else {
                    throw new EnclosureNotInZooException("In the zoo \"" + name + "\" there are no enclosure " + removeEnclosure.getName());
                }
            }
            else {
                throw new ZooIsEmptyException("In the zoo \"" + name + "\" there are no enclosures");
            }
        }
        else {
            throw new EnclosureHasDifferentMasterException("The enclosure belongs to" + removeEnclosure.getNameMaster());
        }
    }
}
