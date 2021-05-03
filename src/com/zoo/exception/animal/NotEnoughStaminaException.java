package com.zoo.exception.animal;

import com.zoo.exception.ZooException;

public class NotEnoughStaminaException extends ZooException {

    public NotEnoughStaminaException(String message) {
        super(message);
    }
}
