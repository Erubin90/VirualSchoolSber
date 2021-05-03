package com.zoo.exception.zoo;

import com.zoo.exception.ZooException;

public class ZooIsEmptyException extends ZooException {
    public ZooIsEmptyException(String message) {
        super(message);
    }
}
