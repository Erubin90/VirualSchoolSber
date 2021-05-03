package com.zoo.exception.enclosure;

import com.zoo.exception.ZooException;

public class AnimaIsNotInEnclosureException extends ZooException {
    public AnimaIsNotInEnclosureException(String message) {
        super(message);
    }
}
