package com.zoo.animal;

import com.zoo.exception.*;

public interface Condition {
    void feed(String food) throws ZooException;
    void saturationLevel();
    void movement(int meter) throws ZooException;
}
