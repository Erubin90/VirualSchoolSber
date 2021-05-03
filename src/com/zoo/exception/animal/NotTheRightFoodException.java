package com.zoo.exception.animal;

import com.zoo.exception.ZooException;

public class NotTheRightFoodException extends ZooException {

    public NotTheRightFoodException(String message) {
        super(message);
    }
}
