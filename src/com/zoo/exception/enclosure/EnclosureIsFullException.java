package com.zoo.exception.enclosure;

import com.zoo.exception.ZooException;

public class EnclosureIsFullException extends ZooException {

    public EnclosureIsFullException(String message) {
        super(message);
    }
}
